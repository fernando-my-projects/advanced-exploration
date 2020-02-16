package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Nazi extends Obstacle {

    protected boolean hasInteracted = false;

    public Nazi(int col, int row, Field field){
        super(col, row, field);
        picInit();
        damage = 40;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        PrintRunTimeInfo.print("You fought a Nazi. -" + damage + " Energy, +" + reward + " points!");
        erase();
        player.setPoints(reward);
        player.setEnergy(-damage);
        hasInteracted = true;
    }

    @Override
    public boolean hasInteracted() {
        return hasInteracted;
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
