package pr41.t1shape;

/*
 * Класс-тестер для задания 1. Все фигуры хранятся в переменных РОДИТЕЛЬСКОГО типа Shape.
 *
 * ОБЪЯСНЕНИЕ РАБОТЫ ПРОГРАММЫ:
 *   Переменная s имеет тип Shape, но в ней лежат объекты Circle, Rectangle, Square.
 *   Когда мы вызываем s.getArea(), Java во время выполнения смотрит, какой объект
 *   НА САМОМ ДЕЛЕ лежит в переменной, и вызывает метод именно его класса.
 *   Это называется полиморфизм (динамическое связывание).
 *   Для объекта new Shape() вызываются методы самого Shape (площадь 0).
 *   Square не переопределял getArea() — поэтому для него работает версия из Rectangle.
 */
public class ShapeTester {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Shape(),
                new Circle(3),
                new Rectangle(4, 5),
                new Square(6)
        };

        for (Shape s : shapes) { // родительская ссылка s
            System.out.println("Объект:   " + s);            // toString() нужного класса
            System.out.println("  тип:      " + s.getType());
            System.out.printf("  площадь:  %.2f%n", s.getArea());
            System.out.printf("  периметр: %.2f%n", s.getPerimeter());
        }
    }
}
