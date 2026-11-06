package pr3.shape;

/*
 * ПР3, Задание 1 — тестовый класс (он же «Упражнение 1» из ПР4.1).
 * Код из методички, строки с ошибками компиляции ЗАКОММЕНТИРОВАНЫ и объяснены.
 *
 * ================== ГЛАВНОЕ ПРО ПОЛИМОРФИЗМ ==================
 * Upcast (восходящее преобразование):  Shape s1 = new Circle(...)
 *   Переменная имеет тип Shape, а объект на самом деле — Circle. Это разрешено всегда,
 *   потому что круг ЯВЛЯЕТСЯ фигурой.
 *
 * Два правила, которые объясняют все результаты ниже:
 *   1) КАКИЕ методы можно вызвать — решает КОМПИЛЯТОР по типу ПЕРЕМЕННОЙ (Shape).
 *      У Shape нет getRadius(), поэтому s1.getRadius() — ошибка компиляции,
 *      хотя у самого объекта такой метод есть.
 *   2) КАКАЯ ВЕРСИЯ метода выполнится — решается ВО ВРЕМЯ РАБОТЫ по типу ОБЪЕКТА (Circle).
 *      Поэтому s1.toString(), s1.getArea(), s1.getPerimeter() вызывают версии из Circle.
 *      Это и есть полиморфизм (позднее / динамическое связывание).
 *
 * Downcast (нисходящее преобразование):  Circle c1 = (Circle) s1;
 *   Нужно явное приведение в скобках. После него переменная c1 имеет тип Circle,
 *   и становятся доступны методы круга (getRadius()). Если бы объект на самом деле
 *   не был кругом, программа упала бы во время выполнения с ClassCastException.
 * ==============================================================
 */
public class TestShape {

    public static void main(String[] args) {

        System.out.println("===== Circle через ссылку Shape (upcast) =====");
        Shape s1 = new Circle(5.5, "RED", false);     // Upcast Circle → Shape
        System.out.println(s1);                       // which version? → Circle.toString() (полиморфизм)
        System.out.println(s1.getArea());             // which version? → Circle.getArea()
        System.out.println(s1.getPerimeter());        // which version? → Circle.getPerimeter()
        System.out.println(s1.getColor());            // метод унаследован от Shape → RED
        System.out.println(s1.isFilled());            // метод унаследован от Shape → false
        // System.out.println(s1.getRadius());
        //   ОШИБКА КОМПИЛЯЦИИ: cannot find symbol getRadius().
        //   Переменная s1 имеет тип Shape, а в классе Shape метода getRadius() нет.
        //   Исправление — сделать downcast к Circle (как ниже).

        System.out.println("\n===== Downcast обратно к Circle =====");
        Circle c1 = (Circle) s1;                      // Downcast back to Circle — объект и правда Circle, всё ок
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());           // теперь работает: тип переменной Circle → 5.5

        // Shape s2 = new Shape();
        //   ОШИБКА КОМПИЛЯЦИИ: Shape is abstract; cannot be instantiated.
        //   Нельзя создать объект абстрактного класса — у него есть нереализованные методы.

        System.out.println("\n===== Rectangle через ссылку Shape =====");
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3);                       // Rectangle.toString()
        System.out.println(s3.getArea());             // Rectangle.getArea() → 2.0
        System.out.println(s3.getPerimeter());        // Rectangle.getPerimeter() → 6.0
        System.out.println(s3.getColor());
        // System.out.println(s3.getLength());
        //   ОШИБКА КОМПИЛЯЦИИ: у типа Shape нет метода getLength().

        Rectangle r1 = (Rectangle) s3;                // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());           // теперь доступно → 2.0

        System.out.println("\n===== Square через ссылку Shape =====");
        Shape s4 = new Square(6.6);                   // Upcast
        System.out.println(s4);                       // Square.toString()
        System.out.println(s4.getArea());             // унаследованный Rectangle.getArea() → 6.6*6.6
        System.out.println(s4.getColor());            // "red" — цвет по умолчанию из Shape()
        // System.out.println(s4.getSide());
        //   ОШИБКА КОМПИЛЯЦИИ: у типа Shape нет метода getSide().

        // Обратите внимание: делаем downcast Shape s4 к Rectangle (суперклассу Square), а не к Square.
        // Это разрешено, потому что квадрат является прямоугольником.
        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);                       // всё равно Square.toString() — объект-то квадрат!
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        // System.out.println(r2.getSide());
        //   ОШИБКА КОМПИЛЯЦИИ: getSide() есть только в Square, а переменная r2 имеет тип Rectangle.
        System.out.println(r2.getLength());           // getLength() есть в Rectangle → 6.6

        System.out.println("\n===== Downcast Rectangle → Square =====");
        Square sq1 = (Square) r2;                     // объект действительно Square → ок
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());            // теперь доступно → 6.6
        System.out.println(sq1.getLength());          // унаследован от Rectangle → 6.6

        // Пример ошибки ВО ВРЕМЯ ВЫПОЛНЕНИЯ (а не компиляции):
        //   Circle bad = (Circle) s3;  // скомпилируется, но упадёт с ClassCastException,
        //                              // потому что s3 на самом деле Rectangle, а не Circle.
        // Безопасный способ — сначала проверить тип через instanceof:
        if (s3 instanceof Circle) {
            System.out.println("s3 — круг");
        } else {
            System.out.println("\ns3 не является Circle, поэтому downcast к Circle делать нельзя");
        }

        System.out.println("\n===== Полиморфизм в массиве =====");
        // В одном массиве типа Shape лежат разные фигуры; для каждой вызывается СВОЯ версия getArea()
        Shape[] shapes = {s1, s3, s4};
        for (Shape s : shapes) {
            System.out.printf("%-10s площадь = %.2f%n", s.getClass().getSimpleName(), s.getArea());
        }
    }
}
