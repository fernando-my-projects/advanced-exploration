package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Text;

public class printRunTimeInfo {
    public static void print(String s) {
        Text print = new Text(20, 500, s);
        print.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print.delete();
    }
}
