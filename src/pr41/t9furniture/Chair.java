package pr41.t9furniture;

/** Стул. Своё поле — есть ли подлокотники. */
public class Chair extends Furniture {

    private final boolean hasArmrests;

    public Chair(String material, double price, boolean hasArmrests) {
        super(hasArmrests ? "Стул с подлокотниками" : "Стул", material, price);
        this.hasArmrests = hasArmrests;
    }

    public boolean hasArmrests() { return hasArmrests; }

    @Override
    public String getPurpose() {
        return "чтобы сидеть";
    }
}
