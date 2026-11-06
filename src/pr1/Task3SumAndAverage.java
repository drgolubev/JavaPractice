package pr1;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №1, задание 3.
 * Массив создаётся через инициализацию (как в Си: значения сразу в фигурных скобках),
 * в цикле for считается сумма элементов и среднее арифметическое.
 */
public class Task3SumAndAverage {

    public static void main(String[] args) {
        // Инициализация массива "как в Си": размер = количество значений в скобках (здесь 8)
        int[] numbers = {5, 12, -3, 8, 20, 7, 1, 10};

        int sum = 0; // сюда будем накапливать сумму

        // Цикл for: i идёт от 0 до numbers.length - 1 (индексы в Java начинаются с нуля)
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // то же самое, что sum = sum + numbers[i]
        }

        // Важно: делим как double, иначе int / int отбросит дробную часть (31 / 8 = 3, а не 3.875)
        double average = (double) sum / numbers.length;

        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        System.out.println("Сумма элементов: " + sum);
        System.out.printf("Среднее арифметическое: %.2f%n", average);
    }
}
