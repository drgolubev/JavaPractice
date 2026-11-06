package pr41.t9furniture;

import java.util.ArrayList;
import java.util.List;

/*
 * ПР4.1, Задание 9. FurnitureShop — магазин мебели.
 * Хранит список мебели (List<Furniture> — в нём могут лежать любые наследники Furniture),
 * умеет: принять товар, показать ассортимент, продать по названию, посчитать стоимость склада.
 */
public class FurnitureShop {

    private final String shopName;
    private final List<Furniture> stock = new ArrayList<>();
    private double revenue; // выручка

    public FurnitureShop(String shopName) {
        this.shopName = shopName;
    }

    public void addFurniture(Furniture f) {
        stock.add(f);
    }

    public void showAll() {
        System.out.println("Ассортимент магазина «" + shopName + "»:");
        for (int i = 0; i < stock.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + stock.get(i));
        }
        System.out.printf("Стоимость всего склада: %.0f руб.%n", getStockValue());
    }

    /** Продажа по названию: находим, убираем со склада, увеличиваем выручку. */
    public boolean sell(String name) {
        for (int i = 0; i < stock.size(); i++) {
            Furniture f = stock.get(i);
            if (f.getName().equals(name)) {
                stock.remove(i);
                revenue += f.getPrice();
                System.out.printf("Продано: %s за %.0f руб.%n", name, f.getPrice());
                return true;
            }
        }
        System.out.println("Товара «" + name + "» нет в наличии.");
        return false;
    }

    public double getStockValue() {
        double sum = 0;
        for (Furniture f : stock) sum += f.getPrice();
        return sum;
    }

    public double getRevenue() {
        return revenue;
    }

    /** Тестирование работы классов. */
    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop("Уютный дом");
        shop.addFurniture(new Chair("дерево", 3500, false));
        shop.addFurniture(new Chair("металл", 5200, true));
        shop.addFurniture(new Table("дуб", 18000, 6));
        shop.addFurniture(new Sofa("велюр", 42000, true));
        shop.addFurniture(new Wardrobe("ЛДСП", 27000, 3));

        shop.showAll();
        System.out.println();

        shop.sell("Диван-кровать");
        shop.sell("Стул");
        shop.sell("Кресло"); // такого нет
        System.out.printf("Выручка: %.0f руб.%n%n", shop.getRevenue());

        shop.showAll();

        // Furniture f = new Furniture("x", "y", 1); // ошибка компиляции: класс абстрактный
    }
}
