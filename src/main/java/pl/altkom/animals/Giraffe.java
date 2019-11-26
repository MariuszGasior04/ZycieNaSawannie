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
    public void walk() {
        this.row+= (rand.nextInt(3))-1;
        this.col+= (rand.nextInt(3))-1;
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
