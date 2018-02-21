package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (mail) {

            try {
                //сделайте что-то тут - do something here
                    Thread.sleep(1000);

                    mail.setText("Person [" + name + "] has written an email 'AAA'");
                        mail.notify();

                    //сделайте что-то тут - do something here
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
}
