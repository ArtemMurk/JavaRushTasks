package com.javarush.task.task23.task2303;

import com.sun.org.apache.bcel.internal.generic.ClassGenException;

/*
Запрети создание экземпляров класса
*/
public class Solution {

    public final static class Listener {
        private Listener() {
            throw new UnsupportedOperationException();
        }

        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}

class B{
    int a;

        }
