package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution  {
    public static void main(String[] args) throws IOException{

    }

    public static Planet thePlanet ;
    static {

        try {

            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {

        }
    }


    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planetName = reader.readLine();
        if (planetName.equals(Planet.EARTH))
            thePlanet = Earth.getInstance();
        else if (planetName.equals(Planet.MOON)){
            thePlanet = Moon.getInstance();
        } else if (planetName.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        } else thePlanet=null;
        reader.close();

        // implement step #5 here - реализуйте задание №5 тут
    }
}
