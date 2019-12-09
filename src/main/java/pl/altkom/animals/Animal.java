package pl.altkom.animals;

public interface Animal {
    public int getRow();
    public int getCol();
    void setRow(int row);
    void setCol(int col);
    void walk(int dist);
    public Animal reproduce();
}
