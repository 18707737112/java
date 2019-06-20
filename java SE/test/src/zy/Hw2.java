package zy;

public class Hw2 {
    public static void main(String[] args) {
        Cave cave = new Cave(); // 山洞对象（锁）
        Train t1 = new Train("1号",cave);
        Train t2 = new Train("2号",cave);
        Train t3 = new Train("3号",cave);
        Train t4 = new Train("4号",cave);
        Train t5 = new Train("5号",cave);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Cave {
}

class Train extends Thread {
    private Cave cave; // 用成员变量，是为了扩大作用域
    public Train(String name,Cave cave){
        super(name); // 给线程对象起个名字
        this.cave = cave;
    }

    @Override
    public void run() {
        // 抢山洞对象上的锁
        synchronized(cave){ // 同步代码块
            // 过山洞
            System.out.println(getName()+"开始进入山洞...");
            try {
                Thread.sleep(2000); // 模拟过山洞的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"离开山洞。");
        }
    }
}