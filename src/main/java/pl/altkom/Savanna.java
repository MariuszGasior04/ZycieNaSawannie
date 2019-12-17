package pl.altkom;

import pl.altkom.animals.Animal;
import pl.altkom.animals.Giraffe;
import pl.altkom.animals.Lion;
import pl.altkom.animals.Zebra;
import pl.altkom.plants.Acacia;
import pl.altkom.plants.Grass;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Savanna {
    private Set<Cell> cells;
    private List<Animal> animals;
    private int rows;
    private int cols;
    Random random = new Random();

    //konstruktor sawanny
    public Savanna(int rows, int cols, int trees, int zebras, int giraffes, int lions) {
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

        //dodajemy zwierzęta do Sawanny
        for(int i =0; i< zebras;i++){
            this.animals.add(new Zebra(random.nextInt(rows),random.nextInt(cols)));
            }
        for(int i =0; i< giraffes;i++){
            this.animals.add(new Giraffe(random.nextInt(rows),random.nextInt(cols)));
        }
        for(int i =0; i< lions;i++){
            this.animals.add(new Lion(random.nextInt(rows),random.nextInt(cols)));
        }
        }

    //metoda symulująca upływ dnia, jednoczesny wzrost roślin, poruszanie się zwierząt
    public void oneDay() {
        cells.forEach(cell->cell.getPlant().grow());
        animals.forEach(a->{
            a.walk(random.nextInt(3)-1);

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
                .forEach(animal -> {
                    animals.add(animal.reproduce());
                    System.out.println(animal.getClass().getSimpleName()+"+1");
                });
    }

    //Predykat wykorzystywany później w metodzie na polowanie.
    // Utworzony, aby przy zwracaniu wartości TRUE wyrzucał na ekran upolowane zwierze
    private class HuntPredicate implements Predicate{
        private Animal lion;

        public void setLion(Animal lion) {
            this.lion = lion;
        }

        @Override
        public boolean test(Object oAnimal) {
            Animal animal = (Animal) oAnimal;
            if(!animal.getClass().getSimpleName().equalsIgnoreCase("Lion")
                    && lion.getCol()==animal.getCol()
                    && lion.getRow()==animal.getRow()){
                System.out.println(animal.getClass().getSimpleName()+" eaten");
                return true;
            }
            return false;
        }
    }
    HuntPredicate huntPredicate = new HuntPredicate();

    //metoda symulująca polowanie na zwierzęta roślinożerne
    public void toHunt() {
        Set<Animal> lionSet = animals.stream()
                .filter(animal -> animal.getClass().getSimpleName().equalsIgnoreCase("Lion"))
                .collect(Collectors.toSet());
        for (Animal lion:lionSet) {
            huntPredicate.setLion(lion); //setLion w lionSet'ie
            animals.removeIf(huntPredicate);
            }
        }

    public Set<Cell> getCells() {
        return cells;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}

