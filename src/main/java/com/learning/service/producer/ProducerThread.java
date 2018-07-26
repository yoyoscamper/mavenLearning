package com.learning.service.producer;

import com.learning.pojo.MyStack;

/**
 * Created by 53097 on 2018/7/26.
 */
public class ProducerThread extends Thread{

    private MyStack stack;

    public ProducerThread(MyStack stack,String name){
        super(name);
        this.stack = stack;
    }
    public void run(){

        while (true){
            stack.push();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
