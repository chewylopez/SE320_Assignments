package ClientMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//for question 1
public class client_main{
	
	private static Socket s;
	private static int port = 4444;

	private static DataInputStream in;
	private static DataOutputStream out;
	
	private static JTextField tf1 = new JTextField();
	private static JLabel title1 = new JLabel("input height(m)");
	
	private static JTextField tf2 = new JTextField();
	private static JLabel title2 = new JLabel("input weight(kg)");
	
	private static JLabel answer = new JLabel("answer: ");
	
	private static JButton send = new JButton("send data");
	
	public static void main(String[] args) {
		
		openClientSocket();
		
		JFrame jf = new JFrame("client");
		
		jf.setVisible(true);
		jf.setLocation(500, 100);
		jf.setSize(300, 400);
		jf.setLayout(null);
		
		jf.add(tf1);
		tf1.setLocation(20, 35);
		tf1.setSize(100, 35);
		
		jf.add(title1);
		title1.setLocation(20, 0);
		title1.setSize(100, 35);
		
		jf.add(tf2);
		tf2.setLocation(120, 35);
		tf2.setSize(100, 35);
		
		jf.add(title2);
		title2.setLocation(120, 0);
		title2.setSize(100, 35);
		
		jf.add(send);
		send.setLocation(70, 70);
		send.setSize(100,35);
		
		send.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeDouble(Double.parseDouble(tf1.getText()));
					out.writeDouble(Double.parseDouble(tf2.getText()));
					
					answer.setText("Answer: " + in.readDouble());
					
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		jf.add(answer);
		answer.setLocation(70, 120);
		answer.setSize(150, 35);
		
		
	}
	
	private static void openClientSocket() {
		try {
			s = new Socket("127.0.0.1", port);
			System.out.println("client created");
			
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to create client socket");
		}
		
	}

}
