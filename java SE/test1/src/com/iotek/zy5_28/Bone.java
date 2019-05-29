package com.iotek.zy5_28;

public class Bone extends Foot{
    public Bone(String type) {
        super(type);
    }

    @Override
    public String foot() {
        //matches模糊比较
        //其中“.”表示任意字符，
        // 后面紧跟着的“*”表示重复出现多少次都行
        // （0次，1次都可以）
        if(getType().matches(".*骨头")){
            return super.foot();
        }
        return "食物品种错误,拜托，我是骨头！！！";
    }
}
