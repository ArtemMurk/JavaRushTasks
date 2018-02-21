package com.javarush.task.task32.test;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListA  = new ArrayList<>();
        ArrayList<Integer> arrayListB = new ArrayList<>();

        arrayListA.add(1);
        arrayListA.add(3);
        arrayListA.add(5);

        arrayListB.add(2);
        arrayListB.add(6);
        arrayListB.add(8);
        merge(arrayListA,arrayListB);

        for (int i = 0; i < arrayListA.size() ; i++) {
            System.out.println(arrayListA.get(i));
        }

    }

    static void merge(ArrayList<Integer> a, ArrayList<Integer> b){
        int incrementA = 0;
        int incrementB = 0;


        while(true) {
            if (incrementB <= (b.size()-1)){
                if (a.get(incrementA).compareTo(b.get(incrementB))>0){
                    a.add(incrementA,b.get(incrementB));
                    incrementB++;
                } else {
                    if (incrementA <(a.size()-1)) incrementA++;
                    else{
                        a.add(incrementA+1,b.get(incrementB));
                        incrementB++;
                        }
                }
            } else break;

        }
    }
}
