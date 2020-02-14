package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;

public interface Interactable {


    public void interact(Player player);

    public FieldPosition getPos();


}
