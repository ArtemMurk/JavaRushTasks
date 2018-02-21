package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.ad.Advertisement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;



    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.initDishes();

    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes==null)return "";
        else {
            StringBuilder orderDishes = new StringBuilder();
            orderDishes.append(dishes.get(0));
            for (int i = 1; i <dishes.size() ; i++) {
                orderDishes.append(", ");
                orderDishes.append(dishes.get(i).toString());
            }
            return "Your order: ["+orderDishes.toString()+"] of "+tablet.toString();
        }
    }

    public int getTotalCookingTime(){
        int totalCookingTime =0;
        for (Dish dish: dishes) {
            totalCookingTime+=dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty(){
        return dishes.size() == 0;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();

    }
}

