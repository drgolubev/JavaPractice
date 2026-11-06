package pr3.shape;

/*
 * Circle (круг) — подкласс Shape.
 * extends Shape = "круг является фигурой": наследует color, filled и их геттеры/сеттеры.
 * Обязан реализовать абстрактные getArea() и getPerimeter(), иначе сам станет абстрактным.
 */
public class Circle extends Shape {

    protected double radius;

    public Circle() {
        super();          // вызов конструктора родителя Shape() → color="red", filled=true
        this.radius = 1.0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // передаём цвет и заливку в конструктор родителя
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Площадь круга: π * r². */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /** Длина окружности: 2 * π * r. */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /** super.toString() — вызываем версию toString() родителя и дописываем своё. */
    @Override
    public String toString() {
        return "Circle[" + super.toString() + ", radius=" + radius + "]";
    }
}
