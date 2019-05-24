package com.iotek.zy5_24;

/* 编写一个类Student，代表学员，要求：

1)       具有属性：姓名、年龄、性别、专业

2)       具有方法：自我介绍，负责输出该学员的姓名、年龄、性别以及专业

3)       具有两个带参数的构造方法：

第一个构造方法中，设置学员的性别为男，专业为Android，其余属性的值由参数给定；第二个构造方法中，所有属性都由参数给定

编写测试类StudentTest进行测试，分别以两种方式对两个Student对象进行初始化，并分别调用他们的自我介绍方法，看看输出结果是否正确。
*/
public class C {
    public static void main(String[] args) {
        Student student1 = new Student("Tom",20);
        Student student2 = new Student("Bob",20,"女","Java");
        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }
}
class Student {
    private String name;
    private int age;
    private String sex;
    private String professional;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        sex = "男";
        professional = "Android";
    }

    public Student(String name, int age, String sex, String professional) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", professional='" + professional + '\'' +
                '}';
    }
}
