package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int counter = 0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[i].length ; j++) {
                if (a[i][j] != 0){
                    if(i !=0){
                        if (a[i-1][j] == 0){
                            if (j!=0){
                                if (a[i][j-1]==0) counter++;
                            }
                            else counter++;
                        }
                        else a[i][j] = a[i-1][j];
                    }
                    else if(j!=0){
                        if (a[i][j-1] ==0) counter++;
                    }
                    else counter++;
                }

            }
        }
        return counter;
    }
}
