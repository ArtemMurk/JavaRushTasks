package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Person> list = new ArrayList<>();
        Person person = null;
        String key = "F";

        while (!key.equals("S")) {
            key = reader.readLine();
            if (key.equals("coder")){
            list.add(new Person.Coder());
            }
            else if (key.equals("proger")){
                list.add(new Person.Proger());
            }
            else if (key.equals("user")){
                list.add(new Person.User());
            }
            else if (key.equals("loser")){
                list.add(new Person.Loser());
            }
            else key="S";
        }
        //тут цикл по чтению ключей, пункт 1
        {

            //создаем объект, пункт 2
            for (Person it: list) {
                person = it;
                doWork(person); //вызываем doWork

            }

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        else if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        }
        else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
