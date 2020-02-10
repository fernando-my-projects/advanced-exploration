package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Color;
import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.graphics.Text;
import org.academiadecodigo.advancedexploration.keyboard.Keyboard;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardEvent;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardEventType;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardHandler;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class Main {

    public static void main(String[] args) {

        /*Rectangle canvas = new Rectangle(0,0,1600,800);
        canvas.setColor(Color.YELLOW);
        canvas.fill();

        Text code = new Text(250,100,"ArquiJones Adventure");
        code.draw();*/

        KeyboardHandler playerMoves = new PlayerMoves();
        Keyboard k = new Keyboard(playerMoves);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventRight);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventLeft);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventDown);

        Game game = new Game(10, 11);

        game.init();


    }

}
