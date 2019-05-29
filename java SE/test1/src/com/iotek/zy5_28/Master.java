package com.iotek.zy5_28;

public class Master {
    private String name;
    private Pet[] pets;
    private Foot[] feet;

    public Master() {
    }

    public Master(String name) {
        this.name = name;
    }

    public Master(String name, Pet[] pets, Foot[] feet) {
        this.name = name;
        this.pets = pets;
        this.feet = feet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setPets(Pet[] pets) {
        this.pets = pets;
    }

    public Foot[] getFeet() {
        return feet;
    }

    public void setFeet(Foot[] feet) {
        this.feet = feet;
    }

    public void feet(Pet pet,Foot foot){
        pet.eat(foot);
    }

}
