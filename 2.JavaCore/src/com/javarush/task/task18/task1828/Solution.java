package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> listNum = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileCrUD = reader.readLine();
        Scanner scanner = new Scanner(new FileReader(fileCrUD));

        String productName;
        String price;
        String quantity;
        String product;
        String id;


        while (scanner.hasNextLine()) {
            String idS = scanner.nextLine();
            if (!idS.equals("")) {
                list.add(idS);

                String idC = (idS.substring(0, 8)).replaceAll(" ", "");
                listNum.add(Integer.parseInt(idC));

            }
        }

        scanner.close();

        switch (args[0]) {

            case "-c":
                int nextId = 0;
                for (int i = 0; i <listNum.size() ; i++) {
                    if (nextId < listNum.get(i)) {
                        nextId = listNum.get(i);
                        break;
                    }
                }
                nextId++;
                id = String.valueOf(nextId);

                id = changeValue(id, 8);

                productName = args[1];

                for (int i = 2; i < args.length - 2; i++) {
                    productName = productName + " " + args[i];
                }
                productName = changeValue(productName, 30);

                price = changeValue(args[args.length - 2], 8);

                quantity = changeValue(args[args.length - 1], 4);

                product = id + productName + price + quantity;
                System.out.println(product);
                list.add(product);

                break;

            case "-d":
                for (int i = 0; i <listNum.size() ; i++) {
                    if (listNum.get(i) == Integer.parseInt(args[1])){
                        list.remove(i);
                        break;
                    }
                }

                break;

            case "-u":
                for (int k = 0; k < listNum.size() ; k++) {
                    if (listNum.get(k) == Integer.parseInt(args[1])){

                        id = changeValue(args[1], 8);
                        productName = args[2];

                        for (int i = 3; i < args.length - 2; i++) {
                            productName = productName + " " + args[i];
                        }

                        productName = changeValue(productName, 30);

                        price = changeValue(args[args.length - 2], 8);

                        quantity = changeValue(args[args.length - 1], 4);

                        product = id + productName + price + quantity;
                        list.set(k, product);
                        break;
                    }
                }
                break;




        }
            FileOutputStream fileOut = new FileOutputStream(fileCrUD);

            for (String line : list) {
                fileOut.write(line.getBytes());
                fileOut.write(10);
            }


            fileOut.close();

    }

    public static String changeValue(String a, int b){
        if (a.length()<b){
            while(true){
                if (a.length()==b) break;
                a= a+" ";
            }
            return a;
        }
        if (a.length()>b){
            a = a.substring(0,b);
            return a;
        }
        return  a;
    }
}
