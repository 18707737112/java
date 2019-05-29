package com.iotek.zy5_25.cc;

import java.util.Scanner;

public class Game {
    Person person ; //甲方

    Computer computer;// 乙方

    int count;// 对战次数

    public void inital(){
        person = new Person();
        computer = new Computer();
        count = 0;
    }
    //开始游戏
    public void startGame(){
        System.out.println("-------------欢迎进入猜拳游戏---------------");
        System.out.println();
        System.out.println("******************************************");
        System.out.println("——————出拳规则：1.剪刀    2.石头    3.布——————————");
        System.out.println("-------------》》》猜拳开始《《《------------");
        System.out.println("-------------------------------------------");
        Scanner input = new Scanner(System.in);
        String exit="n";//退出系统
        do {
            inital();//初始化
            //选择对手
            System.out.println("选择你的对手1.刘备     2.孙权    3.曹操   ");
            int role = input.nextInt();
            if (role ==1) {
                computer.name="刘备";
            }else if (role == 2) {
                computer.name="孙权";
            }else if (role == 3) {
                computer.name="曹操";
            }

            //游戏玩家输入姓名
            System.out.println("请输入你的姓名:");
            person.name=input.next();
            System.out.println(person.name+"    VS    "+computer.name+"对战\n");
            //开始游戏
            System.out.println("要开始吗?(y/n)");
            //开始一局游戏
            String start = input.next();
            int perFist;//游戏用户出拳
            int comFist;//计算机出拳
            while (start.equals("y")) {
                //出拳
                perFist = person.showFist();
                comFist = computer.showFist();
                //判断胜负
                if ((perFist==1&&comFist==1)||(perFist==2&&comFist==2)||(perFist==3&&comFist==3)) {
                    System.err.println("结果:和局，真衰！\n");//平局
                }else if ((perFist==2&&comFist==1)||(perFist==3&&comFist==2)||(perFist==1&&comFist==3)) {
                    System.err.println("结果:你赢了，真帅！\n");//胜利
                    person.score++;
                }else {
                    System.err.println("结果是：^_^,你输了，下载再战!\n");//计算机赢
                    computer.score++;
                }
                count++;
                System.out.println("是否进行下一轮(y/n)");
                start = input.next();

            }
            //显示结果
            showResult();
            System.out.println("\n要开始下一局吗?(y/n):");
            exit = input.next();
            System.out.println();

        } while (!exit.equals("n"));

        System.out.println("系统退出");
    }
    private void showResult() {
        //显示对战次数
        System.out.println("------------------------------");
        System.out.println(computer.name+"    VS    "+person.name);
        System.out.println("对战次数:"+count);
        //显示最终得分
        System.out.println("\n姓名\t得分");
        System.out.println(person.name+"\t"+person.score);
        System.out.println(computer.name+"\t"+computer.score+"\n");

        //显示对战结果
        int result = calcResult();
        if (result==1) {
            System.err.println("结果:打成平手，下次再和你一分高下");
        }else if (result==2) {
            System.err.println("结果:恭喜恭喜你赢得比赛");
        }else
        {
            System.err.println("结果:不气馁，下次再来");//计算机赢
        }
        System.out.println("--------------------------");


    }

    //计算比赛结果
    private int calcResult() {
        if (person.score == computer.score) {
            return 1;//战平
        }else if (person.score > computer.score) {
            return 2;//游戏玩家赢
        }else {
            return 3;//惜败
        }
    }
}
