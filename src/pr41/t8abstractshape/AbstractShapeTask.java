package pr41.t8abstractshape;

import pr3.shape.Circle;
import pr3.shape.Rectangle;
import pr3.shape.Shape;
import pr3.shape.Square;

/*
 * ПР4.1, Задание 8 (абстрактные классы) и «Упражнение 1».
 *
 * Это ТО ЖЕ САМОЕ задание, что Задание 1 из ПР3: переписать Shape абстрактным,
 * подклассы Circle, Rectangle, Square по UML-диаграмме 4.1.1.
 * Готовые классы лежат в пакете pr3.shape, а полный разбор upcast/downcast
 * и всех ошибок компиляции — в pr3.shape.TestShape.
 *
 * Здесь мы просто импортируем эти классы из другого пакета и коротко их проверяем.
 * Импорт (import pr3.shape.Circle) позволяет использовать public-класс из другого пакета.
 */
public class AbstractShapeTask {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(2.0, "blue", true),
                new Rectangle(3.0, 4.0),
                new Square(5.0, "green", false)
        };

        for (Shape s : shapes) {
            System.out.println(s);
            System.out.printf("  площадь = %.2f, периметр = %.2f%n", s.getArea(), s.getPerimeter());
        }

        // new Shape();  // ошибка компиляции: Shape абстрактный (см. pr3.shape.TestShape)

        System.out.println("\nПолный разбор «Упражнения 1» — запуск pr3.shape.TestShape:\n");
        pr3.shape.TestShape.main(args);
    }
}
