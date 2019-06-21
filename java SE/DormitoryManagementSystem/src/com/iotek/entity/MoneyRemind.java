package com.iotek.entity;

import java.io.Serializable;

public class MoneyRemind implements Serializable {
    private int id;
    private int money = 0;

    public MoneyRemind() {
    }

    public MoneyRemind(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "学号：" + id +" "+
                "设置金额：" + money;
    }
}
