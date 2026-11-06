package pr3.movable;

/*
 * Тест для задания 2: MovablePoint, MovableCircle, MovableRectangle.
 * Все три объекта храним в переменных типа Movable — это снова полиморфизм:
 * вызываем moveRight() у «чего-то перемещаемого», а Java сама выбирает нужную реализацию.
 */
public class TestMovable {

    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10, 15);
        System.out.println("Точка:            " + m1);
        m1.moveLeft();   // x = 5 - 10 = -5
        System.out.println("  после moveLeft: " + m1);
        m1.moveUp();     // y = 6 + 15 = 21
        System.out.println("  после moveUp:   " + m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
        System.out.println("\nКруг:              " + m2);
        m2.moveRight();  // центр x = 1 + 3 = 4
        System.out.println("  после moveRight: " + m2);
        m2.moveDown();   // центр y = 2 - 4 = -2
        System.out.println("  после moveDown:  " + m2);

        MovableRectangle rect = new MovableRectangle(0, 10, 20, 0, 2, 3);
        System.out.println("\nПрямоугольник:     " + rect);
        System.out.println("  одинаковая скорость у точек? " + rect.hasSameSpeed());
        rect.moveRight();
        rect.moveUp();
        System.out.println("  после moveRight и moveUp: " + rect);

        // Массив интерфейсного типа: двигаем всё сразу одной строкой в цикле
        System.out.println("\nДвигаем всё вниз одним циклом:");
        Movable[] all = {m1, m2, rect};
        for (Movable m : all) {
            m.moveDown();
            System.out.println("  " + m);
        }
    }
}
