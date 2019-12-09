package pl.altkom;


import pl.altkom.animals.Animal;

import java.util.List;


public class App
{
    public static void main( String[] args )
    {
        Savanna savanna = new Savanna(4,4,5,6);
        List<Animal> zwierzeta = savanna.getAnimals();

        System.out.println("Day1 - dzień startowy");
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
        System.out.println("Day2 - pierwsze żerowanie");
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

        savanna.toBreed();

        System.out.println();
        System.out.println("Day3 - po rozmnażaniu");
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
        savanna.toHunt();
        System.out.println();
        System.out.println("Day4 - po polowaniu");
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
