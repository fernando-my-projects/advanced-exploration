package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Snake extends Obstacle {


    public Snake(int col, int row, Field field){
        super(col, row, field);
        picInit();
        damage = 20;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        erase();
        PrintRunTimeInfo.print("You fought a snake. -" + damage + " Energy, +" + reward + " points!");
        player.setEnergy(-damage);
        player.setPoints(reward);
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/snake.png");
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
