package pr41.t9furniture;

/** Диван. Своё поле — раскладывается ли он в кровать. */
public class Sofa extends Furniture {

    private final boolean foldable;

    public Sofa(String material, double price, boolean foldable) {
        super(foldable ? "Диван-кровать" : "Диван", material, price);
        this.foldable = foldable;
    }

    @Override
    public String getPurpose() {
        return foldable ? "чтобы сидеть и спать" : "чтобы сидеть";
    }
}
