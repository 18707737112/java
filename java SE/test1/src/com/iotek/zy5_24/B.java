package com.iotek.zy5_24;

/*小红养了两只猫，一只叫小黑，今年2岁，黑色，
另一只叫小白，今年5岁，白色。
请编写一个程序，要求当用户输入小猫的名字时，
就显示猫的名字、年龄和颜色。
如果用户输入的小猫名字错误，
则显示“小红没有养这只猫”。
*/
public class B {
    public static void main(String[] args) {
        Person person = new Person("小红");
        Cat cat1 = new Cat("小黑","2岁","黑色");
        Cat cat2 = new Cat("小白","5岁","白色");
        Cat[] catArray = {cat1,cat2};
        person.setCatArray(catArray);
        String find = person.findCat("小黄");
        String find1 = person.findCat("小白");
        String find2 = person.findCat("小黑");
        System.out.println(find);
        System.out.println(find1);
        System.out.println(find2);
    }
}

class Person {
    private String masterName;
    private Cat[] catArray = new Cat[2];

    public Person() {
    }

    public Person(String masterName) {
        this.masterName = masterName;
    }

    public Person(String masterName, Cat[] catArray) {
        this.masterName = masterName;
        this.catArray = catArray;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Cat[] getCatArray() {
        return catArray;
    }

    public void setCatArray(Cat[] catArray) {
        this.catArray = catArray;
    }

    public String findCat(String name){
        for (Cat cat : getCatArray()) {
            if (name.equals(cat.getName())){
                return cat.toString();
            }
        }
        return getMasterName()+"没有养"+name+"这只猫!";
    }
}
class Cat {
    private String name;
    private String age;
    private String color;

    public Cat() {
    }

    public Cat(String name, String age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color;
    }
}