package ServerMain;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



//for question 2
public class server_main_2 {

	private static ServerSocket s;
	private static int port = 4444;
	
	private static int connections = 0;

	private static JLabel openserver = new JLabel("Connections made: " + connections);

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
		
		try {
			s = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(true) {
			addNewClient();
		}

	}

	private static void addNewClient() {
		
		Socket socket = null;
		try {
			
			System.out.println("server created");
			System.out.println("waiting for client");
			
			socket = s.accept();
			connections++;
			openserver.setText("Connections made: " + connections);
			Thread t = new ThreadClass(socket);
			t.start();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to connect with client");
		}

	}

}
