package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
            Integer[] a = sort(new Integer[]{17, 13, 5, 8, 15, 11, -1, -18});
        for (Integer elem: a) {
            System.out.print(elem+" ");
        }
    }

    public static Integer[] sort(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] arraySorted = array;

        list.addAll(Arrays.asList(arraySorted));
        Collections.sort(list);
        int pivot;
        if (list.size()%2 == 0)       pivot = (list.get(arraySorted.length/2)+list.get(arraySorted.length/2-1))/2;
        else pivot = list.get(arraySorted.length/2);

        Collections.sort(list, (integer, t1) -> Math.abs(pivot - integer) - Math.abs(pivot - t1));
        for (int i = 0; i < list.size(); i++) {
            arraySorted[i] = list.get(i);
        }




        return arraySorted;
    }
}
