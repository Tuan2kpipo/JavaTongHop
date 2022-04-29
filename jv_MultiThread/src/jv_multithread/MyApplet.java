/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_multithread;

/**
 *
 * @author Hp
 */
import java.applet.Applet;
import java.awt.*;

public class MyApplet extends Applet implements Runnable {

    Thread t;
    int k;

    public void init() {
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        g.drawString("i=" + k, 30, 30);
    }

    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                k++;
                System.out.println("chay");
                repaint();
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}