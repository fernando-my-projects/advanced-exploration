package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;

public class Whip extends Item {

    @Override
    public void equip(Player player) {
        player.pickWhip();
    }
}
