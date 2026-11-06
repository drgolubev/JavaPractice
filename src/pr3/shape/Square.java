package pr3.shape;

/*
 * Square (квадрат) — подкласс Rectangle (квадрат — это прямоугольник, у которого width == length).
 * Своих полей нет: сторона хранится в унаследованных width и length.
 *
 * getArea() и getPerimeter() переопределять не нужно — формулы прямоугольника подходят.
 * Зато setWidth() и setLength() переопределены: если поменять только ширину,
 * квадрат перестал бы быть квадратом, поэтому меняем обе стороны сразу.
 */
public class Square extends Rectangle {

    public Square() {
        super(1.0, 1.0); // вызываем конструктор Rectangle(width, length)
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return width; // width == length, можно вернуть любое
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}
