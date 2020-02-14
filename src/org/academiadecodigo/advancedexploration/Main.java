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
        code.draw(); */

        Game game = new Game(10, 11);
        game.start();

        //Game game = new Game(10, 11);

        //game.init();

        /*Rectangle rect = new Rectangle(10, 10, 25, 25);
        rect.setColor(Color.BLUE);
        rect.fill();
        Rectangle rect1 = new Rectangle(35, 10, 25, 100);
        rect1.setColor(Color.YELLOW);
        rect1.draw();*/


    }

}
