package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public interface Interactable {

    FieldPosition getPos();

    void picInit();

    void draw();

    void erase();

    void interact(Player player);
}
