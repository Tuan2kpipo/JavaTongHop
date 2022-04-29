/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_multithread;

/**
 *
 * @author Hp
 */
class Customer {
    int amount = 10000; 
    synchronized void withdraw(int amount) {
        System.out.println("Rút tiền...:Số tiền đang có la:"+this.amount);
        
        if (this.amount < amount) {
            System.out.println("Tài khoản không đủ; đợi gửi tiền...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("Hoàn thành rút tiền!:Số tiền còn lại: "+this.amount);
    }
 
    synchronized void deposit(int amount) {
        System.out.println("Gửi tiền...");
        this.amount += amount;
        System.out.println("Hoàn thành gửi tiền!");
        notify();
    }
}
 
public class DemoWaitNotify {
    public static void main(String args[]) {
        final Customer c = new Customer();
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            public void run() {
                c.deposit(10000);
            }
        }.start();
    }
}