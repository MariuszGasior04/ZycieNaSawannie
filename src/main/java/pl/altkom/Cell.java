package pl.altkom;

import pl.altkom.plants.Grass;
import pl.altkom.plants.Plant;
import pl.altkom.plants.Tree;

import java.util.Objects;

public class Cell {
    private Plant plant;
    private int row;
    private int column;

    public Cell(Plant plant, int row, int column) {
        this.plant = plant;
        this.row = row;
        this.column = column;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Plant getPlant() {
        return plant;
    }

    public void withGrass(Grass grass) {
        this.plant = grass;
    }

    public void withTree(Tree tree) {
        this.plant = tree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return row == cell.row &&
                column == cell.column &&
                Objects.equals(getPlant(), cell.getPlant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlant(), row, column);
    }
}
