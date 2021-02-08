package Day26;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SRPGameSwing_1 extends JFrame {

	JPanel north = new JPanel(new GridLayout());
	JPanel south = new JPanel(new GridLayout());
	JPanel center = new JPanel(new GridLayout());
	//�ǳ� 3���� ���� �� �� �߾� �׸���
	
	
	ImageIcon scissors_icon = new ImageIcon("images/scissors.jpg");
	JButton scissors = new JButton(scissors_icon);
	ImageIcon rock_icon = new ImageIcon("images/Rock.jpg");
	JButton rock = new JButton(rock_icon);
	ImageIcon paper_icon = new ImageIcon("images/paper.jpg");
	JButton paper = new JButton(paper_icon);
	//��ư 3���� �̹��� �������� ������
	
	ImageIcon result_rock = new ImageIcon("images/Rock.jpg");
	ImageIcon result_scissors = new ImageIcon("images/.scissors.jpg");
	ImageIcon result_paper = new ImageIcon("images/paper.jpg");
	//��� ���� �̹��� �������� ��������ϴ�.
	
	JLabel com_imgLabel = new JLabel();
	JLabel com_result = new JLabel();
	JLabel user_imgLabel = new JLabel();
	JLabel user_result = new JLabel();
	JLabel game_result = new JLabel();
	//��� ���̹��� ��, �İ�� ��, �����̹��� ��, ������� ��,
	//���Ӱ�� ��
	
	public SRPGameSwing_1() {
		
		setTitle("���� ���� �� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		rock.addActionListener(new MyEvent());
		scissors.addActionListener(new MyEvent());
		paper.addActionListener(new MyEvent());
		//��ư 3���� ������ ���� ��ŵ�ϴ�.
		
		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		//�������̾ƿ����� ����ȭ
		
		north.add(rock);
		north.add(scissors);
		north.add(paper);
		//���� �ǳڿ� ��ư 3�� �߰�(����,����,��)
		
		center.add(user_imgLabel);
		center.add(user_result);
		user_result.setOpaque(true);
		center.setBackground(Color.orange);
		user_result.setBackground(Color.orange);
		center.add(com_imgLabel);
		center.add(com_result);
		com_result.setOpaque(true);
		com_result.setBackground(Color.orange);
		//�߾� �����̹���,�������, ���̹���,�İ�� ���� �߰� 
		
		south.add(game_result);
		game_result.setOpaque(true);
		game_result.setBackground(Color.orange);
		//������ ���Ӱ�� ���� �ٿ��ݴϴ�.
		
		setSize(450, 400);
		setVisible(true);
		//ũ��� Visible����
	}
	
	class MyEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Random r = new Random();
			int com = r.nextInt(3);	// ����0, ����1, ��2
			int user;
			
			if(e.getSource() == scissors) {
				user = 0;
			} else if(e.getSource() == rock) {
				user = 1;
			} else {
				user = 2;
			}
			//��ư�Է½� ������ ��ư���� ������ ���ڰ� ������
			if(user == com) {
				game_result.setText("�����ϴ�");
			} else if((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
				game_result.setText("�̰���ϴ�");
			} else {
				game_result.setText("�����ϴ�");
			}
			//���� �̰���� Ȯ��
			com_result.setText("��ǻ��");
			user_result.setText("��");
			//��ǻ�� �� �󺧿� ���
			
			if(com == 0) {
				com_imgLabel.setIcon(result_scissors);
			} else if(com == 1) {
				com_imgLabel.setIcon(result_rock);
			} else {
				com_imgLabel.setIcon(result_paper);
			}
			
			if(user == 0) {
				user_imgLabel.setIcon(result_scissors);
			} else if(user == 1) {
				user_imgLabel.setIcon(result_rock);
			} else {
				user_imgLabel.setIcon(result_paper);
			}
			//�̹����� Set
		}
	}

	public static void main(String[] args) {
		new SRPGameSwing_1();
	}
}
