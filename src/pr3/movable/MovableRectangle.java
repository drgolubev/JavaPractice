package pr3.movable;

/*
 * ПР3, Задание 2, пункт 2). MovableRectangle — движущийся прямоугольник.
 *
 * UML:
 *   -topLeft: MovablePoint       (верхняя левая точка)
 *   -bottomRight: MovablePoint   (нижняя правая точка)
 *   +MovableRectangle(x1, y1, x2, y2, xSpeed, ySpeed)
 *   +toString(), +moveUp(), +moveDown(), +moveLeft(), +moveRight()
 *
 * Прямоугольник = две движущиеся точки. Чтобы при движении прямоугольник не «растягивался»,
 * у обеих точек должна быть ОДИНАКОВАЯ скорость. Конструктор задаёт им одну скорость,
 * а метод hasSameSpeed() это проверяет (требование задания).
 */
public class MovableRectangle implements Movable {

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        // обе точки получают одни и те же xSpeed и ySpeed
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    /** Проверка: у двух точек одинаковая скорость по X и по Y. */
    public boolean hasSameSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public String toString() {
        return "MovableRectangle[верх-лево=" + topLeft + ", низ-право=" + bottomRight + "]";
    }

    // Двигаем обе точки одинаково — прямоугольник перемещается целиком, не меняя размеров

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }
}
