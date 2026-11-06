package pr4.atelier;

/** Пункт 3: штаны — реализуют оба интерфейса (MenClothing и WomenClothing). */
public class Pants extends Clothes implements MenClothing, WomenClothing {

    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Штаны";
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские   " + getInfo());
    }

    @Override
    public void dressWomen() {
        System.out.println("Женские   " + getInfo());
    }
}
