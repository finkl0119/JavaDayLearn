package Day27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class RCom1 { 
	int com[]; //정수형 com이라는 배열 선언
	public RCom1() { // RCom 인자를 받지 않는 생성자
		// TODO Auto-generated constructor stub 
		com = new int[3]; // com 변수에 정수형 배열 객체를 생성 후에 대입
		com[0] =(int)(Math.random()*9+1); // com에 0번 인덱스에 1~9까지 중에 랜덤 값을 대입
		com[1] =(int)(Math.random()*9+1); // com에 1번 인덱스에 1~9까지 중에 랜덤 값을 대입

		while(com[0] == com[1]) // com에 0번 인덱스와 1번 인덱스가 같으면 반복
		{ 
			com[1] =(int)(Math.random()*9+1); // com에 1번 인덱스에 1~9까지 중에 랜덤 값을 대입 
		}
		com[2] =(int)(Math.random()*9+1); // com에 2번 인덱스에 1~9까지 중에 랜덤 값을 대입
		while(com[0] == com[2] || com[1] == com[2])
		// com에 0번 인덱스와 2번 인덱스가 같으면 반복 또는 com에 1번 인덱스와 2번 인덱스가 같으면 반복
		{ 
			com[2] =(int)(Math.random()*9+1); //com에 2번 인덱스에 1~9까지 중에 랜덤 값을 대입
		}
	}
	
	public int[] getCom()
	//정수형 배열을 리턴하고 인자를 아무것도 받지않은 getCom 함수
	{ 
		return com; // com 변수를 리턴 
	}
		
}

class UserCheck1 { 
	int strike; // 정수 변수 strike 선언
	int ball; // 정수 변수 ball 선언
	boolean out; // 불 변수 out 선언
	public UserCheck1(int[] com, int[] user) {
	//UserCheck 생성자로 인자로 정수형 배열 두개를 받는다.
		// TODO Auto-generated constructor stub
		for(int i = 0; i<3 ; i++) 
		// 정수형 i는 초기화가 0이고 i가 3보다 작으면 반복하고 반복시 i는 1씩 증가한다.
		{ 
			for(int j = 0; j<3 ; j++)
			// 정수형 j는 초기화가 0이고 j가 3보다 작으면 반복하고 반복시 j는 1씩 증가한다.
			{
				if(com[i] == user[j])
				// com의 i인덱스 값과 user의 j인덱스 값이 같으면 아래 명령어 실행
				{
	               if(i==j)
	            	 //정수 값 i와 j가 같으면 아래 명령어 실행
	            	   strike++; // 정수 strike를 1증가
	               else
	            	// 위에 조건이 아니면 실행
	            	   ball++; // 정수 ball을 1증가
				}
				
			}

		}	
	}
	
	public int getStrike()//정수를 반환하고 인자가 없는 getStrike 함수
	{ 
		return strike; // strike 변수 값을 리턴 
	}

	public int getBall()//정수를 반환하고 인자가 없는 getBall 함수
	{ 
		return ball; // ball 변수 값을 리턴 
	}

	public boolean getOut() //bool를 반환하고 인자가 없는 getOut 함수
	{ 
		if(strike == 0 && ball== 0)
		//변수 strike가 0이고 변수 ball이 0이면 아래 명령어 실행
			return true; //true을 리턴
		else //위에 조건이 아니면 아래 명령어 실행
			return false; //false를 리턴
	}	
}


class MyPanel3 extends JPanel{ 
	JTextField jt; //JTextField형 변수 jt 선언 
	int strike = 0; //정수형 strike 변수를 0으로 초기화 
	int ball = 0; //정수형 ball 변수를 0으로 초기화 
	boolean out = false; //bool형 out 변수를 false로 초기화 
	void setData(int strike, int ball, boolean out) //리턴이 없고 인자를 정수형 2개와 bool형 1개를 받는 setData 함수 
	{ 
		this.strike = strike; // 내 strike 변수에 인자 strike를 대입 
		this.ball = ball; // 내 ball 변수에 인자 ball을 대입 
		this.out = out; // 내 out 변수에 인자 out를 대입 
	} 
	@Override public void paintComponent(Graphics g){ 
		//JPanel클래스에 있는 paintComponent 함수를 오버라이딩 
		//리턴이 없고 Graphics를 인자로 받는 paintComponet함수 
		super.paintComponent(g); //부모 paintComponet에 인자 g를 대입해서 호출 
		g.setFont(new Font("맑음고딕",Font.BOLD,20)); 
		//Graphics에 setFont 함수 호출 
		//호출신 Font 객체를 생성해서 호출 
		//Font를 생성할때 "맑은 고딕"과 BOLD 사이즈는 20 
		if(strike == 3) 
			//strike의 값이 3이면 아래 명령어 실행 
		{ 
			g.setFont(new Font("맑음고딕",Font.BOLD,60)); //Font를 생성할때 "맑은 고딕"과 BOLD 사이즈는 60 
			g.drawString("Home Run!!!!", 30, 180); //"Home Run!!!!"문장을 x : 30 y : 100에 문자열을 그린다. 
		} else { //위 조건이 아니면 아래 명령어 실행 
			if(strike == 0) //변수 strike가 0이면 아래 명령어 실행 
			{ 
				g.setColor(Color.RED); //컬러 레드 
				g.drawString("S", 30, 222); //"S"를 x : 30 y : 222에 문자열을 그린다. 
				g.drawOval(50,200,30,30); //비워 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다. 
				g.drawOval(90,200,30,30); //비워 있는 원을 x : 90 y: 200에 30사이즈에 빈원을 그린다. 
			} else if(strike == 1) //변수 strike가 1이면 아래 명령어 실행 
			{ 
				g.setColor(Color.RED); //컬러 레드 
				g.drawString("S", 30, 222); //"S"를 x : 30 y : 222에 문자열을 그린다. 
				g.fillOval(50,200,30,30); //꽉차 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다. 
				g.drawOval(90,200,30,30); //비워 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다. 
			} else //위의 두조건이 모두 아니면 아래 명령어 실행 
			{ 
				g.setColor(Color.RED); //컬러 레드 
				g.drawString("S", 30, 222); //"S"를 x : 30 y : 222에 문자열을 그린다. 
				g.fillOval(50,200,30,30); //꽉차 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다. 
				g.fillOval(90,200,30,30); //꽉차 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다. 
			} if(ball == 0) //변수 ball이 0이면 아래 명령어 실행 
			{ 
				g.setColor(Color.BLUE); //컬러 블루 
				g.drawString("B", 30, 262); //"B"를 x : 30 y : 262에 문자열을 그린다. 
				g.drawOval(50,240,30,30); //비워 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다. 
				g.drawOval(90,240,30,30); //비워 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다. 
				g.drawOval(130,240,30,30); //비워 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다. 
			} else if(ball == 1) 
			{ 
				g.setColor(Color.BLUE); //컬러 블루 
				g.drawString("B", 30, 262); //"B"를 x : 30 y : 262에 문자열을 그린다. 
				g.fillOval(50,240,30,30); //꽉차 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다. 
				g.drawOval(90,240,30,30); //비워 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다. 
				g.drawOval(130,240,30,30); //비워 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다. 
			} else if(ball == 2) 
			{ 
				g.setColor(Color.BLUE); //컬러 블루 
				g.drawString("B", 30, 262); //"B"를 x : 30 y : 262에 문자열을 그린다. 
				g.fillOval(50,240,30,30); //꽉차 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다. 
				g.fillOval(90,240,30,30); //꽉차 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다. 
				g.drawOval(130,240,30,30); //비워 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다. 
			} else { 
				g.setColor(Color.BLUE); //컬러 블루 
				g.drawString("B", 30, 262); //"B"를 x : 30 y : 262에 문자열을 그린다. 
				g.fillOval(50,240,30,30); //꽉차 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다. 
				g.fillOval(90,240,30,30); //꽉차 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다. 
				g.fillOval(130,240,30,30); //꽉차 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다. 
			} if(!out) //bool변수 아웃이 false이면 아래 명령어 실행 
			{ 
				g.setColor(Color.ORANGE); //컬러 오렌지 
				g.drawString("O", 30, 302); //"O"를 x : 30 y : 302에 문자열을 그린다. 
				g.drawOval(50,280,30,30); //비워 있는 원을 x : 50 y: 280에 30사이즈에 빈원을 그린다. 
			} else //위에 조건이 아니면 아래 명령어 실행 
			{ 
				g.setColor(Color.ORANGE); //컬러 오렌지 
				g.drawString("O", 30, 302); //"O"를 x : 30 y : 302에 문자열을 그린다. 
				g.fillOval(50,280,30,30); //꽉차 있는 원을 x : 50 y: 280에 30사이즈에 빈원을 그린다. 
			} 
		} 
	} 
}
			

/**
 * 	
 * @FileName : BaseBallGUI.java
 * @Project : JavaDayLearn
 * @Date : 2021. 2. 9.
 * @Author : YU
 * @Desc :
 */
public class BaseBallGUI extends JFrame implements ActionListener{
	
	MyPanel3 p; //MyPanel2형 변수 p 선언 
	JTextField jt; //JTextField형 변수 jt 선언 
	JButton jb; // JButton형 변수 jb 선언 
	RCom rc; // RCom형 변수 rc 선언 
	
	public BaseBallGUI(RCom rc){ //RCom을 인자로 받는 MainClass 생성자 
		this.rc = rc; //내 rc 변수에 인자 rc 대입 
		System.out.println(rc.getCom()[0]+""+rc.getCom()[1]+""+rc.getCom()[2]); // 출력 
		Container c = getContentPane(); 
		//Container형 변수 c 선언후 getContentPane함수를 호출하여 Container 객체를 대입 
		c.setLayout(new BorderLayout()); 
		//Container에 setLayout함수 호출 인자로 BorderLayout 객체를 생성해서 넘김 
		p = new MyPanel3(); 
		// p 변수에 Mypanel2의 객체를 생성 후 대입 
		jt = new JTextField(15); 
		// jt 변수에 JTextField의 길이를 15로 정하고 객체를 생성 후 대입 
		p.add(jt); 
		//MyPanel2에다가 JTextField 추가 
		jb = new JButton("입력"); 
		// jb 변수에 JButton의 값 "입력"으로 정하고 객체를 생성 후 대입 
		jb.addActionListener(this); 
		// JButton addActionListener함수를 호출 현 클래스 자신을 대입해서 호출 
		// ActionListener 추가 
		jb.setFont(new Font("맑음고딕",Font.BOLD,18)); 
		//JButton setFont 함수 호출 
		//함수 호출시 Font를 "맑은고딕", BOLD, 크기 18로 생성하여 생성자 인자로 넘김 
		p.add(jb); // MyPanel2에 JButton 추가 
		c.add(p); // Container에 MyPanel2 추가 
		setSize(400,400); //화면 사이즈 x : 400 y: 400 
		setVisible(true); //보여줄건지에 대한 함수 : true 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//기본 닫기 명령은 JFrame이 끝났을 경우 
	} 
	
	public static void main(String[] args) { 
		new BaseBallGUI(new RCom()); 
		//MainClass 객체를 RCom 객체를 받아서 생성 
	} 
	
	@Override public void actionPerformed(ActionEvent e) { 
		// TODO Auto-generated method stub 
		int[] user = new int[3]; 
		//정수형 배열 user 선언 후 정수형 3배열 객체 생성 후에 초기화 
		String[] temp=jt.getText().split(""); 
		//문자열 배열 temp 선언후 JTextField 문자열을 추출후 한글자씩 잘라서 초기화 
		for(int i=0;i<temp.length;i++) 
			//정수형 변수 i는 0으로 초기화 하고 i는 temp변수의 길이보다 작으면 반복 
			//반복시 정수형 변수는 i는 1씩 증가 
		{ 
			user[i] = Integer.parseInt(temp[i]); 
			//user 인덱스 i에 temp 인덱스 i의 문자열 값을 정수로 변환 해서 대입 
		} 
		
		UserCheck1 u = new UserCheck1(rc.getCom(), user); 
		//UserCheck형 변수 u를 선언 후 UserCheck rc com 배열과 user 배열을 
		//인자로 넘기는 객체 생성 
		System.out.println(u.getBall()+""+u.getStrike());//출력 
		p.setData(u.getStrike(), u.getBall(), u.getOut()); 
		//MyPanel2의 setData 함수 호출 
		//인자로 strike, ball, out 값을 인자로 넘김 
		p.repaint(); //MyPanel2를 다시 그린다. 
	
	}
	
	

	
}
