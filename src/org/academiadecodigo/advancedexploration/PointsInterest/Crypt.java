package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Crypt extends PointsInterest {

    protected boolean hasInteracted = false;

    public Crypt(int col, int row, Field field){
        super(col, row, field);
        picInit();
        reward = 100;
        penalty = 50;
        risk = 0.7;
    }

    @Override
    public void getExploreResult(Player player) {

       if (Math.random() < risk){
           player.setEnergy(-penalty);
           PrintRunTimeInfo.timerPrint(getMessage(" You lost -" + penalty + " Energy..."));
           hasInteracted = true;
           return;
       }

       player.setPoints(reward);
       PrintRunTimeInfo.timerPrint(getMessage(" You won +" + reward + " points!"));
        hasInteracted = true;
    }

    @Override
    public boolean hasInteracted() {
        return hasInteracted;
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/crypt.png");
    }

    @Override
    public void draw() {
        pic.draw();
    }

    @Override
    public void erase() {
        pic.delete();
    }

    public String getMessage(String string){

        String message = "You entered in a crypt.";

        return message + string;
    }
}
