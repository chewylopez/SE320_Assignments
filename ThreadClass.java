package ServerMain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadClass extends Thread {
	

	private DataInputStream in;
	private DataOutputStream out;
	
	public ThreadClass(Socket socket) {
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				double height = in.readDouble();
				double weight = in.readDouble();
				
				out.writeDouble(weight/Math.pow(height, 2));
				System.out.println("working");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
