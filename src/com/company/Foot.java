package com.company;

public class Foot implements Runnable{
    private int number;
    RobotManager manager;

    private static Object object = new Object();

    public Foot(int number, RobotManager manager) {
        this.number = number;
        this.manager = manager;
    }

    public void run() {
        for (; ; ) {
            synchronized (object) {
                if (itIsMyTurn()) {
                    step();
                   object.notifyAll();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

    private boolean itIsMyTurn() {
        boolean condition = number == manager.getTurn();
        if(condition){
            manager.increaseTurn();
        }
        return condition;
    }

    private void step() {
        System.out.println("Step by " + number);

    }
}
