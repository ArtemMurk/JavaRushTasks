package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {


    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        int countDishes =(int) (Math.random()*6);
        Dish[] dishesList = Dish.values();

        for (int i = 0; i <countDishes ; i++) {
            int numberDish = (int) (Math.random()*(dishesList.length));
            dishes.add(dishesList[numberDish]);
        }
    }
}
