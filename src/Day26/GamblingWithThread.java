package Day26;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamblingWithThread extends JFrame {
	private JLabel result = new JLabel("���콺�� Ŭ���� �� ���� �����մϴ�."); // ����� ����ϴ� ���̺�
	public GamblingWithThread() {
		super("�����带 ���� �׺�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel()); // GamePanel�� ����Ʈ������ ����Ѵ�. 

		setSize(600,400);
		setVisible(true);		
	}

	// ����Ʈ���� ���Ǵ� �г� Ŭ����
	class GamePanel extends JPanel {
		private boolean checking = true;
		private JLabel [] label = new JLabel [3]; // 3 ���� ���� ǥ���ϴ� ���̺� �迭
		private GamblingThread thread;
		private GamblingThread thread1;
		private GamblingThread thread2;
		private ImageIcon [] images = {
				new ImageIcon("images/������.jpg"),
				new ImageIcon("images/�����.jpg"),
				new ImageIcon("images/����.jpg"),
				new ImageIcon("images/������.jpg"),
				new ImageIcon("images/�䳢.jpg")
		};

		public GamePanel() {
			setLayout(null); // ��ġ�����ڸ� ������� �ʰ� ���� ��ġ�� ������Ʈ�� ��ġ�Ѵ�.

			// 3 ���� ���̺��� �����Ͽ� �����̳ʿ� �ܴ�.
			for(int i=0; i<label.length; i++) {
				label[i] = new JLabel(images[0]); // ���̺� ����
				label[i].setSize(100, 100); // ���̺� ũ��
				label[i].setLocation(50+150*i, 50); // ���̺� ��ġ
				label[i].setHorizontalAlignment(JLabel.CENTER); // ���̺� ��µǴ� ���� ���͸�
				label[i].setOpaque(true); // ���̺� ���� ������ �����ϵ��� �Ѵ�.
				label[i].setBackground(Color.MAGENTA); // ���̺��� ������ �����Ѵ�.
				label[i].setForeground(Color.YELLOW); //���̺��� ���� ���� �����Ѵ�.				
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30)); // ���̺� ������ ��Ʈ�� �����Ѵ�.	
				add(label[i]); // ���̺��� �����Ѵ�.
			}

			// ����� ����� ���̺��� �����ϰ� �����̳ʿ� �����Ѵ�.
			result.setHorizontalAlignment(JLabel.CENTER); // ���̺� ��µǴ� ���� ���͸�
			result.setSize(400, 300);
			result.setLocation(30, 120);
			add(result);
			thread = new GamblingThread(label[0],200); // ���� ������
			thread1 = new GamblingThread(label[1],300); // ���� ������
			thread2 = new GamblingThread(label[2],400); // ���� ������
			thread.start();
			thread1.start();
			thread2.start();

			// ���콺 �����ʸ� �����Ѵ�.
			addMouseListener(new MouseAdapter() { // MouseAdapter �̿�
				@Override
				public void mousePressed(MouseEvent e) {
					if(checking)
					{
						
						System.out.println("aa");
						if(thread.isReady()) // �����尡 ���� ���̸� �׳� ����
							thread.startGambling();
						if(thread1.isReady()) // �����尡 ���� ���̸� �׳� ����
							thread1.startGambling();
						if(thread2.isReady()) // �����尡 ���� ���̸� �׳� ����
							thread2.startGambling();
						checking = false;
					}
					else
					{
						System.out.println(thread.count+","+thread1.count+","+thread2.count);
						if(thread.count == thread1.count && 
								thread1.count == thread2.count)
						{
							result.setText("�����մϴ�.");
						}
						else
						{
							result.setText("�ƽ����ϴ�.");
						}
						checking = true;
						thread.stop();
						thread1.stop();
						thread2.stop();
						
					}
				}
			});
		}
	}

	class GamblingThread extends Thread {
		int count = 0;
		private ImageIcon [] images = {
				new ImageIcon("C:\\\\Users\\\\ici805-0\\\\Downloads\\\\��ǰJAVA���α׷���(����4��)_�н��ڿ�[20200827]\\\\�������� �ǽ� Ȧ�� ����\\\\13��\\\\chap13-prac09\\\\src\\\\images\\\\������.jpg"),
				new ImageIcon("C:\\\\Users\\\\ici805-0\\\\Downloads\\\\��ǰJAVA���α׷���(����4��)_�н��ڿ�[20200827]\\\\�������� �ǽ� Ȧ�� ����\\\\13��\\\\chap13-prac09\\\\src\\\\images\\\\�����.jpg"),
				new ImageIcon("C:\\\\Users\\\\ici805-0\\\\Downloads\\\\��ǰJAVA���α׷���(����4��)_�н��ڿ�[20200827]\\\\�������� �ǽ� Ȧ�� ����\\\\13��\\\\chap13-prac09\\\\src\\\\images\\\\����.jpg"),
				new ImageIcon("C:\\Users\\ici805-0\\Downloads\\��ǰJAVA���α׷���(����4��)_�н��ڿ�[20200827]\\�������� �ǽ� Ȧ�� ����\\13��\\chap13-prac09\\src\\images\\������.jpg"),
				new ImageIcon("C:\\\\Users\\\\ici805-0\\\\Downloads\\\\��ǰJAVA���α׷���(����4��)_�н��ڿ�[20200827]\\\\�������� �ǽ� Ȧ�� ����\\\\13��\\\\chap13-prac09\\\\src\\\\images\\\\�䳢.jpg")
		};
		private JLabel label; //���� ���ڸ� ����ϴ� ���̺�
		private long delay = 0; // ���� �ð��� �ʱ갪 = 200

		private boolean gambling = false; // ������ �� ������. �ʱ갪 = false


		public GamblingThread(JLabel label, long delay) {
			this.label = label;
			this.delay = delay;
		}

		boolean isReady() {
			return !gambling; // ���� ���̸� �غ���� �ʾ���
		}

		synchronized public void waitForGambling() {
			if(!gambling) // ���콺 Ŭ���� ���� gambling�� true�� �ƴϸ� ��ٸ�
				try {
					this.wait();
				} catch (InterruptedException e) { return; }
		}

		synchronized public void startGambling() {
			gambling = true; // ���콺 Ŭ������ �����尡 ������ �����ϵ��� ����
			this.notify(); // ��ٸ��� �����带 ����	
		}		

		@Override
		public void run() {
			while(true) {
				waitForGambling();
				try {
					while(true)
					{
						if(count == 5)
						{
							count = 0;
						}
						sleep(delay);
						label.setIcon(images[count++]);
						gambling = false;
					}

				} catch (InterruptedException e) { return; }
			}
		}	
	}

	public static void main(String[] args) {
		new GamblingWithThread();
	}
}

