package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        ArrayList <String> listF1 = new ArrayList<>();
        ArrayList <String> listF2 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2 = new BufferedReader(new FileReader(fileName2));
        while (file1.ready()){
            listF1.add(file1.readLine());
        }
        while (file2.ready()){
            listF2.add(file2.readLine());
        }



        int i =0;
        int j = 0;
        while (true) {
            if (i != listF1.size()-1 && j != listF2.size()-1) {
                if (listF1.get(i).equals(listF2.get(j))) {
                    lines.add(new LineItem(Type.SAME, listF1.get(i)));
                    j++;
                    i++;
                } else if (listF1.get(i + 1).equals(listF2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, listF1.get(i)));
                    i++;
                } else {
                    if (listF1.get(i).equals(listF2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, listF2.get(j)));
                        j++;
                    }
                }
            }
            else {

                if (i == listF1.size()-1 && j!= listF2.size()-1){
                    lines.add(new LineItem(Type.SAME, listF1.get(i)));
                    lines.add(new LineItem(Type.ADDED, listF2.get(j+1)));
                    break;
                }

                if (j == listF2.size()-1 && i != listF1.size()-1){
                    lines.add(new LineItem(Type.SAME, listF2.get(j)));
                    lines.add(new LineItem(Type.REMOVED, listF1.get(i+1))); break;
                }
                if (i == listF1.size()-1 && j == listF2.size()-1){
                    lines.add(new LineItem(Type.SAME, listF1.get(i))); break;
                }
            }

        }
        file1.close();
        file2.close();
        reader.close();

        System.out.println("end");
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
