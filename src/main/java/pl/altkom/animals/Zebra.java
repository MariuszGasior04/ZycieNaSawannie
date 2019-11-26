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
    public void walk() {
        this.row+= rand.nextInt(3)-rand.nextInt(3);
        this.col+= rand.nextInt(3)-rand.nextInt(3);
    }

    @Override
    public Animal reproduce() {
        return new Zebra(this.row, this.col);
    }
}
