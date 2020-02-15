package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Snake extends Obstacle {


    public Snake(int col, int row, Field field){
        super(col, row, field);
        picInit();
        damage = 20;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        PrintRunTimeInfo.print("You fought a Nazi. -" + damage + " Energy, +" + reward + " points!");
        player.setEnergy(-damage);
        player.setPoints(reward);
    }

    @Override
    public void picInit() {
        rect = new Rectangle(PADDING + pos.getX(), PADDING + pos.getY(), cellSize, cellSize);
        rect.setColor(Color.RED);
    }

    @Override
    public void draw() {
        rect.fill();
    }

    @Override
    public void erase() {
        rect.delete();
    }
}
