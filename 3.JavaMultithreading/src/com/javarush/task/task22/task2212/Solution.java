package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        // Check null
        if(telNumber == null) return false;
        //check digit in the end
        if(!telNumber.matches(".*\\d$")) return false;
        //check letters in number
        if (!(telNumber.replaceAll("\\d","").length()== telNumber.replaceAll("\\w","").length())) return false;
        // check "-"
       if ((telNumber.length()-telNumber.replaceAll("-","").length() < 3)) {

           if ( telNumber.indexOf("-") == telNumber.lastIndexOf("-") - 1) return false;
       }
       else return false;

       // check "(" ")" and check that () contain 3 digit
       if (telNumber.contains("(") || telNumber.contains(")")){
           if (telNumber.indexOf("(")== telNumber.lastIndexOf("(") && telNumber.indexOf(")")== telNumber.lastIndexOf(")")) {
               if(telNumber.contains("-")&&telNumber.indexOf(")")>telNumber.indexOf("-")) return false;
               if(!telNumber.matches(".*\\(\\d{3}\\).*")) return false;
           }
           else return false;
       }

       //check + (12 digit), else (10) digit
       if (telNumber.charAt(0) == '+') {
            if (telNumber.replaceAll("\\D", "").length() != 12) return false;
            else return true;
        }
        else if (telNumber.matches("^\\d.*|^\\(.*")){
            if (telNumber.replaceAll("\\D", "").length() != 10) return false;
            else return true;
        }



        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("05(025)44567"));

    }
}
