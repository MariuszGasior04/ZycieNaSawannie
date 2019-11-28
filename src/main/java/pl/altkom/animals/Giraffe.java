package pl.altkom.animals;
import java.util.Random;

public class Giraffe implements Herbivore {
    private int row;
    private int col;
    private Random rand = new Random();

    public Giraffe(int row, int col){
        this.row = row;
        this.col = col;
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
    public void walk(int dist) {
        this.row+= dist;
        this.col+= dist;
    }

    @Override
    public Animal reproduce() {
        return new Giraffe(this.row,this.col);
    }


    @Override
    public void beEaten() {
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
