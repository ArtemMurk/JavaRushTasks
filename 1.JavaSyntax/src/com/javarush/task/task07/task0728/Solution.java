package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        int[] arr2= new int[20];
        for (int i = 0; i < 20 ; i++) {
            arr2[i] = array[i];
        }
        Arrays.sort(arr2);
        array[0] = arr2[19];
        array[1] = arr2[18];
        array[2] = arr2[17];
        array[3] = arr2[16];
        array[4] = arr2[15];
        array[5] = arr2[14];
        array[6] = arr2[13];
        array[7] = arr2[12];
        array[8] = arr2[11];
        array[9] = arr2[10];
        array[10] = arr2[9];
        array[11] = arr2[8];
        array[12] = arr2[7];
        array[13] = arr2[6];
        array[14] = arr2[5];
        array[15] = arr2[4];
        array[16] = arr2[3];
        array[17] = arr2[2];
        array[18] = arr2[1];
        array[19] = arr2[0];
    }
}
