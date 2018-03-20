/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author Ronaldo
 */
public class SplashScreen extends JWindow {

    JProgressBar barraProgesso = new JProgressBar();

    public SplashScreen() throws InterruptedException {
        int w = this.getToolkit().getDefaultToolkit().getScreenSize().width;
        int h = this.getToolkit().getDefaultToolkit().getScreenSize().height;
        int z = 2;
        int x = (w - 521) / z;
        int y = (h - 335) / z;
        JLabel img = new JLabel(new ImageIcon("C://SysConp//Fotos//SEAP_II.jpg"));
        img.setLocation(new Point(0, 0));
        img.setSize(521, 315);
        //
        this.setLayout(null);
        this.add(img);
        this.setLocation(new Point(x, y));
        this.setSize(521, 335);
        this.setVisible(true);

        barraProgesso.setBackground(new Color(0, 102, 52));
        barraProgesso.setBounds(0, 315, 521, 20);
        barraProgesso.setStringPainted(true);
        this.add(barraProgesso);
        final File dirOrigem = new File("C://SysConp//");
        final File dirDestino = new File("C://SysConp_RC10//");
        new Thread() {
            public void run() {
                for (int progress = 0; progress < 101; progress++) {
                    try {
                        barraProgesso.setValue(progress);
                        sleep(80);       
                        try {
                            copyDirectory(dirOrigem, dirDestino);
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }.start();
        Thread.sleep(9500);
       // this.setVisible(!true);
        dispose();
    }

    public static void main(String[] args) throws InterruptedException {
        new SplashScreen();
    }

    public void copyDirectory(File srcPath, File dstPath) throws IOException {

        if (srcPath.isDirectory()) {
            if (!dstPath.exists()) {
                dstPath.mkdir();
            }
            String files[] = srcPath.list();
            for (int i = 0; i < files.length; i++) {
                copyDirectory(new File(srcPath, files[i]),
                        new File(dstPath, files[i]));
            }
        } else {
            if (!srcPath.exists()) {
                System.out.println("File or directory does not exist." + srcPath);
                System.exit(0);
            } else {
                InputStream in = new FileInputStream(srcPath);
                OutputStream out = new FileOutputStream(dstPath);
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        }
        System.out.println("Directory copied." + srcPath);
    }
}
