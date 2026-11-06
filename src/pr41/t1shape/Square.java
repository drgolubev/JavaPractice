package pr41.t1shape;

/*
 * Квадрат — наследник Rectangle (квадрат — частный случай прямоугольника).
 * Площадь и периметр берутся от Rectangle; переопределяем только тип и toString.
 */
public class Square extends Rectangle {

    public Square(double side) {
        super(side, side); // super(...) — вызов конструктора родителя, должен быть первой строкой
    }

    @Override
    public String getType() {
        return "Квадрат";
    }

    @Override
    public String toString() {
        return getType() + " со стороной " + width;
    }
}
