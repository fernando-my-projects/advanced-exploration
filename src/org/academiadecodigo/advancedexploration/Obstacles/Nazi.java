package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Nazi extends Obstacle {

    public Nazi(int col, int row, Field field){
        super(col, row, field);
        picInit();
        damage = 40;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        player.setPoints(reward);
        player.setEnergy(-damage);
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/nazi-hitler.png");
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
