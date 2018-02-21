package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            String[] wheelsString = loadWheelNamesFromDB();
            wheels = new ArrayList<>();
            if (wheelsString.length != 4) throw new Exception();
            for (String wheel: wheelsString) {
                wheels.add(Wheel.valueOf(wheel));
                }
            }
            //init wheels here


        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
//        Car car = new Car();
    }
}
