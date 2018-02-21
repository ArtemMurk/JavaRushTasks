package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        Integer converterRadix ;
        if (s.charAt(0)=='0'){
            switch (s.charAt(1)){
                case 'b': converterRadix = Integer.parseInt(s.substring(2),2); break;
                case 'x': converterRadix = Integer.parseInt(s.substring(2),16); break;
                default: converterRadix = Integer.parseInt(s.substring(1),8); break;
            }
        }
        else converterRadix = Integer.parseInt(s,10);
        return converterRadix.toString();
        //напишите тут ваш код
    }
}
