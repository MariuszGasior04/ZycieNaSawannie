package pl.altkom;

import pl.altkom.plants.Grass;

import java.util.Random;
import java.util.function.UnaryOperator;

public class Savanna {
    private Cell[][] cells;
    private int rows;
    private int cols;

    public Savanna(int rows, int cols, int trees) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        Random random = new Random();
        random.nextInt(trees);
        for (int i = 0; i < trees; i++) {
            int r, c;
            do {
                r = random.nextInt(rows);
                c = random.nextInt(cols);
            } while (cells[r][c] != null);
        }
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (cells[r][c] == null) {
                    cells[r][c] = Cell.withGrass(new Grass());
                }
            }
        }
    }

    public void oneDay() {
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                cells[r][c].getPlant().grow();
            }

        }
    }
    //zastąpić pętle for for metodą forEach
    private void forEach(UnaryOperator<Cell>f){

    }
}