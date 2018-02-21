package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    private String predicatePlusOrMinus = " +";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Integer.toString(1,3));
        System.out.println(Integer.toString(3,3));
        System.out.println(Integer.toString(9,3));
        System.out.println(Integer.toString(81,3));
        System.out.println(Integer.toString(243,3));
        System.out.println(Integer.toString(729,3));
        System.out.println(Integer.toString(2187,3));


        System.out.println(Integer.toString(74,3));
        System.out.println(Integer.toString(2,3));
        System.out.println(Integer.toString(1234,3));
        System.out.println(Integer.toString(3000,3));
        System.out.println(Integer.toString(43,3));
//        System.out.println(Integer.toString(17,3));
//        System.out.println(Integer.toString(19,3));
        solution.createExpression(43);
    }



    public void createExpression(int number) {

        int[] numbersInPow = {1,3,9,27, 81, 243, 729, 2187};

        StringBuilder stringBuilder = new StringBuilder();

        String numberThreeDegreesExpression = Integer.toString(number,3);
        stringBuilder.append(number);
        stringBuilder.append(" =");
        numberThreeDegreesExpression = reverseString(numberThreeDegreesExpression);

        char[] arrayNumberThreeDegreesExpression = numberThreeDegreesExpression.toCharArray();
        for (int i =0; i<arrayNumberThreeDegreesExpression.length; i++) {

            if (arrayNumberThreeDegreesExpression[i]=='0'){
                predicatePlusOrMinus = " +";
            }


            if (arrayNumberThreeDegreesExpression[i]=='2'){
                if (i!=0&&arrayNumberThreeDegreesExpression[i-1] =='2'){

                }
                else if (i== 0 || arrayNumberThreeDegreesExpression[i-1]=='0'){
                    changePredicate();
                    stringBuilder.append(predicatePlusOrMinus);
                    stringBuilder.append(" ");
                    stringBuilder.append(numbersInPow[i]);
                } else if (predicatePlusOrMinus.equals(" -")){
                    stringBuilder.append(predicatePlusOrMinus);
                    stringBuilder.append(" ");
                    stringBuilder.append(numbersInPow[i]);
                    changePredicate();
                } else {
                    if (predicatePlusOrMinus.equals(" +")) changePredicate();
                    stringBuilder.append(predicatePlusOrMinus);
                    stringBuilder.append(" ");
                    stringBuilder.append(numbersInPow[i]);
                }

                if (    (i==arrayNumberThreeDegreesExpression.length-1)||
                        (arrayNumberThreeDegreesExpression[i+1] =='0')){
                    predicatePlusOrMinus = " +";
                    stringBuilder.append(predicatePlusOrMinus);
                    stringBuilder.append(" ");
                    stringBuilder.append(numbersInPow[i+1]);
                }
            }

            if (arrayNumberThreeDegreesExpression[i] == '1'){
                if (i== 0) {
                    stringBuilder.append(predicatePlusOrMinus);
                    stringBuilder.append(" ");
                    stringBuilder.append(numbersInPow[i]);
                } else if (predicatePlusOrMinus.equals(" -")){
                    if ((i==arrayNumberThreeDegreesExpression.length-1)||(arrayNumberThreeDegreesExpression[i+1]=='0')){
                        stringBuilder.append(predicatePlusOrMinus);
                        stringBuilder.append(" ");
                        stringBuilder.append(numbersInPow[i]);

                        changePredicate();
                        stringBuilder.append(predicatePlusOrMinus);
                        stringBuilder.append(" ");
                        stringBuilder.append(numbersInPow[i+1]);
                    } else  {
                        stringBuilder.append(predicatePlusOrMinus);
                        stringBuilder.append(" ");
                        stringBuilder.append(numbersInPow[i]);
                    }

                } else {
                    stringBuilder.append(predicatePlusOrMinus);
                    stringBuilder.append(" ");
                    stringBuilder.append(numbersInPow[i]);
                }
            }
        }

        System.out.println(new String(stringBuilder));
        //напишите тут ваш код
    }

    private String reverseString(String text){
        StringBuilder reverseBuilder = new StringBuilder(text);
        reverseBuilder.reverse();
        return new String(reverseBuilder);
    }

    private void changePredicate(){
        if (predicatePlusOrMinus.equals(" +")){
            predicatePlusOrMinus = " -";
        } else predicatePlusOrMinus = " +";
    }
}