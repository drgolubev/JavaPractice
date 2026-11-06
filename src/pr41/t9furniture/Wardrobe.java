package pr41.t9furniture;

/** Шкаф. Своё поле — количество дверей. */
public class Wardrobe extends Furniture {

    private final int doors;

    public Wardrobe(String material, double price, int doors) {
        super("Шкаф " + doors + "-дверный", material, price);
        this.doors = doors;
    }

    public int getDoors() { return doors; }

    @Override
    public String getPurpose() {
        return "чтобы хранить вещи";
    }
}
