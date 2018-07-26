package com.learning.service;

import com.learning.pojo.Hero;

/**对一个hero加血减血
 * Created by 53097 on 2018/7/23.
 */
public class TestThread {

    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        for(int i=0;i<5;i++){
            Thread t1 = new Thread(){
                public void run(){
                    while(true){

                        //无需循环判断
//                    while(gareen.hp==1){
//                        continue;
//                    }

                        gareen.hurt();

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            };
            t1.start();
        }


        for(int i=0;i<2;i++){
            Thread t2 = new Thread(){
                public void run(){
                    while(true){
                        gareen.recover();

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            };
            t2.start();
        }



    }
}
