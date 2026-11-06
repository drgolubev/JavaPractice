package pr4.atelier;

/** Пункт 3: галстук — только мужская одежда (реализует только MenClothing). */
public class Tie extends Clothes implements MenClothing {

    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Галстук";
    }

    @Override
    public void dressMan() {
        System.out.println("Мужской   " + getInfo());
    }
}
