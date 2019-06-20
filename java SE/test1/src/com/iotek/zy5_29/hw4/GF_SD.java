package com.iotek.zy5_29.hw4;

public class GF_SD extends BaseGF {
    public GF_SD() {
    }

    public GF_SD(String gfType) {
        super(gfType);
    }

    @Override
    public void eat() {
        System.out.println("比较喜欢咸辣口味！！！");
    }

    @Override
    public void shopping() {
        super.shopping();
    }
}
