package pr3.movable;

/*
 * MovableCircle — движущийся круг. Реализует Movable.
 *
 * UML:
 *   -radius: int
 *   -center: MovablePoint     (ромбик на диаграмме = агрегация: круг СОДЕРЖИТ точку-центр)
 *   +MovableCircle(x, y, xSpeed, ySpeed, radius)
 *   +toString(), +moveUp(), +moveDown(), +moveLeft(), +moveRight()
 *
 * Идея: круг не двигает себя сам — он просит двигаться свой центр
 * (делегирование: center.moveUp() и т.д.). Радиус при движении не меняется.
 */
public class MovableCircle implements Movable {

    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "MovableCircle[центр=" + center + ", радиус=" + radius + "]";
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
}
