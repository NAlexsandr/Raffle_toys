import java.util.Objects;

public class Toy {
    private String name;
    private int id;
    private double dropRate;
    //public static int inventar;
    //static {
    //    inventar++;
    //}

    public Toy(String name, int id, double dropRate) {
        this.name = name;
        this.id = id;
        this.dropRate = dropRate;
    }
    public Toy() {
        this.name = "0";
        this.id = 0;
        this.dropRate = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getDropRate() {
        return dropRate;
    }
    public void setDropRate(double dropRate) {
        this.dropRate = dropRate;
    }

}
