package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Hat extends Item {

    public Hat(int col, int row, Field field){
        super(col, row, field);
        picInit();
    }

    @Override
    public void equip(Player player) {
        player.putOnHat();
    }

    @Override
    public void picInit() {
        rect = new Rectangle(PADDING + pos.getX(), PADDING + pos.getY(), cellSize, cellSize);
        rect.setColor(Color.ORANGE);
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
