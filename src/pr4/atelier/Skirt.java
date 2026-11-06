package pr4.atelier;

/** Пункт 3: юбка — только женская одежда (реализует только WomenClothing). */
public class Skirt extends Clothes implements WomenClothing {

    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Юбка";
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская   " + getInfo());
    }
}
