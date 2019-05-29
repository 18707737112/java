package com.iotek.zy5_25.b;

import java.util.Objects;

public class Employee extends Person {
    private String position;

    public Employee(String name, int age, String sex) {
        super(name,age,sex);
    }

    public Employee(String name, int age, String sex, String position) {
        super(name, age, sex);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", sex='" + getSex() + '\'' +
                "position='" + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        if(getName().equals(employee.getName()) && employee.getAge()==getAge() && getSex().equals(employee.getSex()) && position.equals(employee.position)){
            return true;
        }
        return false;
    }
}
