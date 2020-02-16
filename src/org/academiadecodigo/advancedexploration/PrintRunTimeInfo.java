package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PrintRunTimeInfo {
    public static void print(String s) {
        Text print = new Text(40, 525, s);
        print.setColor(Color.WHITE);
        print.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print.delete();
    }
}
