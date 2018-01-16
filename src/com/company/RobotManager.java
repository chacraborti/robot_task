package com.company;

public class RobotManager {
    private Robot robot;
    private static int turn = 0;

    public RobotManager(Robot robot) {
        this.robot = robot;
    }

    public void go(){
        for (int i = 0; i < robot.getNumberOfLegs(); i++) {
            Foot foot = new Foot(i, this);
            Thread thread = new Thread(foot);
            thread.start();
        }
    }

    public void increaseTurn(){
        if(turn==robot.getNumberOfLegs()-1) {
            turn = 0;
        } else {
            turn++;
        }
    }

    public int getTurn() {
        return turn;
    }
}
