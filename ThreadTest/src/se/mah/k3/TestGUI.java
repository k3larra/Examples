package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

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
		//Skapa v�r uppgift d�r anropet till n�tet skall ligga det som kommmer att k�ras i en annan tr�d
		//Vi skickar med this som �r en referens till oss sj�lva s� att tr�den kan skicka tillbaka info till oss.
		TaskRunner task  = new TaskRunner(this,1000);
		//Skapa en tr�d att stoppa in uppgiften i
		Thread t = new Thread(task);
		
		//Det vanliga krafset
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		lblNewLabel = new JLabel("Time now");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		//starta tr�den
		t.start(); 
	}
	
	//H�r �r metoden som tr�den anropar nu f�r vi en str�ng tillbaka men h�r kan vi ta emot vad som helst
	public void SomethingHappend(String s){
		System.out.println(s);
		lblNewLabel.setText(s);
	}
	

}
