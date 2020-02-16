package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Whip extends Item {
    protected boolean hasInteracted = false;

    public Whip(int col, int row, Field field){
        super(col, row, field);
        picInit();
    }

    @Override
    public void equip(Player player) {
        erase();
        player.pickWhip();
        hasInteracted = true;
    }

    @Override
    public boolean hasInteracted() {
        return hasInteracted;
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/whip.png");
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
