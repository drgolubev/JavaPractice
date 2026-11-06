package pr41.t9furniture;

/*
 * ПР4.1, Задание 9. Абстрактный класс «Мебель».
 * Общие поля: название, материал, цена. Абстрактный метод getPurpose() —
 * у каждого вида мебели своё назначение, поэтому реализуют его подклассы.
 */
public abstract class Furniture {

    protected String name;
    protected String material;
    protected double price;

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    /** Для чего эта мебель. */
    public abstract String getPurpose();

    @Override
    public String toString() {
        return String.format("%-22s | %-8s | %8.0f руб. | %s", name, material, price, getPurpose());
    }
}
