package Day26;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * <pre>
 * Day26
 * SBPGameSwing.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 2. 8.	
 *
 */
public class SRPGameSwing extends JFrame {

	JButton[] jbutton = new JButton[3];
	String[] kinds = { "scissors", "rock", "paper" };
	ImageIcon[] imgIcon = new ImageIcon[3];
	JLabel me = new JLabel("me");
	JLabel com = new JLabel("com");
	
	JLabel meImg = new JLabel();
	JLabel comImg = new JLabel();
	
	JLabel result = new JLabel();
	JLabel label = new JLabel();

	class OnePanel extends JPanel {
		public OnePanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());

			for (int i = 0; i < 3; i++) {
				jbutton[i] = new JButton(imgIcon[i]);
				add(jbutton[i]);
				jbutton[i].addMouseListener(new MyMouseListener());
			}

		}
	}

	class TwoPanel extends JPanel {
		public TwoPanel() {
			setBackground(Color.ORANGE);
			setLayout(new FlowLayout());
			
			add(meImg);
			add(me);
			add(comImg, BorderLayout.CENTER);
			add(com, BorderLayout.CENTER);
			
			result.setForeground(Color.RED);
			add(result, BorderLayout.CENTER);
		}
	}

	public SRPGameSwing() {
		setTitle("가위 바위 보 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.YELLOW);

		imgIcon[0] = new ImageIcon("C:\\Users\\ici-805-05\\Desktop\\가위바위보_유형민\\scissors.PNG");
		imgIcon[1] = new ImageIcon("C:\\Users\\ici-805-05\\Desktop\\가위바위보_유형민\\rock.PNG");
		imgIcon[2] = new ImageIcon("C:\\Users\\ici-805-05\\Desktop\\가위바위보_유형민\\paper.PNG");

		c.add(new OnePanel(), BorderLayout.NORTH);
		c.add(new TwoPanel(), BorderLayout.CENTER);

		setSize(600, 500);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			int number = (int) (Math.random() * 3);
			JButton button = (JButton) e.getSource();
			
			if (jbutton[0] == button) {
				
				meImg.setIcon(imgIcon[0]);
				comImg.setIcon(imgIcon[number]);
				
				if (number == 0) {
					result.setText("Same !!!");
				}else if (number == 1) {
					result.setText("Computer !!!");
				}else {
					result.setText("Me !!!");
				}		
				
			} else if (jbutton[1] == button) {
				
				meImg.setIcon(imgIcon[1]);
				comImg.setIcon(imgIcon[number]);
				
				if (number == 0) {
					result.setText("Me !!!");
				} else if (number == 1) {
					result.setText("Same !!!");
				} else {
					result.setText("Computer !!!");
				}
					
			} else if (jbutton[2] == button) {
				
				meImg.setIcon(imgIcon[2]);
				comImg.setIcon(imgIcon[number]);
				
				if (number == 0) {
					result.setText("Computer !!!");
				} else if (number == 1) {
					result.setText("Me !!!");
				} else {
					result.setText("Same !!!");
				}
					
			}
		}
	}

	public static void main(String[] args) {
		new SRPGameSwing();
	}
}
