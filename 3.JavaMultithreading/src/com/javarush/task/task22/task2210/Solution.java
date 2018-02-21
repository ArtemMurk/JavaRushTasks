package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        List<String> listTokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreElements()){
            listTokens.add(tokenizer.nextToken());
        }

        String[] tokens = new String[listTokens.size()];
        for (int i = 0; i < listTokens.size() ; i++) {
            tokens[i] = listTokens.get(i);
        }

        return tokens;
    }
}
