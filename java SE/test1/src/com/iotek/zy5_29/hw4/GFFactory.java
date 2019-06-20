package com.iotek.zy5_29.hw4;

public class GFFactory {
    public static BaseGF createGF(String gfType){
        switch (gfType){
            case "四川":
                return new GF_SC("四川妹子");
            case "广东":
                return new GF_SC("广东妹子");
            case "山东":
                return new GF_SC("山东妹子");
            default:
                System.out.println("还没有这个地方的妹子吆！");
                return null;
        }
    }
}
