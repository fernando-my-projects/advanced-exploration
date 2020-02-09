package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Position;

public abstract class Item {

    Position pos;

    public Item() {
        pos = new Position();
    }

    public abstract void equip(Player player);

}
