package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    public static List<Integer> busyNum = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (FileReader fileReader = new FileReader(reader.readLine()); BufferedReader buffStr = new BufferedReader(fileReader)){
            StringBuilder strB = new StringBuilder();

            while (buffStr.ready()){
                String tmpBuff = buffStr.readLine();
                strB.append(tmpBuff+" ");

            }

            String[] normalStr = strB.toString().split(" ");
            for (int i = 0; i <normalStr.length ; i++) {
                if (checkNum(i)) {

                    String firstStr = normalStr[i];
                    for (int j = 0; j < normalStr.length; j++) {

                        if (i != j && checkNum(j)&&checkNum(i)) {
                            StringBuilder secondStr = new StringBuilder(normalStr[j]);
                            secondStr.reverse();
                            if(firstStr.equals(secondStr.toString())){
                                Pair pair = new Pair();
                                pair.first=firstStr;
                                pair.second = normalStr[j];
                                result.add(pair);
                                busyNum.add(i);
                                busyNum.add(j);

                            }
                        }
                    }
                }
            }
            System.out.println();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkNum(int thisNum){
        for (Integer thatNum:busyNum) {
            if(thatNum==thisNum)return false;
        }
        return true;
    }

    public static class Pair {
        String first;
        String second;



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
