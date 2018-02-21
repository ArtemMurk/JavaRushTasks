package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator <T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T> ... comparators) {
            this.comparators = comparators;

        }

        public int compare(T thisis,T that){

            for (Comparator<T> elem: comparators) {
                int compareElem = elem.compare(thisis, that);
                if  (compareElem != 0) return compareElem;
            }
            return 0;
        }


    }
}
