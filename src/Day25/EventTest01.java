package Day25;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventTest01 extends JFrame {
	JButton btn;

	EventTest01() {
		setTitle("이벤트처리");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		btn = new JButton("Action");
		c.add(btn);
		setVisible(true);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton b = (JButton) arg0.getSource();
				if (b.getText().equals("Action"))
					b.setText("액션");
				else
					b.setText("Action");
			}
		});
	}

	public static void main(String[] args) {
		new EventTest01();
	}

}
