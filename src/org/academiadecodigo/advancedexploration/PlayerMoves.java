package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.keyboard.KeyboardEvent;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardHandler;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class PlayerMoves implements KeyboardHandler {

    private Picture indi;
    public PlayerMoves() {

        indi = new Picture(0,0, "images/indi_50x50.png");
        indi.draw();

        /*nazi = new Picture(0,0, "/Users/codecadet/IdeaProjects/advanced-exploration/images/nazi-hitler.PNG");
        nazi.draw();*/
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                indi.translate(10,0);
                break;
            case KeyboardEvent.KEY_LEFT:
                indi.translate(-10,0);
                break;
            case KeyboardEvent.KEY_DOWN:
                indi.translate(0,10);
                break;
            case KeyboardEvent.KEY_UP:
                indi.translate(0,-10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}
