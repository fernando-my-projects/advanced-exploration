package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Obstacles.Obstacle;
import org.academiadecodigo.advancedexploration.PointsInterest.PointsInterest;
import org.academiadecodigo.advancedexploration.Position;

public class Player {

    private int energy = 500;
    private int points = 0;
    private Position pos;
    private boolean hasHat;
    private boolean hasWhip;

    public Player(){

        pos = new Position();
    }

    public void explore(PointsInterest pi){
        pi.getExploreResult(this);
    }

    public void fight(Obstacle obs){
        obs.getFightResult(this);
    }

    public void putOnHat(){
        hasHat = true;
    }

    public void pickWhip(){
        hasWhip = true;
    }

    public void setEnergy(int energy) {
        this.energy += energy;
    }

    public void setPoints(int points) {
        this.points += points;
    }
}
