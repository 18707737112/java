package com.iotek.zy6_03.hw4;

import java.util.Random;

public class Worker {
    private String alive = "健康"; // 表示健康状态

    public String getAlive() {
        return alive;
    }

    public void setAlive(String alive) {
        this.alive = alive;
    }

    public void work() throws SickException{
        boolean isHealthy = new Random().nextBoolean();
        //System.out.println(isHealthy);
        if(isHealthy){
            System.out.println("全面体检完成，身体倍棒！");
        }else{
            alive="病了"; // bug fix
            System.err.println("Oh,my god!"+alive);
            throw new SickException("快救我，不然我会带你一起一起走~~~");
        }
    }
}
