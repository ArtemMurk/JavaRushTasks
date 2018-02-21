package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static  {
        synchronized (allPeople) {

            allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
            allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i <= (args.length - 1) / 3; i++) {

                        if (args[(i*2+(i-1))].equals("м")) {
                            allPeople.add(Person.createMale(args[(i*2+(i-2))], dateFormatIn.parse(args[(i*2+i)])));
                        }
                        if (args[(i*2+(i-1))].equals("ж")) {
                            allPeople.add(Person.createFemale(args[(i*2+(i-2))], dateFormatIn.parse(args[(i*2+i)])));
                        }
                        System.out.println(allPeople.size() - 1);

                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i <= (args.length - 1) / 4; i++) {
                        if (args[i*3+(i-1)].equals("м")) {
                            allPeople.set(Integer.parseInt(args[i*3+(i-3)]), Person.createMale(args[i*3+(i-2)], dateFormatIn.parse(args[i*3+i])));
                        }
                        if (args[i*3+(i-1)].equals("ж")) {
                            allPeople.set(Integer.parseInt(args[i*3+(i-3)]), Person.createFemale(args[i*3+(i-2)], dateFormatIn.parse(args[i*3+i])));
                        }
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1); i++) {

                        allPeople.get(Integer.parseInt(args[1*(i+1)])).setName(null);
                        allPeople.get(Integer.parseInt(args[1*(i+1)])).setBirthDay(null);
                        allPeople.get(Integer.parseInt(args[1*(i+1)])).setSex(null);
                        System.out.println();
                    }
                    break;

                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1); i++) {

                        String name = allPeople.get(Integer.parseInt(args[1*(i+1)])).getName();
                        String sex;
                        if (allPeople.get(Integer.parseInt(args[1*(i+1)])).getSex().equals(Sex.MALE)) sex = "м";
                        else sex = "ж";
                        Date dateBirthday = allPeople.get(Integer.parseInt(args[1*(i+1)])).getBirthDay();

                        System.out.println(name + " " + sex + " " + dateFormatOut.format(dateBirthday));
                    }
                    break;
                }
        }

    }


}

