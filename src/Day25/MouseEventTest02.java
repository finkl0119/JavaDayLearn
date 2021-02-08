package Day25;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventTest02 extends JFrame {
	JLabel la;
	Container c;

	MouseEventTest02() {
		setTitle("10-9");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		la = new JLabel("No Mouse Event");
		c.add(la);
		setVisible(true);
		MyMouseListener l = new MyMouseListener();
		c.addMouseListener(l);
		c.addMouseMotionListener(l);
	}

	public static void main(String[] args) {
		new MouseEventTest02();
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent arg0) {
			la.setText("mouseDragged(" + arg0.getX() + "," + arg0.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			la.setText("mouseMoved(" + arg0.getX() + "," + arg0.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			c.setBackground(Color.CYAN);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			c.setBackground(Color.MAGENTA);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			la.setText("mousePressed(" + arg0.getX() + "," + arg0.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			la.setText("mouseReleased(" + arg0.getX() + "," + arg0.getY() + ")");
		}
	}

}
