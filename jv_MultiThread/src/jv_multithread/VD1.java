/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_multithread;

import javax.swing.JFrame;

class Luong1 extends Thread {

    String ten;

    Luong1(String _ten) {
        ten = _ten;
    }

    public void run() {
        for (int i = 1; i <= 200; i++) {
            try {
                System.out.println("Luong " + ten + " xin chào: " + i);
                Thread.sleep(5);
                Thread.yield();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class Luong2 extends JFrame implements Runnable {

    String ten;

    Luong2(String _ten) {
        ten = _ten;
    }

    public void run() {
        for (int i = 1; i <= 200; i++) {
            try {
                double k = Math.pow(3, 7);
                System.out.println("Luong " + ten + " xin chào: " + i);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

public class VD1 {

    public static void main(String args[]) {
        Luong1 L1 = new Luong1("Luong 1");
        Luong1 L3 = new Luong1("luong 3");
        Luong2 r2 = new Luong2("luong 2");
        Thread L2 = new Thread(r2);
        L2.setName("abc");
        System.out.println("L 1" + L2.getName());
        L1.start();
        L2.start();
        L3.start();
    }
}