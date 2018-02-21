package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 3; i++) {

                        if (args[2*i].equals("м")) {
                            allPeople.add(Person.createMale(args[1*i], dateFormatIn.parse(args[3*i])));
                        }
                        if (args[2].equals("ж")) {
                            allPeople.add(Person.createFemale(args[1*i], dateFormatIn.parse(args[3*i])));
                        }
                        System.out.println(allPeople.size() - 1);

                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 4; i++) {
                        if (args[3*i].equals("м")) {
                            allPeople.set(Integer.parseInt(args[1*i]), Person.createMale(args[2*i], dateFormatIn.parse(args[4*i])));
                        }
                        if (args[3*i].equals("ж")) {
                            allPeople.set(Integer.parseInt(args[1*i]), Person.createFemale(args[2*i], dateFormatIn.parse(args[4*i])));
                        }
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1); i++) {

                        allPeople.get(Integer.parseInt(args[1*i])).setName(null);
                        allPeople.get(Integer.parseInt(args[1*i])).setBirthDay(null);
                        allPeople.get(Integer.parseInt(args[1*i])).setSex(null);
                        break;
                    }
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1); i++) {

                        String name = allPeople.get(Integer.parseInt(args[1*i])).getName();
                        String sex;
                        if (allPeople.get(Integer.parseInt(args[1*i])).getSex().equals(Sex.MALE)) sex = "м";
                        else sex = "ж";
                        Date dateBirthday = allPeople.get(Integer.parseInt(args[1*i])).getBirthDay();

                        System.out.println(name + " " + sex + " " + dateFormatOut.format(dateBirthday));
                        break;
                    }
                }
        }

        //start here - начни тут
    }
}
