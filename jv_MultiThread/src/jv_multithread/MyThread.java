/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_multithread;

/**
 *
 * @author Hp
 */
import java.io.*;
public class MyThread extends Thread{
/**
* Mythread constructor comment.
*/
public static void main(String args[]){
Thread t = Thread.currentThread();
System.out.println("The current Thread is :" + t);
t.setName("MyJavaThread");
System.out.println("The thread is now named: " + t);

try{
for(int i = 0; i <3;i++){
System.out.println(i);
Thread.sleep(1500);
}
}catch(InterruptedException e){
System.out.println("Main thread interupted");
}
}
}