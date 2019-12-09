package pl.altkom;

import pl.altkom.animals.Animal;
import pl.altkom.animals.Giraffe;
import pl.altkom.animals.Lion;
import pl.altkom.animals.Zebra;
import pl.altkom.plants.Acacia;
import pl.altkom.plants.Grass;

import java.util.*;
import java.util.stream.Collectors;

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
        this.cells = new LinkedHashSet<>();
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
                    if(cell.getRow()==r && cell.getCol()==c){
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

        //dodajemy losowe zwierzęta do Sawanny
            for(int i =0; i< animals;i++){
                int r = random.nextInt(3);
            if(r==0){
                this.animals.add(new Zebra(random.nextInt(rows),random.nextInt(cols)));
            }else if(r==1){
                this.animals.add(new Giraffe(random.nextInt(rows),random.nextInt(cols)));
            }else if(r==2){
                this.animals.add(new Lion(random.nextInt(rows),random.nextInt(cols)));
            }
        }

    }

    //metoda symulująca upływ dnia, jednoczesny wzrost roślin, poruszanie się zwierząt
    public void oneDay() {
        cells.forEach(cell->cell.getPlant().grow());
        animals.forEach(a->{
            a.walk(random.nextInt(2));
            if(a.getRow()>=this.rows){
                a.setRow(this.rows-1);
            }else if (a.getRow()<0){
                a.setRow(0);
            }
            if(a.getCol()>=this.cols){
                a.setCol(this.cols-1);
            }else if (a.getCol()<0){
                a.setCol(0);
            }
        });
    }
    //metoda symulująca żerowaie zwierząt roślinożernych
    public void toFeed() {
        for (Animal animal : animals) {
            for (Cell cell : cells) {
                if (animal.getRow() == cell.getRow() && animal.getCol() == cell.getCol()) {
                    if (animal.getClass().getSimpleName().equalsIgnoreCase("Zebra")
                            & cell.getPlant().getClass().getSimpleName().equalsIgnoreCase("Grass")) {
                        cell.getPlant().beEaten();
                        cell.getPlant().setPlantSize0();
                    } else if (animal.getClass().getSimpleName().equalsIgnoreCase("Giraffe")
                            & cell.getPlant().getClass().getSimpleName().equalsIgnoreCase("Acacia")) {
                        cell.getPlant().beEaten();
                        cell.getPlant().setPlantSize0();
                    }
                }
            }
        }
    }

    //metoda symulujaca rozmnażanie się zwierząt (jak na razie animale są obojnakami)
    public void toBreed(){
        animals.stream()
                .filter(i -> Collections.frequency(animals, i) >1)
                .collect(Collectors.toSet())
                .forEach(animal -> animals.add(animal.reproduce()));
    }

    //metoda symulująca polowanie na zwierzęta roślinożerne
    public void toHunt() {
        Set<Animal> lionSet = animals.stream()
                .filter(animal -> animal.getClass().getSimpleName().equalsIgnoreCase("Lion"))
                .collect(Collectors.toSet());
        for (Animal lion:lionSet) {
            animals.removeIf(animal -> !animal.getClass().getSimpleName().equalsIgnoreCase("Lion")
                    && lion.getCol()==animal.getCol()
                    && lion.getRow()==animal.getRow());
            }
        }

    public Set<Cell> getCells() {
        return cells;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}

