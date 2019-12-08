package pl.altkom;


import pl.altkom.animals.Animal;

import java.util.List;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        Savanna savanna = new Savanna(3,3,5,3);
        List<Animal> zwierzeta = savanna.getAnimals();


        System.out.println("Day1");
        savanna.oneDay();

        for(Cell cell:savanna.getCells()){
            System.out.print(cell.getRow()+"-");
            System.out.print(cell.getCol());
            cell.getPlant().plantSize();
            System.out.print(" ");
    }
        System.out.println();
        for (Animal animal: zwierzeta
        ) {
            System.out.print(animal);
            System.out.print(", ");
        }
        System.out.println();
        savanna.toFeed();

        for(Cell cell:savanna.getCells()){
            System.out.print(cell.getRow()+"-");
            System.out.print(cell.getCol());
            cell.getPlant().plantSize();
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Day2");
        savanna.oneDay();

        for(Cell cell:savanna.getCells()){
            System.out.print(cell.getRow()+"-");
            System.out.print(cell.getCol());
            cell.getPlant().plantSize();
            System.out.print(" ");
        }
        System.out.println();

        for (Animal animal: zwierzeta
        ) {
            System.out.print(animal);
            System.out.print(", ");
        }
        System.out.println();
        savanna.toFeed();

        for(Cell cell:savanna.getCells()){
            System.out.print(cell.getRow()+"-");
            System.out.print(cell.getCol());
            cell.getPlant().plantSize();
            System.out.print(" ");
        }
    }
}
