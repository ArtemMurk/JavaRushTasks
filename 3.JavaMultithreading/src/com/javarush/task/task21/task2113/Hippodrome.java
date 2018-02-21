package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        Horse horseKarina = new Horse("Karina", 3, 0);
        Horse horseVelta = new Horse("Velta", 3, 0);
        Horse horseMegan = new Horse("Megan", 3, 0);
        List<Horse> horsesHippodrome = new ArrayList<>();
        horsesHippodrome.add(horseKarina);
        horsesHippodrome.add(horseMegan);
        horsesHippodrome.add(horseVelta);

        Hippodrome hippodrome = new Hippodrome(horsesHippodrome);
        Hippodrome.game = hippodrome;

        game.run();
        game.printWinner();
    }

    
    public List<Horse> getHorses(){
        return horses;
    }

    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }
    }

    public void run(){
        for (int i = 0; i <100 ; i++) {
            this.move();
            this.print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public Horse getWinner(){
        double bestDistance = 0;
        Horse winnerHorse = null;
        for (Horse horse:horses) {
            if (horse.getDistance()>bestDistance) {
                bestDistance=horse.getDistance();
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner(){
        System.out.println("Winner is "+this.getWinner().getName()+"!");
    }
}
