package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI frame = new TestGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGUI() {
		//Skapa vår uppgift där anropet till nätet skall ligga det som kommmer att köras i en annan tråd
		//Vi skickar med this som är en referens till oss själva så att tråden kan skicka tillbaka info till oss.
		TaskRunner task  = new TaskRunner(this,1000);
		//Skapa en tråd att stoppa in uppgiften i
		Thread t = new Thread(task);
		//starta tråden
		t.start(); 
		//Det vanliga krafset
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		lblNewLabel = new JLabel("Time now");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		contentPane.setBackground(Color.BLUE);
	}
	
	//Här är metoden som tråden anropar nu får vi en sträng tillbaka men här kan vi ta emot vad som helst
	public void SomethingHappend(String s){
		System.out.println(s);
		lblNewLabel.setText(s);
	}
	

}
