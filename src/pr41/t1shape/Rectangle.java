package pr41.t1shape;

/** Прямоугольник — дочерний класс Shape. */
public class Rectangle extends Shape {

    // protected — чтобы наследник Square тоже видел эти поля
    protected double width;
    protected double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public String getType() {
        return "Прямоугольник";
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return getType() + " " + width + " x " + length;
    }
}
