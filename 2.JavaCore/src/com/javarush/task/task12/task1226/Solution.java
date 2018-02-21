package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public interface Fly{
    void fly();
    }

    public interface Run{
        void run();
    }

    public interface Climb {
        void climb();
    }

    public class Cat implements Climb, Run {
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }

    public class Dog implements Run {
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
        @Override
        public void run() {
            super.run();
        }

        @Override
        public void climb() {
            super.climb();
        }
    }

    public class Duck implements Fly, Run {
        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }
}
