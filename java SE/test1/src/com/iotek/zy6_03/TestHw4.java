package com.iotek.zy6_03;

import com.iotek.zy6_03.hw4.Doctor;
import com.iotek.zy6_03.hw4.SickException;
import com.iotek.zy6_03.hw4.Worker;
import org.junit.Test;
//第四题-单元测试
public class TestHw4 {
    @Test
    public void test1(){
        Worker w = new Worker();
        try {
            w.work();
        } catch (SickException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        Doctor d = new Doctor();
        d.cure(new Worker());
    }
    @Test
    public void testCure(){
        Worker w = new Worker();
        Doctor d = new Doctor();
        try {
            w.work();
        } catch (SickException e) {
            //System.err.println("病了~就到海同医院治疗~");
            d.cure(w);
        }
    }
}
