package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Nazi extends Obstacle {

    public Nazi(int col, int row, Field field){
        super(col, row, field);
        picInit();
        damage = 40;
        reward = damage*2;
    }

    @Override
    public void getFightResult(Player player) {
        PrintRunTimeInfo.print("You fought a Nazi. -" + damage + " Energy, +" + reward + " points!");
        player.setPoints(reward);
        player.setEnergy(-damage);
    }

    @Override
    public void picInit() {
        rect = new Rectangle(PADDING + pos.getX(), PADDING + pos.getY(), cellSize, cellSize);
        rect.setColor(Color.DARK_GRAY);
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
