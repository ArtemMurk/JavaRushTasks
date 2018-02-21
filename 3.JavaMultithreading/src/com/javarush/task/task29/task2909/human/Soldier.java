package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    protected boolean isSoldier;


    protected int course;



    public Soldier(String name, int age) {
        super(name, age);
        isSoldier = true;
    }
    public void live() {
        if (isSoldier)
            fight();
    }

    public void fight() {
    }

    public int getCourse() {
        return course;
    }
}
