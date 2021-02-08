package Day25;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseTest extends JFrame implements MouseListener {
	JLabel la;
	Container c;

	MouseTest() {
		setTitle("Mouse 이벤트예제");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		la = new JLabel("Hello");
		la.setSize(50, 20);
		la.setLocation(10, 10);
		c.add(la);
		setVisible(true);
		c.addMouseListener(this);
	}

	public static void main(String[] args) {
		new MouseTest();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		la.setLocation(x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
