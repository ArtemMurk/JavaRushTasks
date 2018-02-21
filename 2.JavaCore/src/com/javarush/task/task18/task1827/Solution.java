package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileCrUD = reader.readLine();
        Scanner scanner = new Scanner(new FileReader(fileCrUD));
        int nextId = 0;
        while (scanner.hasNextLine()) {
            String idS = scanner.nextLine();
            if (!idS.equals("")) {
                list.add(idS);
                idS = idS.substring(0, 8);
                String idC = idS.replaceAll(" ", "");
                int id = Integer.parseInt(idC);
                if (nextId < id) {
                    nextId = id;
                }
            }
        }
        nextId++;
        scanner.close();

        if (args[0].equals("-c")) {

            String id = String.valueOf(nextId);
            id = changeValue(id, 8);

            String productName = args[1];

            for (int i = 2; i < args.length - 2; i++) {
                productName = productName + " " + args[i];
            }
            productName = changeValue(productName, 30);

            String price = changeValue(args[args.length - 2], 8);

            String quantity = changeValue(args[args.length - 1], 4);

            String product = id + productName + price + quantity;
            System.out.println(product);
            list.add(product);

            FileOutputStream fileOut = new FileOutputStream(fileCrUD);

            for (String line : list) {
                fileOut.write(line.getBytes());
                fileOut.write(10);
            }



            fileOut.close();
        }
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
