package pr4.atelier;

/*
 * Пункт 3: футболка — наследник Clothes, реализует ОБА интерфейса
 * (её носят и мужчины, и женщины). Класс может реализовать сколько угодно интерфейсов
 * через запятую, но наследоваться (extends) только от одного класса.
 */
public class TShirt extends Clothes implements MenClothing, WomenClothing {

    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Футболка";
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская   " + getInfo());
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская   " + getInfo());
    }
}
