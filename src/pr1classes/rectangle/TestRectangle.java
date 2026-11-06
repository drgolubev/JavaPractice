package pr1classes.rectangle;

/*
 * Клиент класса Rectangle — программа, которая создаёт два прямоугольника
 * (4 x 40 и 3.5 x 35.9) и выводит ширину, высоту, площадь и периметр каждого
 * в указанном порядке.
 */
public class TestRectangle {

    public static void main(String[] args) {
        // Оператор new вызывает конструктор и создаёт объект в памяти
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        printInfo("Прямоугольник 1", r1);
        printInfo("Прямоугольник 2", r2);

        // Для наглядности — объект, созданный безаргументным конструктором
        printInfo("Прямоугольник по умолчанию", new Rectangle());
    }

    /** Вспомогательный метод, чтобы не повторять один и тот же вывод. */
    static void printInfo(String title, Rectangle r) {
        System.out.println(title + ":");
        System.out.println("  ширина   = " + r.width);
        System.out.println("  высота   = " + r.height);
        System.out.printf("  площадь  = %.2f%n", r.getArea());
        System.out.printf("  периметр = %.2f%n", r.getPerimeter());
    }
}
