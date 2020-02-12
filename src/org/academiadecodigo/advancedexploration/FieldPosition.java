package org.academiadecodigo.advancedexploration;

public class FieldPosition {

    private int col;
    private int row;
    private Field field;

    public FieldPosition(int col, int row, Field field){
        this.col = col;
        this.row = row;
        this.field = field;
    }

    public FieldPosition(int col, int row){
        this.col = col;
        this.row = row;
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int num) {
        col += num;
    }

    public void setRow(int num) {
        row += num;
    }

    public int getX() {
        return col * field.getCellSize();
    }

    public int getY() {
        return row * field.getCellSize();
    }

    public boolean equals(FieldPosition pos) {
       if ((this.col == pos.getCol()) && (this.row == pos.getRow())){
           return true;
       } return false;
    }





}
