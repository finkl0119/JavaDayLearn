package Day25;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class p1008 extends JFrame {
	JLabel la;
	int x = 50, y = 50;

	p1008() {
		setTitle("10장 8번 예제");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		la = new JLabel("Hello");
		la.setBounds(x, y, 30, 20);
		c.add(la);
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch ((int) e.getKeyCode()) {
				case KeyEvent.VK_UP:
					if (y - 10 < 0)
						y = 0;
					else
						y -= 10;
					break;
				case KeyEvent.VK_DOWN:
					if (y + 10 > c.getHeight() - 20)
						y = c.getHeight() - 20;
					else
						y += 10;
					break;
				case KeyEvent.VK_LEFT:
					if (x - 10 < 0)
						x = 0;
					else
						x -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					if (x + 10 > c.getWidth() - 30)
						x = c.getWidth() - 30;
					else
						x += 10;
				}
				la.setLocation(x, y);
			}
		});
	}

	public static void main(String[] args) {
		new p1008();
	}

}
