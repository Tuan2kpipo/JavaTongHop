/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv_multithread;

/**
 *
 * @author DELL
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;

class SapxepTang extends Thread {

    int MT[];

    SapxepTang(int M[]) {
        MT = M;
    }
    public void setData(int M[]){
        MT=M;
    }

    public void run() {
        for (int i = 0; i < MT.length - 1; i++) {
            for (int j = i + 1; j < MT.length; j++) {
                if (MT[j] < MT[i]) {
                    int tg = MT[j];
                    MT[j] = MT[i];
                    MT[i] = tg;
                   
                }
                 System.out.println("run luong 1");
            }
        }
    }
   synchronized int[] getData(){
        return MT;
    }
}

class SapxepGiam extends JFrame implements Runnable {

    int MG[];

    SapxepGiam(int M[]) {
        MG = M;
    }

    public void run() {
        
        for (int i = 0; i < MG.length - 1; i++) {
            for (int j = i + 1; j < MG.length; j++) {
                if (MG[j] > MG[i]) {
                    int tg = MG[j];
                    MG[j] = MG[i];
                    MG[i] = tg;
                   
                }
                 System.out.println("run luong 2");
            }
        }
    }
   synchronized int[] getData(){
        return MG;
    }
    
}

public class DemMoSapXep {

    public static void main(String args[]) {
        int M[]={2,6,1,4,7,1};
        int M1[]={5,2,1,2,9,6};
        SapxepTang L1 = new SapxepTang(M);
        SapxepGiam r2 = new SapxepGiam(M1);
        Thread L2 = new Thread(r2);
        L1.start();
        L2.start();
        try {
            System.out.println("Waiting for threads to finish.");
            L1.join();
            L2.join();
//            thread2.t.join();
//            thread3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int MT[]=L1.getData();
         int MG[]=r2.getData();
        
        
        for(int i=0;i<MT.length;i++){
            System.out.print(MT[i]+" ");
        }
        System.out.println();
         for(int i=0;i<MG.length;i++){
            System.out.print(MG[i]+" ");
        }
    }
}