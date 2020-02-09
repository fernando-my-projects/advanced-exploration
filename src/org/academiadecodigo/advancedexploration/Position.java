package org.academiadecodigo.advancedexploration;

public class Position {

    private int col;
    private int row;
    private Field field;

    public Position(int col, int row, Field field){
        this.col = col;
        this.row = row;
        this.field = field;
    }

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean equals(Position pos) {
       if ((this.col == pos.getCol()) && (this.row == pos.getRow())){
           return true;
       } return false;
    }





}
