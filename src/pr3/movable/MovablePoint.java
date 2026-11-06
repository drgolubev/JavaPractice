package pr3.movable;

/*
 * MovablePoint — точка, которая умеет двигаться. Реализует интерфейс Movable.
 *
 * UML:
 *   ~x: int, ~y: int, ~xSpeed: int, ~ySpeed: int
 *   ("~" = доступ по умолчанию, package-private: без модификатора, видно внутри пакета)
 *   +MovablePoint(x, y, xSpeed, ySpeed)
 *   +toString(), +moveUp(), +moveDown(), +moveLeft(), +moveRight()
 *
 * Система координат: ось Y направлена вверх (как в математике),
 * поэтому moveUp() увеличивает y, а moveDown() уменьшает.
 */
public class MovablePoint implements Movable {

    int x;
    int y;
    int xSpeed; // на сколько сдвигается по X за один шаг
    int ySpeed; // на сколько сдвигается по Y за один шаг

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ") скорость=(" + xSpeed + "," + ySpeed + ")";
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }
}
