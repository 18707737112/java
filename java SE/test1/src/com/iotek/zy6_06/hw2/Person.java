package com.iotek.zy6_06.hw2;

public class Person implements Comparable<Person>{
    private long id;
    private String name;
    private int score;

    public Person() {
    }

    public Person(long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
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
        return name != p.name ? name.compareTo(p.name) : score - p.score;
    }
}
