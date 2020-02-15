package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Crypt extends PointsInterest {

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
           return;
       }

       player.setPoints(reward);
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
}
