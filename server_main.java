package ServerMain;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



//for question 1
public class server_main {

	private static ServerSocket s;
	private static Socket socket;
	private static int port = 4444;

	private static DataInputStream in;
	private static DataOutputStream out;

	private static JLabel openserver = new JLabel("server off, waiting for client");

	public static void main(String[] args) {

		JFrame jf = new JFrame("server");

		jf.setVisible(true);
		jf.setLocation(100, 100);
		jf.setSize(300, 400);
		jf.setLayout(null);

		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

		jf.add(openserver);
		openserver.setLocation(20, 20);
		openserver.setSize(300, 50);
		
		openServerSocket();
		
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

	private static void openServerSocket() {
		try {
			s = new ServerSocket(port);
			
			System.out.println("server created");
			System.out.println("waiting for client");
			
			socket = s.accept();
			
			openserver.setText("server paired");
			
			System.out.println("server connected");

			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to create server");
		}

	}

}
