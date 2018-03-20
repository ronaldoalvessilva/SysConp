/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Dao;

import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author Ronaldo
 */
public class DataHotaAutomatica {
    
    public class LabelClock {  
  
    private Date                date;  
    private int                 delay;  
    private SimpleDateFormat    formatter;  
    private Label               label;  
    private boolean             stop;  
    private Thread              thread;  
  
    public LabelClock(Label label, String format, int delay) {  
        super();  
        try {  
            this.label = label;  
            this.delay = delay;  
            date = new Date();  
            formatter = new SimpleDateFormat(format);  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

        public LabelClock(JTextField jHoraSistema, String hHmmss, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
  
    public void start() {  
        try {  
            stop = false;  
            thread = new Thread(new Runnable() {  
                public void run() {  
                    try {  
                        String text = null;  
                        while (!stop) {  
                            date.setTime(System.currentTimeMillis());  
                            text = formatter.format(date);  
                            label.setText(text);  
                            Thread.sleep(delay);  
                        }  
                    }  
                    catch (InterruptedException ie) {  
                        ie.printStackTrace();  
                    }  
                }  
            });  
            thread.start();  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void stop() {  
        stop = true;  
    }  
    }  
}
