package com.javarush.task.task28.task2813;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FactorialCalculator implements Callable {
    Lock lock = new ReentrantLock();
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws InterruptedException {
        return factorial(number);
    }

    public long factorial(int number) throws InterruptedException {
        lock.lock();
        long result;
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Number must be greater than zero");
            }
            result = 1;
            while (number > 1) {
                Thread.sleep(1);
                result = result * number;
                number--;
            }
        } finally {
            lock.unlock();
        }
        return result;
    }
}
