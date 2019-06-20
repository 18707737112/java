package com.iotek.zy6_06.hw1;

public class Person implements Comparable<Person>{
    private long id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        /*if(this.age - p.age > 0){
            return 1;
        }else if(this.age - p.age < 0){
            return -1;
        }else{
            return name.compareTo(p.name);
        }*/
        return age == p.age ? name.compareTo(p.name) : age - p.age;
    }
}
