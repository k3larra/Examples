
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.mah.k3;

import java.util.Calendar;
import java.util.Date;

public class TaskRunner implements Runnable{
    private boolean threadIsAlive = true;
    private boolean isRunningTask = true;
    
    private int waitTime;
    private TestGUI test;
    private Calendar c; 
   
    //Denna tråden är kopplad till vårt GUI TestGUI detta så att tråden kan skicka tillbaka information
    //den andra parametern anger hur ofta denna tråden skall vakna se nedan
    public TaskRunner(TestGUI test, int miliseconds){
        this.test = test;
        this.waitTime = miliseconds;
         c = Calendar.getInstance();
    }

	@Override
	public void run() {
	  while (threadIsAlive){     
            if(isRunningTask){
                //Det jobb som tråden skall göra lägger du här.
            	//Som exempel hämtar jag tiden nu
            	c = Calendar.getInstance();
            	Date d = c.getTime();
            	test.SomethingHappend(d.toString()); //Skickar tillbaka till TestGUI
            }
            try {
                Thread.sleep(waitTime); //här väntar vi
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
       }
	}
    
 
    //lite metoder så man kan stoppa o fixa med tråden
    public void pause(){
        isRunningTask = false;
    }
    public void unPause(){
        isRunningTask = true;
    }
    public void changeWaitTime(int newWaitTime){
        waitTime = newWaitTime;
    }
    public void kill(){
        threadIsAlive = false;
    }
}
