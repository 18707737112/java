package com.iotek.zy5_29.hw4;

public abstract class BaseGF {
    private String gfType;

    public BaseGF() {
    }

    public BaseGF(String gfType) {
        this.gfType = gfType;
    }

    public String getGfType() {
        return gfType;
    }

    public void setGfType(String gfType) {
        this.gfType = gfType;
    }

    public abstract void eat();
    public void shopping(){
         System.out.println("疯狂购物中，买！买！买！");
    }
}
