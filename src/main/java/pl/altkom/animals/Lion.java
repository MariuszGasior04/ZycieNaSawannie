package pl.altkom.animals;

import java.util.Objects;

public class Lion implements Animal {
    private int row;
    private int col;

    public Lion(int row, int col) {
        this.row = row;
        this.col = col;
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
        return new Lion(this.row,this.col);
    }

    @Override
    public String toString() {
        return "Li{"+row +"-"+ col +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lion)) return false;
        Lion lion = (Lion) o;
        return getRow() == lion.getRow() &&
                getCol() == lion.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }
}
