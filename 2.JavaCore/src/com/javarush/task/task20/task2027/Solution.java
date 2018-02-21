package com.javarush.task.task20.task2027;

import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'e', 'm', 'e', 'm', 'e', 'm'},
                {'h', 's', 'o', 'o', 'o', 'o'},
                {'o', 'm', 'o', 'd', 'o', 'm'},
                {'h', 'h', 'o', 'o', 'o', 'h'},
                {'p', 'm', 'm', 'm', 'h', 'm'}
        };
        detectAllWords(crossword, "dom","home" );
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> allWords = new LinkedList<>();

        for (String word: words) {
            char firstLetter = word.charAt(0);
            for (int i =0 ; i <crossword.length; i++) {
                for (int j = 0; j <crossword[i].length; j++) {

                    // If we find first letter of this word, we check positions of other letters
                    if (crossword[i][j]== firstLetter ){

                        try{
                            allWords.add(checkWord(crossword, word,i,j,0,+1));
                        }catch (Exception e){}

                        try{
                            allWords.add(checkWord(crossword, word,i,j,+1,0));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,-1,0));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,0,-1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,+1,+1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,-1,-1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,+1,-1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,-1,+1));
                        }catch (Exception e){}

                    }
                }
            }



        }

        return allWords;
    }

    public static Word checkWord(int[][] crossword, String word, int i, int j, int vectorI, int vectorJ) throws Exception {
        int positions[] = new int[4];
        Word wordFirst = new Word(word);

        positions[0] = j;
        positions[1] = i;

        for (int checkLength = 1; checkLength < word.length(); checkLength++) {
            if (word.charAt(checkLength) != crossword[i + vectorI*checkLength][j + vectorJ*checkLength]) {
                throw new Exception();
            }
            if (checkLength == word.length() - 1) {
                positions[3] = i + (vectorI * word.length()) - vectorI;
                positions[2] = j + (vectorJ*word.length()) - vectorJ;
                wordFirst.setStartPoint(positions[0], positions[1]);
                wordFirst.setEndPoint(positions[2], positions[3]);
            }
        }
        return wordFirst;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
