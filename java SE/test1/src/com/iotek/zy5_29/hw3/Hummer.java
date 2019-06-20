package com.iotek.zy5_29.hw3;

public abstract class Hummer {
    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void engineBoom();
    public abstract void run();
    public void work(){
        start();
        stop();
        alarm();
        engineBoom();
        run();
    }
}
