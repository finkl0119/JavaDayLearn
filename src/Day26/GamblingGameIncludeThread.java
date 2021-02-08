package Day26;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GamblingThread extends Thread {
	boolean gam = false;
	JLabel la[];
	JLabel result;

	public GamblingThread(JLabel la[], JLabel result) {
		this.la = la;
		this.result = result;
	}

	synchronized public void waitForGambling() {
		if (!gam)
			try {
				this.wait();
			} catch (InterruptedException e) {
				return;
			}
	}

	synchronized public void startGambling() {
		gam = true;
		this.notify();
	}

	public void run() {
		
		ImageIcon[] imgIcon = new ImageIcon[3];
		imgIcon[0] = new ImageIcon("C:\\Users\\ici-805-05\\Desktop\\가위바위보_유형민\\scissors.PNG");
		imgIcon[1] = new ImageIcon("C:\\Users\\ici-805-05\\Desktop\\가위바위보_유형민\\rock.PNG");
		imgIcon[2] = new ImageIcon("C:\\Users\\ici-805-05\\Desktop\\가위바위보_유형민\\paper.PNG");
		
		while (true) {
			waitForGambling();
			for (int i = 0; i < 3; i++) {
//				int x = (int) (Math.random() * 5);
				la[i].setIcon(imgIcon[i]);
//				la[i].setText(Integer.toString(x));
				try {
					sleep(200);

				} catch (InterruptedException e) {
					return;
				}
			}
			gam = false;
			la[0].setIcon(imgIcon[0]);
			int x = Integer.parseInt(la[0].getText());
			int y = Integer.parseInt(la[1].getText());
			int z = Integer.parseInt(la[2].getText());
			if (x == y && y == z)
				result.setText("축하합니다!!");
			else
				result.setText("아쉽군요");

		}
	}
}

class GamblingPanel extends JPanel {
	JLabel la[];
	JLabel result;
	GamblingThread th;

	public GamblingPanel(GamblingThread th, JLabel la[], JLabel result) {

		this.th = th;
		this.la = la;
		this.result = result;
		setLayout(null);
		for (int i = 0; i < 3; i++) {
			la[i].setFont(new Font("Gothic", Font.ITALIC, 30));
			la[i].setForeground(Color.YELLOW);
			JPanel pa = new JPanel();
			pa.add(la[i]);
			pa.setBackground(Color.MAGENTA);
			pa.setSize(100, 50);
			pa.setLocation(110 * (i + 1), 80);
			add(pa);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					th.startGambling();
				}
			});
			pa.requestFocus();
		}
		result.setFont(new Font("Gothic", Font.BOLD, 20));

		add(result);
		result.setSize(500, 20);
		result.setLocation(110, 200);
	}
}

public class GamblingGameIncludeThread extends JFrame {

	JLabel la[] = new JLabel[3];
	JLabel result = new JLabel("마우스를 클릭할 때 마다 게임합니다.");

	public GamblingGameIncludeThread() {
		setTitle("스레드를 가진 겜블링");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		la[0] = new JLabel(Integer.toString(0));
		la[1] = new JLabel(Integer.toString(0));
		la[2] = new JLabel(Integer.toString(0));
		GamblingThread th = new GamblingThread(la, result);
		th.start();
		setContentPane(new GamblingPanel(th, la, result));

		setSize(600, 500);
		setVisible(true);
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();

	}

	public static void main(String[] args) {
		new GamblingGameIncludeThread();
	}
}

