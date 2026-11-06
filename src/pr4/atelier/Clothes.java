package pr4.atelier;

/*
 * Пункт 2: абстрактный класс Clothes (одежда) с полями: размер, стоимость, цвет.
 * Абстрактный — потому что «просто одежды» не бывает, бывает футболка, штаны и т.д.
 * Метод getName() абстрактный: каждый подкласс сам говорит, как он называется.
 */
public abstract class Clothes {

    protected Size size;     // поле типа нашего enum
    protected double price;
    protected String color;

    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    /** Название вида одежды ("Футболка", "Штаны" ...). */
    public abstract String getName();

    /** Полная информация — используется в dressMan()/dressWomen() подклассов. */
    public String getInfo() {
        return String.format("%-8s | размер %-3s (EU %d, %s) | цвет: %-7s | цена: %.0f руб.",
                getName(), size, size.getEuroSize(), size.getDescription(), color, price);
    }
}
