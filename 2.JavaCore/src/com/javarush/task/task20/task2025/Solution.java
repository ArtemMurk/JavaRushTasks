package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        long timeStart = System.currentTimeMillis();

        long[] result = null;
//        int count = String.valueOf(N).length();
//
//        int[][] pows = new int[count+1][10];
//        for (int i = 1; i <=count ; i++) {
//            for (int j = 0; j < 10 ; j++) {
//                pows[i][j] = (int)Math.pow(j,i);
//                System.out.print(pows[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        ArrayList<Integer> elemNumb = new ArrayList<>(20);
//        int currentNumb = 0;
//        elemNumb.add(0);
//        while(currentNumb<N){
//            if (elemNumb.get(elemNumb.size()-1) == 9){
//                elemNumb.set(elemNumb.size()-1, 0);
//                while (true){
//                    int tmpCounter = elemNumb.size()-2;
//                    if(tmpCounter>0){
//                        if (tmpCounter>)
//                    }
//                }
//            }
//        }
//
//
//
//
//
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < N ; i++) {
//            int currentNumber = i;
//            String size = ""+i;
//            int numInPow = 0;
//            while (currentNumber >0){
//                numInPow += pows[size.length()][currentNumber%10];
//                currentNumber= currentNumber/10;
//            }
//            if(i == numInPow) list.add(numInPow);
//        }
//
//        result = new long[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//
//        long timeFinish = System.currentTimeMillis();
//        System.out.println(timeFinish-timeStart);
//
//        return result;

        long[] armstrongNum = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474,
                54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315,
                24678050, 24678051, 88593477, 146511208, 472335975, 534494836,
                912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L,
                94204591914L, 28116440335967L, 4338281769391370L,
                4338281769391371L, 21897142587612075L, 35641594208964132L,
                35875699062250035L, 1517841543307505039L, 3289582984443187032L,
                4498128791164624869L, 4929273885928088826L};
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < armstrongNum.length ; i++) {
            if (armstrongNum[i]<N){
                list.add(armstrongNum[i]);
            }
        }

        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }


    return result;
    }



    public static void main(String[] args) {
        getNumbers(5_000_000);
    }
}
