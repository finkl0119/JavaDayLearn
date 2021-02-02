package Day23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HourMinSec extends Thread {
	
	private JLabel jLabel;
	private JLabel jLabel1;

	public HourMinSec(JLabel jLabel, JLabel jLabel1) {
		this.jLabel = jLabel;
		this.jLabel1 = jLabel1;
	}
	
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			jLabel.setText(clockText);
			
			jLabel1 = new JLabel("",JLabel.CENTER);

			if(hour < 13 && hour > 9) {
				if(min < 51 && min > 0) {
					jLabel1.setText("수업 중 입니다.");
				}else {
					jLabel1.setText("쉬는 시간 입니다.");
				}
			}else if(hour < 18 && hour > 13) {
				if(min < 41 && min > 50) {
					jLabel1.setText("수업 중 입니다.");
				}else {
					jLabel1.setText("쉬는 시간 입니다.");
				}
			}else {
				jLabel1.setText("수업 시간이 아닙니다.");
			}
		}
	}
}

public class Thread_Problem13_2 extends JFrame {

	public Thread_Problem13_2() {
		setTitle("디지털 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JLabel jLabel = new JLabel();
		JLabel jLabel1 = new JLabel();
		Color color = (Color.gray);
		
		c.setLayout(new FlowLayout());
		c.add(jLabel);
		c.add(jLabel1);
		
		jLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		jLabel1.setFont(new Font("Gothic", Font.ITALIC, 80));
		jLabel1.setForeground(Color.BLUE);
		c.add(jLabel);
		c.add(jLabel1);

		HourMinSec th = new HourMinSec(jLabel, jLabel1);
		setSize(400, 300);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		new Thread_Problem13_2();
	}
}
