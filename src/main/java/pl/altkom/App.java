package pl.altkom;


import pl.altkom.animals.Animal;
import java.util.List;


public class App
{
    public static void main( String[] args ) {
        Savanna savanna = new Savanna(10, 10, 20, 10,10,3);
        List<Animal> zwierzeta = savanna.getAnimals();

        for (int day = 1; day < 30; day++) {
            System.out.printf("Dzień %d",day);
            System.out.println();

            savanna.oneDay();
            //drukowanie stanu poszczegolnych komórek sawanny [row]-[col][plant][size] G-grass T-tree
            for (Cell cell : savanna.getCells()) {
                System.out.print(cell.getRow() + "-");
                System.out.print(cell.getCol());
                cell.getPlant().plantSize();
                System.out.print(" ");
            }
            System.out.println();

            //drukowanie stanu poszczegolnych zwierząt sawanny [Animal]{[row]-[col]} Zeb-zebra, Gir-giraffe, Li-Lion
            for (Animal animal : zwierzeta) {
                System.out.print(animal);
                System.out.print(", ");
            }
            System.out.printf("Na sawannie jest %d zwierząt",zwierzeta.size());
            System.out.println();

            //zwierzęta roślinożerne żerują
            savanna.toFeed();

            //zwierzęta mięsożerne polują co 7 dni
            if(day % 7==0){
                savanna.toHunt();
            }
            //zwierzęta rodzą się co 5
            if(day % 5==0){
                savanna.toBreed();
            }

        }
    }
}
