package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.Obstacles.Obstacle;
import org.academiadecodigo.advancedexploration.PointsInterest.PointsInterest;
import org.academiadecodigo.advancedexploration.Position;

public class Player {

    private int energy = 500;
    private int points = 0;
    private Position pos;
    private boolean hasHat;
    private boolean hasWhip;

    public Player(int col, int row, Field field){

        pos = new Position(col, row, field);
    }

    public void interact(Interactable interactable){
        interactable.interact(this);
    }

    public void putOnHat(){
        hasHat = true;
        points += 50;
    }

    public void pickWhip(){
        hasWhip = true;
        points += 50;
    }

    public void setEnergy(int energy) {
        this.energy += energy;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public Position getPos() {
        return pos;
    }
}
