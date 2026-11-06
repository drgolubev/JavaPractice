package pr41.t5library;

/*
 * Программа для задания 5: создаём массив объектов Reader и проверяем все перегрузки.
 */
public class LibraryDemo {

    public static void main(String[] args) {
        Reader[] readers = {
                new Reader("Петров В. В.", 1001, "ИТ", "12.03.2005", "+7 900 123-45-67"),
                new Reader("Иванов А. С.", 1002, "Экономика", "01.09.2004", "+7 900 765-43-21"),
                new Reader("Голубев Д. Р.", 1003, "ИТ", "20.05.2005", "+7 900 555-55-55")
        };

        System.out.println("Читатели библиотеки:");
        for (Reader r : readers) {
            System.out.println("  " + r);
        }
        System.out.println();

        Reader petrov = readers[0];

        // Версия с количеством
        petrov.takeBook(3);
        // Версия с названиями (String...)
        petrov.takeBook("Приключения", "Словарь", "Энциклопедия");
        // Версия с объектами Book (Book...)
        petrov.takeBook(new Book("Приключения", "Р. Стивенсон"),
                new Book("Словарь", "С. Ожегов"),
                new Book("Энциклопедия", "БРЭ"));

        petrov.returnBook(new Book("Приключения", "Р. Стивенсон"),
                new Book("Словарь", "С. Ожегов"),
                new Book("Энциклопедия", "БРЭ"));
        petrov.returnBook("Приключения", "Словарь", "Энциклопедия");
        petrov.returnBook(3);

        readers[1].takeBook(1);
        readers[2].takeBook(5);
    }
}
