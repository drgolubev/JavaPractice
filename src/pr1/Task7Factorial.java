package pr1;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №1, задание 7.
 * Метод класса (static) вычисляет факториал числа с помощью цикла. Проверяем работу метода.
 *
 * Факториал n! = 1 * 2 * 3 * ... * n, по определению 0! = 1.
 */
public class Task7Factorial {

    /**
     * Статический метод — его можно вызывать без создания объекта: factorial(5).
     * Используем long, потому что факториал растёт очень быстро:
     * int переполняется уже на 13!, long выдерживает до 20!.
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определён");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) { // начинаем с 2, потому что умножать на 1 нет смысла
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Проверка работы метода на нескольких значениях
        int[] tests = {0, 1, 5, 10, 20};
        for (int n : tests) { // цикл "for-each": перебирает все элементы массива по очереди
            System.out.println(n + "! = " + factorial(n));
        }

        // Проверка на известном ответе: 5! должно быть 120
        System.out.println("Проверка 5! == 120: " + (factorial(5) == 120));
    }
}
