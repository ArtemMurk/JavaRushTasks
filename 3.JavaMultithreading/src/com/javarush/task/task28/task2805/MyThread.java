package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger prority = new AtomicInteger(1);

    public MyThread() {
        this.setPriority(this.setCurrentPriority());
    }

    public MyThread(Runnable runnable) {
        super(runnable);
        this.setPriority(this.setCurrentPriority());

    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
        int priorityGroup = threadGroup.getMaxPriority();
        int currentPriority = setCurrentPriority();
        if (priorityGroup<currentPriority) this.setPriority(priorityGroup);
        else this.setPriority(currentPriority);
    }

    public MyThread(String s) {
        super(s);
        this.setPriority(this.setCurrentPriority());

    }

    public MyThread(ThreadGroup threadGroup, String s) {
        super(threadGroup, s);
        int priorityGroup = threadGroup.getMaxPriority();
        int currentPriority = setCurrentPriority();
        if (priorityGroup<currentPriority) this.setPriority(priorityGroup);
        else this.setPriority(currentPriority);
    }

    public MyThread(Runnable runnable, String s) {
        super(runnable, s);
        this.setPriority(this.setCurrentPriority());

    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s) {
        super(threadGroup, runnable, s);
        int priorityGroup = threadGroup.getMaxPriority();
        int currentPriority = setCurrentPriority();
        if (priorityGroup<currentPriority) this.setPriority(priorityGroup);
        else this.setPriority(currentPriority);

    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l) {
        super(threadGroup, runnable, s, l);
        int priorityGroup = threadGroup.getMaxPriority();
        int currentPriority = setCurrentPriority();
        if (priorityGroup<currentPriority) this.setPriority(priorityGroup);
        else this.setPriority(currentPriority);
    }

    private int setCurrentPriority(){

        int prior = prority.getAndIncrement();
        if (prority.get()>10) prority.set(1);
        return prior;
    }
}
