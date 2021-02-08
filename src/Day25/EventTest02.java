package Day25;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventTest02 extends JFrame {
	JTextField tf1, tf2;
	JLabel la;
	JButton btn;

	EventTest02() {
		setTitle("이벤트처리");
		setSize(200, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		tf1 = new JTextField(10);
		p1.add(new JLabel("숫자1: "));
		p1.add(tf1);
		tf2 = new JTextField(10);
		p2.add(new JLabel("숫자2: "));
		p2.add(tf2);
		la = new JLabel("처리결과");
		p3.add(new JLabel("계산결과"));
		p3.add(la);
		btn = new JButton("더하기");
		c.add(p1);
		c.add(p2);
		c.add(btn);
		c.add(p3);
		setVisible(true);
		btn.addActionListener(new MyAction());
	}

	public static void main(String[] args) {
		new EventTest02();
	}

	class MyAction implements ActionListener {
		JTextField tf1, tf2;
		JLabel la;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			la.setText((num1 + num2) + " ");
		}
	}

}
