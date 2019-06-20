package zy;
/**
 * 写两个线程，一个线程打印 1~52，另一个线程打印字母A-Z打印顺序为12A34B56C……51Y52Z（2个数字1个字母）。
 */
public class Hw3 {
    public static void main(String[] args) {
        OneThread one = new OneThread();
        TwoThread two = new TwoThread();
        one.start();
        two.start();
    }
}

class  OneThread extends Thread{
    int num=1;
    int num1=2;
    public synchronized void run() {
        for (int i = 1; i <= 26; i++) {
            System.out.print(num+",");
            System.out.println(num1+",");
            num+=2;
            num1+=2;
            if (i < 26) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TwoThread extends Thread{
    int c = 65;
    public synchronized void run() {
        for (int i = 1; i <= 26; i++) {
            System.out.print((char) c++);
            System.out.println(",");
            if (i < 26) {
                try {
                    Thread.sleep(1002);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}