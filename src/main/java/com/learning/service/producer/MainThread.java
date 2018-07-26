package com.learning.service.producer;

import com.learning.pojo.MyStack;

/**
 * Created by 53097 on 2018/7/26.
 */
public class MainThread {
    public static void main(String[] args){
        MyStack stack = new MyStack();
        new ProducerThread(stack,"Producer1").start();
        new ProducerThread(stack,"Producer2").start();
        new ConsumerThread(stack,"Consumer1").start();
        new ConsumerThread(stack,"Consumer2").start();
        new ConsumerThread(stack,"Consumer3").start();

    }
}
