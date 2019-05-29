package com.iotek.zy5_28;

import java.util.Scanner;

public class Game {
     private Master m;
     private Pet[] p;
     private Foot[] f;

     Scanner input = new Scanner(System.in);

     public Master master(){
         System.out.println("请输入您的名字：");
         String s = input.next();
         m = new Master(s);
         return m;
     }

     public Pet[] pets(){
         System.out.println("您准备养几只宠物？（种类：犬/猫）");
         int length = input.nextInt();
         p = new Pet[length];
         for (int i = 0; i < p.length; i++) {
             System.out.println("请输入养的第"+(i+1)+"个宠物种类");
             String s = input.next();
             if(s.matches(".*犬")){
                 System.out.println("请起名");
                 String name = input.next();
                 p[i] = new Dog(name);
             }else if(s.matches(".*猫")){
                 System.out.println("请起名");
                 String name = input.next();
                 p[i] = new Cat(name);
             }else {
                 System.out.println("没有改种宠物，请重新填写！");
                 return pets();
             }
         }
         return p;
     }

     public Foot[] feet(){
         String[] strings = {"鸡骨头","大鲇鱼"};
         f = new Foot[strings.length];
         for (int i = 0; i < f.length; i++) {
             f[i] = new Foot(strings[i]);
         }
         return f;
     }

     public void menu(){
         System.out.println("饲主姓名：" + m.getName());
         System.out.println("饲养宠物：");
         for (int i = 0; i < m.getPets().length; i++) {
             System.out.print((i+1)+m.getPets()[i].getName()+" ");
         }
         System.out.println();
         System.out.println("拥有饲料：");
         for (int i = 0; i < m.getFeet().length; i++) {
             System.out.print((i+1)+m.getFeet()[i].getType()+" ");
         }
         System.out.println();
         System.out.println("Game stater（y/n):");
         String n = input.next();
         if(n.equals("y")){
             action();
         }
         return;
     }

     public void action(){
         System.out.println("请选择喂养的宠物编号：");
         int a = input.nextInt();
         Pet pet = p[a-1];
         System.out.println("请选择喂养的食物编号：");
         int b = input.nextInt();
         Foot foot = f[b-1];
         m.feet(pet,foot);
         System.out.println("1.继续  2.退出");
         int n = input.nextInt();
         if (n == 1){
             action();
         }
         return;
     }

     public void factory(){
         master();
         m.setPets(pets());
         m.setFeet(feet());
     }
}
