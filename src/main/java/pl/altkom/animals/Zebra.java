package pl.altkom.animals;

import java.util.Random;

public class Zebra implements Herbivore {
    private int row;
    private int col;
    private Random rand = new Random();

    public Zebra(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void beEaten() {
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void walk(int dist) {
        this.row+= dist;
        this.col+= dist;

    }

    @Override
    public Animal reproduce() {
        return new Zebra(this.row, this.col);
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Zebra{" +
                "row= " + row +
                ", col= " + col +
                '}';
    }
}
