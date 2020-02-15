package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hat extends Item {

    public Hat(int col, int row, Field field){
        super(col, row, field);
        picInit();
    }

    @Override
    public void equip(Player player) {
        erase();
        player.putOnHat();
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/hat.png");
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
