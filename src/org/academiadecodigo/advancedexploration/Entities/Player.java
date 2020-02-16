package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Player {

    private int energy = 500;
    private int points = 0;
    private FieldPosition pos;
    private boolean hasHat;
    private boolean hasWhip;
    private Field field;
    private boolean scoreNotUpdated = false;
    private boolean hasMoved;
    private int equipReward = 50;

    public Player(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
        this.field = field;
    }

    public void interact(Interactable interactable){
        interactable.interact(this);
    }

    public void putOnHat(){
        hasHat = true;
        points += equipReward;
        PrintRunTimeInfo.timerPrint(getMessage("You have picked up a Hat."));
    }

    public int getPoints(){
        return points;
    }

    public int getEnergy(){
        return energy;
    }


    public void pickWhip(){
        hasWhip = true;
        points += equipReward;
        PrintRunTimeInfo.timerPrint(getMessage("You have picked up a Whip."));
    }

    public boolean hasHat() {
        return hasHat;
    }

    public boolean hasWhip() {
        return hasWhip;
    }

    public void setToZero(){
        energy = 0;
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

    public void setScoreNotUpdated(boolean condition){
        scoreNotUpdated = condition;
    }

    public boolean getScoreNotUpdated(){
        return scoreNotUpdated;
    }

    public void setHasMoved(boolean state) {
        hasMoved = state;
    }

    public boolean hasMoved(){
        return hasMoved;
    }

    public String getMessage(String string){
        return string + " You won " + equipReward + " points.";
    }
}
