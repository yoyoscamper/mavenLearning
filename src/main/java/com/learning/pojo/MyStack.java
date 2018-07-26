package com.learning.pojo;

import java.util.LinkedList;

/**
 * Created by 53097 on 2018/7/26.
 */
public class MyStack {

    volatile LinkedList<Character> list = new LinkedList<Character>();

    public synchronized void push(){
        if (list.size() == 200) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
                return;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        char str = (char)(Math.random()*26+'A');
        System.out.println(Thread.currentThread().getName() + "push:" + str);
        this.notifyAll();
        list.addLast(str);
    }

    public synchronized void pull(){
        if (list.isEmpty()) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
                return;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "pull:" + list.getLast());
        this.notifyAll();
        list.removeLast();
    }
}
