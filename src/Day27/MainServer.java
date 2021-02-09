package Day27;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {		// 01. main server

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RCom r = new RCom();
		UserCheck u = new UserCheck();
		
		
		System.out.println(r.com[0]+","+r.com[1]+","+r.com[2]);
		
		try
		{
			//
			ServerSocket s_socket = new ServerSocket(8102);
			
			//
			Socket c_socket = s_socket.accept();
			//
			
			//
			ServerReceiveThread rec_thread = new ServerReceiveThread();
			
			//
			rec_thread.setSocket(c_socket);
			rec_thread.setBaseballNumber(r.com);
			rec_thread.setUserCheck(u);
			//
			SendThread send_thread = new SendThread();
			
			//
			send_thread.setSocket(c_socket);
			
			//
			rec_thread.start();
			
			//
			send_thread.start();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}