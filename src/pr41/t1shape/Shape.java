package pr41.t1shape;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №4.1, Задание 1. Простейший (НЕ абстрактный) класс Shape.
 *
 * Здесь Shape — обычный класс, его объект создать можно (new Shape()).
 * Методы getArea()/getPerimeter() у «просто фигуры» возвращают 0 —
 * осмысленные значения дают дочерние классы, переопределяя эти методы.
 * (В задании 8 этот же класс будет переписан как абстрактный — см. пакет pr3.shape.)
 */
public class Shape {

    /** Тип фигуры (название). */
    public String getType() {
        return "Фигура";
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return getType(); // вызовется getType() ДОЧЕРНЕГО класса, если он переопределён (полиморфизм)
    }
}
