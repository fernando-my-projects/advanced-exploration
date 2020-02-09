package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.keyboard.KeyboardEvent;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardHandler;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class PlayerMoves implements KeyboardHandler {

    private Picture nazi;
    public PlayerMoves() {
        nazi = new Picture(0,0, "/Users/codecadet/Desktop/advanced-exploration/images/nazi-hitler.PNG");
        nazi.draw();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                nazi.translate(10,0);
                break;
            case KeyboardEvent.KEY_LEFT:
                nazi.translate(-10,0);
                break;
            case KeyboardEvent.KEY_DOWN:
                nazi.translate(0,10);
                break;
            case KeyboardEvent.KEY_UP:
                nazi.translate(0,-10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}
