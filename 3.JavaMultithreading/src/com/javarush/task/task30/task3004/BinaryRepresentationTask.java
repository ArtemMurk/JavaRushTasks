package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask  extends RecursiveTask<String>{
    int valueI;
    public BinaryRepresentationTask(int i) {
        this.valueI = i;
    }

    @Override
    protected String compute() {
        int a = valueI % 2;
        int b = valueI / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;
    }
}
