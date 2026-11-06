package pr4.atelier;

/*
 * Пункт 4: класс Atelier (ателье) с методами dressWomen и dressMan.
 *
 * «Подумайте, какой тип будет у массива» — ОТВЕТ: Clothes[].
 * Все виды одежды — наследники Clothes, поэтому их можно сложить в один массив Clothes[].
 * (Массив MenClothing[] не подошёл бы — туда не положить юбку; WomenClothing[] — галстук.)
 *
 * Внутри методов проверяем через instanceof, реализует ли вещь нужный интерфейс,
 * и если да — приводим тип и вызываем dressWomen()/dressMan() самой вещи.
 * Какая именно версия выполнится (футболки, юбки...) — решает полиморфизм.
 */
public class Atelier {

    /** Выводит на консоль информацию обо всей ЖЕНСКОЙ одежде из массива. */
    public void dressWomen(Clothes[] clothes) {
        System.out.println("=== Одеваем женщину ===");
        for (Clothes c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWomen(); // приведение типа к интерфейсу
            }
        }
    }

    /** Выводит на консоль информацию обо всей МУЖСКОЙ одежде из массива. */
    public void dressMan(Clothes[] clothes) {
        System.out.println("=== Одеваем мужчину ===");
        for (Clothes c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }

    public static void main(String[] args) {
        // Массив, содержащий все типы одежды
        Clothes[] clothes = {
                new TShirt(Size.M, 1500, "белый"),
                new Pants(Size.L, 3500, "синий"),
                new Skirt(Size.XS, 2800, "красный"),
                new Tie(Size.S, 1200, "чёрный"),
                new TShirt(Size.XXS, 900, "жёлтый") // детский размер — проверка getDescription для XXS
        };

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        System.out.println();
        atelier.dressMan(clothes);
    }
}
