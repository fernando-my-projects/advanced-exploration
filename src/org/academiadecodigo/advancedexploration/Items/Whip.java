package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;

public class Whip extends Item {

    public Whip(int col, int row, Field field){
        super(col, row, field);
    }

    @Override
    public void equip(Player player) {
        player.pickWhip();
    }
}
