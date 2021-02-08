package Day25;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI_1 extends JFrame {
	
	private int [] changeOperand = new int[10];
	private int firstOperand = 0;
	private int secondOperand = 0;
	private char operator;
	
	//View
	
	private JButton [] btn = new JButton[16];
	private JTextField jTextField_1 = new JTextField(24);
	private JTextField jTextField_2 = new JTextField(24);
	
	public CalculatorGUI_1() {
		this.setTitle("���� ������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(1, 1));
		OnePanel o=new OnePanel();

		c.add(new OnePanel(), BorderLayout.NORTH);
		c.add(new TwoPanel(), BorderLayout.CENTER);
		c.add(new ThreePanel(), BorderLayout.SOUTH);
		
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	private class OnePanel extends JPanel {
		public OnePanel() {
			setBackground(Color.GRAY);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel oneLabel = new JLabel("�����Է�");
			oneLabel.setFont(new Font("�������", Font.BOLD, 20));			
			add(oneLabel);
			add(jTextField_1);
			jTextField_1.setEditable(false);	
		}
	}
	
	private class TwoPanel extends JPanel {
		public TwoPanel() {
			setLayout(new GridLayout(4, 4, 5, 5));
			
			for(int i = 0; i < 10; i++) {
				btn[i] = new JButton(Integer.toString(i));
				btn[i].setFont(new Font("�������", Font.BOLD, 20));
				btn[i].addActionListener(new MyActionListener());
				add(btn[i]);
			}
			
			JButton btn_ce = new JButton("CE");
			JButton btn_calc = new JButton("���");
			JButton btn_add = new JButton("+");
			JButton btn_sub = new JButton("-");
			JButton btn_mul = new JButton("x");
			JButton btn_div = new JButton("/");
			
			btn_ce.addActionListener(new MyActionListener());
			btn_calc.addActionListener(new MyActionListener());
			btn_add.addActionListener(new MyActionListener());
			btn_sub.addActionListener(new MyActionListener());
			btn_mul.addActionListener(new MyActionListener());
			btn_div.addActionListener(new MyActionListener());
			
			btn_ce.setFont(new Font("�������", Font.BOLD, 20));
			btn_calc.setFont(new Font("�������", Font.BOLD, 20));
			btn_add.setFont(new Font("�������", Font.BOLD, 20));
			btn_sub.setFont(new Font("�������", Font.BOLD, 20));
			btn_mul.setFont(new Font("�������", Font.BOLD, 20));
			btn_div.setFont(new Font("�������", Font.BOLD, 20));
			btn_add.setFont(new Font("�������", Font.BOLD, 20));
		
			btn_add.setBackground(Color.CYAN);
			btn_sub.setBackground(Color.CYAN);
			btn_mul.setBackground(Color.CYAN);
			btn_div.setBackground(Color.CYAN);
			
			add(btn_ce);
			add(btn_calc);
			add(btn_add);
			add(btn_sub);
			add(btn_mul);
			add(btn_div);
		}
	}
	
	private class ThreePanel extends JPanel {
		public ThreePanel() {
			setBackground(Color.ORANGE);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel threeLabel = new JLabel("��� ���");
			threeLabel.setFont(new Font("�������", Font.BOLD, 20));
			
			add(threeLabel);
			add(jTextField_2);
			jTextField_2.setEditable(false);
		}
	}
	
	//Controll -> ActionListener
	//� ������ �������� �� ���ۿ� �´� �ൿ�� �ϱ� ���ؼ�
	//ActionListener�� �ʿ�
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//JButton���� ��� ��ư�� ���ȴ��� Ȯ���� ���ؼ� �ʿ�
			int index = 0;  //Second �ǿ����ڸ� ���� �迭�� �ֱ� ���ؼ� �ʿ��� index
			//CE JTextField_1 , JTextField_2��
			//First�ǿ����ڿ� Second�ǿ����ڸ� ��� �ʱ�ȭ�Ѵ�.
			if(btn.getText().equals("CE")) {
				jTextField_1.setText("");
				jTextField_2.setText("");
				firstOperand = 0;
				secondOperand = 0;
			}
			//����� �Ѵ�. ���������� �����ڰ� ������ ������ ���ڸ� ���� 
			//���� �ڸ� 10���ڸ� 100�ڸ� �̷������� �迭�� ������ ���Ŀ� 
			//Second �ǿ����ڿ� ��� ������ �ϰ� �׸��� �����ڸ� ������ �ݺ��� ����
			//First �ǿ����� ������ Second �����ڸ� ������ ������ �Ѵ�.
			//���� ������� JtextField_2 ����� ���ش�.
			else if(btn.getText().equals("���")) {
				String str = jTextField_1.getText();
				for(int i = jTextField_1.getText().length()-1; i >= 0; i--) {
					char c = str.charAt(i);
					
					if(c == '+' || c == '-' || c == 'x' || c == '/') { 
						operator = c; // +
						jTextField_1.setText("");
						break;
					}
					
					else {
						changeOperand[index] = Integer.parseInt(Character.toString(c));
						secondOperand += changeOperand[index]*(Math.pow(10, index));
						
						index++;
					}
				}
				
				switch(operator) {
					case '+':
							jTextField_2.setText(Integer.toString(firstOperand + secondOperand));
							break;
					case '-':
							jTextField_2.setText(Integer.toString(firstOperand - secondOperand));
							break;
					case 'x':
							jTextField_2.setText(Integer.toString(firstOperand * secondOperand));
							break;
					case '/':
							jTextField_2.setText(Double.toString(firstOperand / secondOperand));
							break;
				}
				//+ - * / �϶� ����Ǵ� ��� ù �ǿ����ڸ� �����Ѵ�. + - * / ���
			} else if(btn.getText().equals("+") | btn.getText().equals("-") | btn.getText().equals("x") | btn.getText().equals("/")) {

				firstOperand = Integer.parseInt(jTextField_1.getText());
		
				switch(btn.getText()) {
					case "+"://100+
							jTextField_1.setText(jTextField_1.getText() + "+");
							break;
					case "-":
							jTextField_1.setText(jTextField_1.getText() + "-");
							break;
					case "x":
							jTextField_1.setText(jTextField_1.getText() + "x");
							break;
					case "/":
							jTextField_1.setText(jTextField_1.getText() + "/");
							break;
				}
				//0~9���� ��ư �Է½�
			} else {
				for(int i=0; i<10; i++) {
					if(btn.getText().equals(Integer.toString(i))) {
						jTextField_1.setText(jTextField_1.getText() + Integer.toString(i));
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		new CalculatorGUI_1();
	}

}
