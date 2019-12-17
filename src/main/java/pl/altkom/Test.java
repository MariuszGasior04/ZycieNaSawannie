package pl.altkom;

import pl.altkom.animals.Animal;
import java.util.List;
import java.util.Set;


public class Test {
    public static void main(String[] args) {
        Savanna savanna = new Savanna(3,3,9,10, 4, 3);
        List<Animal> zwierzeta = savanna.getAnimals();
        Set<Cell> cells = savanna.getCells();
        for (Animal animal:zwierzeta) {
            System.out.print(animal+" ");
        }
        System.out.println();

        savanna.toHunt();

        for (Animal animal:zwierzeta) {
            System.out.print(animal+" ");
        }
    }
}
