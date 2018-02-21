package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Добро пожаловать в ресторан \"Marcony Brothrers\":\n" +
                "На сегодня у нас представлены такие блюда:\n"+
                    Dish.allDishesToString()+"\n"+
                "После выбора блюд введите \"exit\" для формирования заказа\n");

        List<Dish> dishesForOrder = new ArrayList<>();


        while (true){
            String dish = readString();
            switch (dish){
                case "Fish":dishesForOrder.add(Dish.Fish); break;
                case "Steak":dishesForOrder.add(Dish.Steak); break;
                case "Soup":dishesForOrder.add(Dish.Soup); break;
                case "Juice":dishesForOrder.add(Dish.Juice); break;
                case "Water":dishesForOrder.add(Dish.Water); break;
                case "exit": return dishesForOrder;
            }
        }
    }

}
