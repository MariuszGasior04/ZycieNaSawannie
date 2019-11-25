package pl.altkom;

import pl.altkom.plants.Acacia;
import pl.altkom.plants.Grass;

import java.util.Random;
import java.util.function.UnaryOperator;

public class Savanna {
    private Cell[][] cells;
    private int rows;
    private int cols;

    //konstruktor sawanny
    public Savanna(int rows, int cols, int trees) {
        this.rows = rows;
        this.cols = cols;
        Random random = new Random();
        cells = new Cell[rows][cols];
        //zapełniamy planszę drzwami
        for (int i = 0; i < trees; i++) {
            int r, c;
            do {
                r = random.nextInt(rows);
                c = random.nextInt(cols);
            } while (cells[r][c] != null);
            cells[r][c] = Cell.withTree(new Acacia());
        }
        //pozostałe pola zapełniamy trawą
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (cells[r][c] == null) {
                    cells[r][c] = Cell.withGrass(new Grass());
                }
            }
        }
    }
    //metoda symulująca upływ dnia i jednoczesny wzrost roślin
    public void oneDay() {
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++){
                cells[r][c].getPlant().grow();
            }
        }
    }

    private void forEach(UnaryOperator<Cell> f) {

    }


}

