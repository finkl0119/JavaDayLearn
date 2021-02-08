package Day25;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEventTest01 extends JFrame implements KeyListener {
	private JLabel[] keyMessage;

	KeyEventTest01() {
		setTitle("keyListener 예제");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(this);
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel("getKeyCode");
		keyMessage[1] = new JLabel("getKeyChar");
		keyMessage[2] = new JLabel("getKeyText");
		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	public static void main(String[] args) {
		new KeyEventTest01();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyCode = arg0.getKeyCode();
		int keyChar = arg0.getKeyChar();
		String keyStr = arg0.getKeyText(keyCode);
		keyMessage[0].setText(keyCode + "");
		keyMessage[1].setText(keyChar + "");
		keyMessage[2].setText(keyStr + "");
	}

	@Override public void keyReleased(KeyEvent arg0) { } @Override public void keyTyped(KeyEvent arg0) { }



}
