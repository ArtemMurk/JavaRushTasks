package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayList <String> movies = new ArrayList<>();
        ArrayList<Movie> moviesName = new ArrayList<>();


        String classer = reader.readLine();
        Movie movie = MovieFactory.getMovie(classer);
        moviesName.add(movie);
        while (classer.equals("soapOpera") || classer.equals("cartoon") || classer.equals("thriller") ){
            movies.add(classer);

            classer = reader.readLine();
            movie = MovieFactory.getMovie(classer);
            moviesName.add(movie);
        }

//        for (String name: movies) {
//            Movie movie = MovieFactory.getMovie(name);
//            moviesName.add(movie);
//        }



        for (Movie movie1: moviesName) {
            if (movie1 instanceof SoapOpera || movie1 instanceof Thriller || movie1 instanceof Cartoon)
              System.out.println(movie1.getClass().getSimpleName());
                }

        //ввести с консоли несколько ключей (строк), пункт 7

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            else if ("cartoon".equals(key)){
                movie = new Cartoon();
            }
            else if ("thriller".equals(key)){
                movie = new Thriller();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
    static class Cartoon extends Movie {
    }
    static class Thriller extends Movie {
    }
    //Напишите тут ваши классы, пункт 3
}
