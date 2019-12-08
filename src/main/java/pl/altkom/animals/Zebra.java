package pl.altkom.animals;

public class Zebra implements Animal {
    private int row;
    private int col;

    public Zebra(int row, int col) {
        this.row = row;
        this.col = col;
    }


    @Override
    public void walk(int dist) {
        this.row+= dist;
        this.col+= dist;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Zeb{"+row +"-"+ col +
                '}';
    }
}
