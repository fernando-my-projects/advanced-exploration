package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;

public class Hat extends Item {

    @Override
    public void equip(Player player) {
        player.putOnHat();
    }
}
