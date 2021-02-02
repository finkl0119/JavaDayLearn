package Day23;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Currency;

import javax.swing.JFrame;
import javax.swing.JLabel;

class CurrentTime1 extends Thread {
	private JLabel timerLabel;
	private JLabel brkLabel;
	
	
	public CurrentTime1(JLabel timerLabel, JLabel brkLabel) {
		this.timerLabel = timerLabel;
		this.brkLabel = brkLabel;
	}
	
	public void run() {
			
		while(true) {
			
			Calendar c = Calendar.getInstance();
			
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int sec = c.get(Calendar.SECOND);

			
			timerLabel.setText(hour+":"+min+":"+sec);
			
			
			if((hour==12 && min>=50) || hour==13 && min<=50) {
				brkLabel.setText("���� �ð��Դϴ�.");
			} else if(hour>=9 && 12>=hour) {
				if(min>=50 && 59>min) {
					brkLabel.setText("���� �ð��Դϴ�.");
				} else {
					brkLabel.setText("���� �ð��Դϴ�.");
				}
			} else if(hour>=13 && 18>hour) {
				if(min>=40 && 50>min) {
					brkLabel.setText("���� �ð��Դϴ�.");
				} else {
					brkLabel.setText("���� �ð��Դϴ�.");
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class TH4 extends JFrame{
	
	public TH4() {
		setTitle("������ �ð�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		JLabel brkLabel = new JLabel();
		
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		brkLabel.setFont(new Font("Gothic", Font.ITALIC, 33));
		brkLabel.setForeground(Color.BLUE);
		
		c.add(timerLabel);
		c.add(brkLabel);
		
		CurrentTime1 ct = new CurrentTime1(timerLabel, brkLabel);
		
		setSize(400, 270);
		setVisible(true);
		
		ct.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TH4();

	}
}
