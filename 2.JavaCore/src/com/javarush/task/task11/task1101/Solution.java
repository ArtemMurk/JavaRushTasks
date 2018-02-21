package com.javarush.task.task11.task1101;

/*
Лошадь и Пегас
*/

import org.omg.CORBA.IntHolder;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException{
        int[] arr = {1, 2, 3,4};
        permute(arr, 4);
        OutputStream sdf = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream("/home/artem/primer1.txt")));
    }

    public class Horse {

    }

    public class Pegas extends Horse {

    }
    public static void permute(int[] arr, int quantity){
        if (quantity<3) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = 0; i < quantity ; i++) {
                swap(arr, i, quantity - 1);
            if (quantity >= 2 && quantity-1 != i)

                permute(arr, quantity - 1);

        }
    }

    public static void swap(int[] arr, int index0, int index1){
            int tmp = arr[index0];
            arr[index0] = arr[index1];
            arr[index1] = tmp;
    }

}
