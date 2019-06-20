package zy;

import java.util.Date;

/**
 * 编一个程序，实现两个线程 A 和 B ，A 和 B 同时启动，A线程每隔5秒显示字符串”AAA”，
 *     B线程每隔 1秒显示字符‘B’。
 */
public class Hw1 {
    public static void main(String[] args) {
        MyThread a = new MyThread();
        a.setSm(5000);
        a.setName("A");
        a.setPsm("AAA");
        MyThread b = new MyThread();
        b.setSm(1000);
        b.setName("B");
        b.setPsm("B");
        a.start();
        b.start();
    }
}

class MyThread extends Thread {
    //间隔时间（毫秒）
    private int sm;
    private String name;
    private String psm;
    public MyThread() {
    }
    //构造函数

    public MyThread(int sm, String name, String psm) {
        this.sm = sm;
        this.name = name;
        this.psm = psm;
    }

    public String getPsm() {
        return psm;
    }

    public void setPsm(String psm) {
        this.psm = psm;
    }

    public int getSm() {
        return sm;
    }

    public void setSm(int sm) {
        this.sm = sm;
    }

    //重写线程run方法
    @Override
    public void run() {
        while (true) {
            if (psm != null) {
                System.out.println(this.getName()+"->"+psm+"->time:" + new Date());
            }
            if (sm != 0) {
                try {
                    Thread.sleep(sm);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
