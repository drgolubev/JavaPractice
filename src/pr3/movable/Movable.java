package pr3.movable;

/*
 * ПР3, Задание 2. Интерфейс Movable («перемещаемый»).
 *
 * Интерфейс — это «контракт»: список методов без реализации.
 * Любой класс, который пишет "implements Movable", ОБЯЗАН реализовать все четыре метода.
 * На UML-диаграмме реализация интерфейса рисуется пунктирной стрелкой с треугольником.
 * Все методы интерфейса по умолчанию public и abstract.
 */
public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
