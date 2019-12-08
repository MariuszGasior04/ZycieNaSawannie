package pl.altkom.plants;

public abstract class Tree implements Plant {
    int height;
    int branches;

    @Override
    public void grow() {
        height += 1;
        if(height<5){
            branches++;
        }else {
            branches+=2;
        }
    }

    public void plantSize() {
        System.out.print("T"+branches);
    }

    @Override
    public void beEaten() {
        branches--;
    }

    public void setPlantSize0() {
        if(this.branches<0){
            this.branches = 0;}
    }
}
