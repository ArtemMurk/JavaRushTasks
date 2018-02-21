package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        Throwable causes = e.getCause();
        ArrayList<Throwable> arrCauses = new ArrayList<>();
        arrCauses.add(e);
        while (causes != null){
            arrCauses.add(causes);
            causes= causes.getCause();
        }
        for (int i= arrCauses.size()-1; i >=0 ; i--) {
            System.out.println(arrCauses.get(i).getClass().getName()+": "+arrCauses.get(i).getMessage());

        }

    }

    public static void main(String[] args) {
try {
    throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

}
catch (Exception e) {
    Throwable causes = e.getCause();
    ArrayList<Throwable> arrCauses = new ArrayList<>();
    arrCauses.add(e);
    while (causes != null) {
        arrCauses.add(causes);
        causes = causes.getCause();
    }
    for (int i = arrCauses.size() - 1; i >= 0; i--) {
        System.out.println(arrCauses.get(i));

    }
}
    }
}
