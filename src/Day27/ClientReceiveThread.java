package Day27;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ClientReceiveThread extends JFrame implements ActionListener, Runnable{
	//
	private Socket m_Socket;

	MyPanel2 p; //MyPanel2형 변수 p 선언
	JTextField jt; //JTextField형 변수 jt 선언
	JButton jb; // JButton형 변수 jb 선언

	public ClientReceiveThread(){

		Container c = getContentPane();
		//Container형 변수 c 선언후 getContentPane함수를 호출하여 Container 객체를 대입
		c.setLayout(new BorderLayout());       
		//Container에 setLayout함수 호출 인자로 BorderLayout 객체를 생성해서 넘김
		p = new MyPanel2(); // p 변수에 Mypanel2의 객체를 생성 후 대입
		jt = new JTextField(15); // jt 변수에 JTextField의 길이를 15로 정하고 객체를 생성 후 대입
		p.add(jt); //MyPanel2에다가 JTextField 추가
		jb = new JButton("입력"); // jb 변수에 JButton의 값 "입력"으로 정하고 객체를 생성 후 대입
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


	public void run() { 

		try { 

			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream())); 

			String receiveString; 
			while(true) 
			{  
				receiveString = tmpbuf.readLine(); 


				System.out.println(receiveString);

				if(receiveString == null)
				{ 
					System.out.println("잘가시오"); 
					break;  
				} 
				else 
				{   
					System.out.println(receiveString);
					p.setData(receiveString.charAt(0)-'0', receiveString.charAt(1)-'0', receiveString.charAt(2)-'0');
					//MyPanel2의 setData 함수 호출
					//인자로 strike, ball, out 값을 인자로 넘김
					p.repaint();
				} 
			}  
		}catch(IOException e) 
		{  
			e.printStackTrace();
		}
		System.exit(0);
	} 
	public void setSocket(Socket _socket) 
	{ 

		m_Socket = _socket; 
	}

	public void actionPerformed(ActionEvent e) {
		PrintWriter sendWriter = null;
		try {
			sendWriter = new PrintWriter(m_Socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sendWriter.println(jt.getText());		
		sendWriter.flush();
	}

}
