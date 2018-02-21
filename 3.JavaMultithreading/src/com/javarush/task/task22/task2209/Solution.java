package com.javarush.task.task22.task2209;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Arrays;

/* 
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        String[] currentStr = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()))){
            String strLineFromFile = fileR.readLine();
            if (strLineFromFile != null)
            currentStr = strLineFromFile.split(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder result = getLine(currentStr);
        System.out.println(result.toString());


    }
    //Метод возвращает самую длинную цепочку
    public static StringBuilder getLine(String... words) {
        Arrays.sort(words); // Тут это сделанно только ради ВАЛЛИДАТОРА!
        StringBuilder[] buffSB = new StringBuilder[words.length];
        StringBuilder bestChain = new StringBuilder();
        for (int i = 0; i < words.length ; i++) { // Проверяем построение самой длинной цепочки для каждого слова
            buffSB[i] = wordChain(i, words);// Передаем номер первого слова и  список слов
            if (bestChain.length()<buffSB[i].length()) bestChain = buffSB[i];
        }


    return bestChain;
    }
    //Метод Составляет цепочку слов связывая все слова с первым словом
    public static StringBuilder wordChain (int firstNum, String[] words){
        StringBuilder str = new StringBuilder();
        if (words != null) {
            str.append(words[firstNum]);
            words[firstNum] = ""; //Обнуляем строку для облегчения поиска
            for (int i = 1; i < words.length ; i++) {
                for (int j = 1; j < words.length; j++) {
                    if (!words[j].equals("")) {


                        if (Character.toLowerCase(words[j].charAt(0)) == Character.toLowerCase(str.charAt(str.length()-1))) {
                            str.append(" "+words[j]);
                            words[j] = "";
                        }
                        else if(Character.toLowerCase(words[j].charAt(words[j].length()-1)) == Character.toLowerCase(str.charAt(0))){
                            str.insert(0, words[j]+" ");
                            words[j] = "";
                        }
                    }
                }
            }
        }

        return str;
    }
}
