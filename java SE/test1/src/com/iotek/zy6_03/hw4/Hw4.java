package com.iotek.zy6_03.hw4;

/*
有一个工作者有一个属性是alive（保存的是治愈还是死亡）和工作方法(work方法)，
在工作途中可能会生病（抛出自定义异常（SickException）），也可能是健康的没生病.(通过随机数来控制生病与否)。
有一个医生监测工作者工作，一旦出现生病的情况，就调用cure(Worker worker)方法来给其治病，
（通过随机数来控制，可能治愈也可能死亡（给属性alive赋值））
最终判断alive属性值要是治愈现实“恭喜你”，要是死亡显示”sorry尽力了“。
*/
public class Hw4 {
    public static void main(String[] args) {
        Worker w = new Worker();
        Doctor d = new Doctor();

        try {
            w.work();
        } catch (SickException e) {
            d.cure(w);
        }
    }
}
