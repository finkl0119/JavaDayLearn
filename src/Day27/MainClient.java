package Day27;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainClient{	// 02.main client
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 
			Socket c_socket = new Socket("127.0.0.1", 8102);
			//

			//
			ClientReceiveThread rec_thread = new ClientReceiveThread();

			//
			rec_thread.setSocket(c_socket);

			Thread t = new Thread(rec_thread);
			t.start();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}



}