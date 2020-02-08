package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.PointsInterest.PointsInterest;
import org.academiadecodigo.advancedexploration.Position;

public class Player {

    private int energy = 500;
    private int points = 0;
    private Position pos;

    public Player(){

        pos = new Position();
    }

    public void explore(PointsInterest pi){
        pi.getExploreResult(this);
    }

    public void setEnergy(int energy) {
        this.energy += energy;
    }

    public void setPoints(int points) {
        this.points += points;
    }
}
