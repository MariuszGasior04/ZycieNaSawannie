package pl.altkom;

import pl.altkom.animals.Animal;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Savanna savanna = new Savanna(3,3,9,3);
        List<Animal> zwierzeta = savanna.getAnimals();
        Set<Cell> cells = savanna.getCells();
        for(Cell cell: cells){
            System.out.println(cell.getPlant().getClass().getSimpleName());
            System.out.println(cell.getPlant().getClass().getSimpleName().equalsIgnoreCase("Grass"));
        }

    }
}
