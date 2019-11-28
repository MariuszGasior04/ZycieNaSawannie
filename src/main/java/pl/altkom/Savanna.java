package pl.altkom;

import pl.altkom.animals.Animal;
import pl.altkom.animals.Giraffe;
import pl.altkom.animals.Zebra;
import pl.altkom.plants.Acacia;
import pl.altkom.plants.Grass;

import java.util.*;
import java.util.function.UnaryOperator;

public class Savanna {
    private Set<Cell> cells;
    private List<Animal> animals;
    private int rows;
    private int cols;
    Random random = new Random();

    //konstruktor sawanny
    public Savanna(int rows, int cols, int trees, int animals) {
        this.rows = rows;
        this.cols = cols;
        this.animals = new ArrayList<>();
        this.cells = new HashSet<Cell>();
        Random random = new Random();

        //tworzymy pustą plansze
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                cells.add(new Cell(r,c));
            }
        }

        //zapełniamy planszę drzwami
        for (int i = 0; i < trees; i++) {
            int r, c;
                r = random.nextInt(rows);
                c = random.nextInt(cols);
                for(Cell cell: cells){
                    if(cell.getRow()==r && cell.getColumn()==c){
                        cell.withTree(new Acacia());
                    }
                }
        }

        //pozostałe pola zapełniamy trawą
        for(Cell cell:cells){
            if(cell.getPlant()==null){
                cell.withGrass(new Grass());
            }
        }

        //dodajemy zwierzęta do Sawanny
        for(int i =0; i< animals;i++){
            this.animals.add(new Zebra(random.nextInt(rows),random.nextInt(cols)));
        }

    }

    //metoda symulująca upływ dnia, jednoczesny wzrost roślin, poruszanie się zwierząt
    public void oneDay() {

        cells.forEach(cell->cell.getPlant().grow());

        animals.forEach(n->{
            n.walk(random.nextInt(3));
            if(n.getRow()>this.rows){
                n.setRow(this.rows);
            }else if (n.getRow()<0){
                n.setRow(0);
            }
            if(n.getCol()>this.cols){
                n.setCol(this.cols);
            }else if (n.getCol()<0){
                n.setCol(0);
            }
        });
    }


    private void forEach(UnaryOperator<Cell> f) {

    }

    public Set<Cell> getCells() {
        return cells;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}

