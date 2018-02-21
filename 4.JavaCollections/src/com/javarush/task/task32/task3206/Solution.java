package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;
import java.util.*;

/* 
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item

        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public Item getProxy(Class<? extends Item> itemClass, Class ... interfaces) {
        ArrayList<Class> listOfTotalCountInterfaces = new ArrayList<>();
        ItemInvocationHandler itemInvocationHandler = new ItemInvocationHandler();
        listOfTotalCountInterfaces.add(itemClass);
        for (int i = 0; i <interfaces.length ; i++) {
            listOfTotalCountInterfaces.add(interfaces[i]);
        }
        Class<?>[] interToProxy = new Class[listOfTotalCountInterfaces.size()];
        for (int i = 0; i <listOfTotalCountInterfaces.size() ; i++) {
            interToProxy[i]= listOfTotalCountInterfaces.get(i);
        }

        ClassLoader classLoader = this.getClass().getClassLoader();

        Item item = (Item) Proxy.newProxyInstance(classLoader,interToProxy,itemInvocationHandler);

        return item;

    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}