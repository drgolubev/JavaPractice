package pr1;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №1, задание 5.
 * Вывод аргументов командной строки в цикле for.
 *
 * Аргументы командной строки — это строки, которые передаются программе при запуске.
 * Они попадают в массив String[] args метода main.
 *
 * Как передать аргументы в IntelliJ IDEA:
 *   Run → Edit Configurations... → поле "Program arguments" → например:  привет мир 123
 * Без аргументов программа просто сообщит, что их нет.
 */
public class Task5CommandLineArgs {

    public static void main(String[] args) {
        System.out.println("Количество аргументов: " + args.length);

        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }

        if (args.length == 0) {
            System.out.println("Аргументы не переданы (см. комментарий в начале файла).");
        }
    }
}
