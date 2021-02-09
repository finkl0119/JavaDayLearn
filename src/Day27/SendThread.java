package Day27;
import java.io.*;
import java.net.*;

public class SendThread extends Thread {	
	private Socket m_Socket;	
	public void run() {	

		super.run();	
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));	// Ű���� �Է�, ���۸����� �̿��� �Է� ��ü ����
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());		

			String sendString;


			while(true)
			{
				sendString = tmpbuf.readLine();	
				System.out.println("나 :"+sendString);	
				if(sendString.equals("quit"))	
				{
					System.out.println("프로그램을 종료합니다.");
					sendString = "quitSignal";
					sendWriter.println(sendString);
					sendWriter.flush();
					break;	

				} else { 	
					sendWriter.println(sendString);		
					sendWriter.flush();
				}

			}
			
			m_Socket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}


	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}
}