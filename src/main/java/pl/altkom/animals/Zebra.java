package pl.altkom.animals;

import java.util.Objects;

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

    @Override
    public Animal reproduce() {
        return new Zebra(this.row, this.col);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zebra)) return false;
        Zebra zebra = (Zebra) o;
        return getRow() == zebra.getRow() &&
                getCol() == zebra.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }
}
