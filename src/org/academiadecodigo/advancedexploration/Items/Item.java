package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Item implements Interactable {

    protected FieldPosition pos;
    protected int cellSize;
    protected int PADDING;
    protected Rectangle rect;

    public Item(int col, int row, Field field) {
        pos = new FieldPosition(col, row, field);
        cellSize = field.getCellSize();
        PADDING = field.PADDING;
    }

    @Override
    public void interact(Player player) {
        equip(player);
    }

    public abstract void equip(Player player);

    public FieldPosition getPos() {
        return pos;
    }

}
