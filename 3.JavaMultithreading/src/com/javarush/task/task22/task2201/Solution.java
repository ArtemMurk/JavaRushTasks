package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName)  {
        try {
            int firstTab = string.indexOf("\t");
            int secondTab = string.lastIndexOf("\t");
            return string.substring(firstTab+1,secondTab);
        } catch (Exception e) {
            e.getCause();

            TooShortStringFirstThreadException t1 = new TooShortStringFirstThreadException();
            t1.initCause(e);
            TooShortStringSecondThreadException t2 = new TooShortStringSecondThreadException();
            t2.initCause(e);
            if (threadName.equals("1#")) throw t1;
            if (threadName.equals("2#")) throw t2;
            RuntimeException runE = new RuntimeException("RuntimeException");
            runE.initCause(e);
            throw runE;

        }
    }
}
