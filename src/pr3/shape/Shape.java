package pr3.shape;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №3, Задание 1. Абстрактный суперкласс Shape (фигура).
 *
 * UML:
 *   <<abstract>> Shape
 *   #color: String          ("#" = protected: виден в подклассах и в классах того же пакета)
 *   #filled: boolean
 *   +Shape()
 *   +Shape(color: String, filled: boolean)
 *   +getColor(): String, +setColor(color: String): void
 *   +isFilled(): boolean, +setFilled(filled: boolean): void
 *   +getArea(): double        (курсив на диаграмме = abstract)
 *   +getPerimeter(): double   (abstract)
 *   +toString(): String
 *
 * ЗАЧЕМ АБСТРАКТНЫЙ КЛАСС:
 *   "Просто фигура" не имеет площади — площадь есть только у конкретного круга или прямоугольника.
 *   Поэтому getArea() и getPerimeter() объявлены без тела (abstract), а каждый подкласс
 *   обязан их реализовать по-своему. Создать объект абстрактного класса (new Shape()) НЕЛЬЗЯ.
 */
public abstract class Shape {

    protected String color;
    protected boolean filled;

    /** Конструктор по умолчанию: красная закрашенная фигура. */
    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /** Для boolean-полей геттер по соглашению называется isXxx(), а не getXxx(). */
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Абстрактный метод: только объявление, без тела. Реализация — в подклассах. */
    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}
