package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.Position;

public abstract class Item implements Interactable {

    private Position pos;

    public Item() {
        pos = new Position();
    }

    @Override
    public void interact(Player player) {
        equip(player);
    }

    public abstract void equip(Player player);

}
