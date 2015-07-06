/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0014.arraycount;

/**
 *
 * @author user
 */
public class Counter extends Thread{
    private int start;
    private int end;
    private ArrayToCount atc;
    private boolean done;
    private long S;

    public Counter(ArrayToCount atc, int start, int end) {
        this.atc = atc;
        this.start = start;
        this.end = end;
    }

    public boolean isDone() {
        return done;
    }

    public long getS() {
        return S;
    }
    
    @Override
    public void run(){
        while(!isInterrupted()){
            if(!done){
                synchronized(this.atc){
                    for(int i = this.start; i < this.end;i++){
                        S += this.atc.array[i];
                    }
                }
            }
            this.done = true;
            try{
                synchronized(this.atc){
                    this.atc.wait();
                }
            }catch (InterruptedException ex){
                //System.out.println("Interrupted");
                break;
            }
        }
        //System.out.println(getName()+" gone...");
    }
}
