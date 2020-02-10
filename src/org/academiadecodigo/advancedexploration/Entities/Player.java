package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.FieldPosition;

public class Player {

    private int energy = 500;
    private int points = 0;
    private FieldPosition pos;
    private boolean hasHat;
    private boolean hasWhip;
    private Field field;

    public Player(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
        this.field = field;
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

    public FieldPosition getPos() {
        return pos;
    }

    public Field getField() {
        return field;
    }
}
