package pr4.shop;

import java.util.ArrayList;
import java.util.List;

/*
 * Перечисление товаров магазина. Каждый товар хранит название, цену и каталог,
 * к которому он относится (поле типа другого enum — Category).
 * Ассортимент фиксированный, поэтому enum здесь удобен: товары — это константы.
 */
public enum Product {
    SMARTPHONE("Смартфон", 25000, Category.ELECTRONICS),
    HEADPHONES("Наушники", 4500, Category.ELECTRONICS),
    LAPTOP("Ноутбук", 75000, Category.ELECTRONICS),
    JAVA_BOOK("Книга «Java для начинающих»", 1200, Category.BOOKS),
    NOVEL("Роман «Мастер и Маргарита»", 600, Category.BOOKS),
    HOODIE("Худи", 3200, Category.CLOTHES),
    JEANS("Джинсы", 4000, Category.CLOTHES);

    private final String title;
    private final double price;
    private final Category category;

    Product(String title, double price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    /** Все товары указанного каталога (перебираем values() и фильтруем по категории). */
    public static List<Product> byCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product p : values()) {
            if (p.category == category) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-28s %8.0f руб.", title, price);
    }
}
