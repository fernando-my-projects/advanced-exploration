package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.Position;

public abstract class Item implements Interactable {

    private Position pos;

    public Item(int col, int row, Field field) {
        pos = new Position(col, row, field);
    }

    @Override
    public void interact(Player player) {
        equip(player);
    }

    public abstract void equip(Player player);

}
