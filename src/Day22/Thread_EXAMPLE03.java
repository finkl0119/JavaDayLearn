package Day22;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunable implements Runnable{
	
	private JLabel timerLabel;
	
	public TimerRunable(JLabel timerJLabel) {
		
		this.timerLabel = timerJLabel;
	}
	
	@Override
	public void run() {
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			
		}
	}
	
}

class RunableTimerEx extends JFrame {
	public RunableTimerEx() {
		setTitle("Runable를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC,80));
		c.add(timerLabel);
		
		TimerRunable runable = new TimerRunable(timerLabel);
		Thread th = new Thread(runable);
		
		setSize(250,150);
		setVisible(true);
		
		th.start();
	}
}




public class Thread_EXAMPLE03 {

	public static void main(String[] args) {
		new RunableTimerEx();

	}

}
