package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream passwordByteArray = new ByteArrayOutputStream();
        int[] letter = new int[8];
        letter[0] =(int) (Math.random()*26) + 97;//letter 1 (a-z)
        letter[1] =(int) (Math.random()*26) + 65;//letter 2 (A-Z)
        letter[2] =(int) (Math.random()*26) + 97;//letter 3 (a-z)
        letter[3] =(int) (Math.random()*10) + 48;//letter 4 (0-9)
        letter[4] =(int) (Math.random()*26) + 65;//letter 5 (a-z)
        letter[5] =(int) (Math.random()*10) + 48;//letter 1 (0-9)
        letter[6] =(int) (Math.random()*26) + 97;//letter 1 (a-z)
        letter[7] =(int) (Math.random()*26) + 65;//letter 1 (A-Z)
        for (int i = 0; i < letter.length ; i++) {
            passwordByteArray.write(letter[i]);
        }
        return passwordByteArray;
    }
}