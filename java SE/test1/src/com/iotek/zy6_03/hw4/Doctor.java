package com.iotek.zy6_03.hw4;

import java.util.Random;

public class Doctor {
    public void cure(Worker worker){
        boolean isCure = new Random().nextBoolean();
        //System.out.println(isCure);
        if(isCure){
            System.out.println("病了~就到海同医院治疗~");
            worker.setAlive("健康"); // bug fix
            System.out.println("恭喜你，痊愈了！祝你健康到永远！");
        }else{
            System.err.println("病了~就到海同医院治疗~");
            System.err.println("Sorry，我们尽力了");
        }
    }
}
