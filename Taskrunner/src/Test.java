import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
public class Test extends JFrame {

	private JPanel contentPane;
	public JLabel testLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		//här startar vi och deklarera TimerTask
		Timer timer = new Timer();
		MyTask t = new MyTask(); //Den inre klassen nedan
		timer.schedule(t, 0, 5000); //Starta direkt o anropa var 10:e sekund
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		testLabel = new JLabel("Soon");
		contentPane.add(testLabel, BorderLayout.NORTH);
	}
	
	//en inre klass lite praktiskt eftersom man då direkt "når" GUI och inte behöver ha en referens 
	private class MyTask extends TimerTask {
	    public void run() {
	    	Calendar c = Calendar.getInstance();
	    	Date d = c.getTime();
	    	testLabel.setText(d.toString());

	    }
	}
}






