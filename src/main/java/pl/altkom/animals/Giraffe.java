package pl.altkom.animals;

import java.util.Objects;

public class Giraffe implements Animal {
    private int row;
    private int col;


    public Giraffe(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Giraffe)) return false;
        Giraffe giraffe = (Giraffe) o;
        return getRow() == giraffe.getRow() &&
                getCol() == giraffe.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
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
    public void walk(int dist) {
        this.row+= dist;
        this.col+= dist;
    }

    @Override
    public Animal reproduce() {
        return new Giraffe(this.row, this.col);
    }

    @Override
    public String toString() {
        return "Gir{"+row +"-"+ col +
                '}';
    }
}
