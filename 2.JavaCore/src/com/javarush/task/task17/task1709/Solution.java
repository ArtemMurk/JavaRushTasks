package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {
    public static int proposal = 0;
    public synchronized static int propos(){
          return  proposal;
    }


    public static void main(String[] args) {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public  void run() {
            int thisProposal = propos();

            while (propos() < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));

                proposal = ++thisProposal;
                Thread.yield();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public synchronized void run() {
            int thisProposal = propos();

            while (thisProposal < 10) {
                if (thisProposal != propos()) {
                    System.out.println("Принято предложение №" + propos());
                    thisProposal = propos();
                }

            }
        }
    }
}
