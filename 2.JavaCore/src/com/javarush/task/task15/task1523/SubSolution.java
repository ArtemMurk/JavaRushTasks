package com.javarush.task.task15.task1523;

public class SubSolution extends Solution {
    public SubSolution(String name) {
        super(name);
    }

    protected SubSolution(String name, int age) {
        super(name, age);
    }

    SubSolution(int age, String name) {
        super(age, name);
    }
}
