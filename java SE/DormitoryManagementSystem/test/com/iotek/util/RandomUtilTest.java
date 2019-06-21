package com.iotek.util;

import org.junit.Test;

import java.util.Random;

public class RandomUtilTest {
    private RandomUtil randomUtil = new RandomUtil();

    @Test
    public void setRandomUtil(){
        int n = randomUtil.number(3);
        System.out.println(n);
    }
}
