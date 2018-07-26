package com.learning.service.producer;

import com.learning.pojo.MyStack;

/**
 * Created by 53097 on 2018/7/26.
 */
public class ConsumerThread extends Thread{

    private MyStack stack;

    public ConsumerThread(MyStack stack,String name){
        super(name);
        this.stack = stack;
    }

    public void run(){

        while (true){
            stack.pull();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
