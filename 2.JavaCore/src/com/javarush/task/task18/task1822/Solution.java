package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileReader fileR = new FileReader(file);
        Scanner scanner = new Scanner(fileR);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] stringFile = line.split(" ");
            if (stringFile[0].equals(args[0])) {
                System.out.println(line);
            }
        }

        fileR.close();
        scanner.close();

    }
}
