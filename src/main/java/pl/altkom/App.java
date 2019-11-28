package pl.altkom;


import pl.altkom.animals.Animal;

import java.util.List;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        Savanna savanna = new Savanna(10,10,10,2);
       Set<Cell> plansza =  savanna.getCells();
       List<Animal> zwierzeta = savanna.getAnimals();

        for (Animal animal: zwierzeta
             ) {
            System.out.println(animal);
        }
        System.out.println("Day1");
        savanna.oneDay();

    }
}
