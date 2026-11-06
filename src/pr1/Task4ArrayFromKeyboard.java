package pr1;

import java.util.Scanner;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №1, задание 4.
 * Массив вводится с клавиатуры. Сумма считается циклами do-while и while,
 * также ищутся максимальный и минимальный элементы.
 */
public class Task4ArrayFromKeyboard {

    public static void main(String[] args) {
        // Scanner читает то, что пользователь набирает в консоли
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько элементов будет в массиве? ");
        int n = scanner.nextInt();

        int[] array = new int[n]; // создаём пустой массив нужного размера

        // Ввод элементов (тут используем while, чтобы показать ещё один вид цикла)
        int i = 0;
        while (i < n) {
            System.out.print("Введите элемент №" + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }

        // --- Сумма с помощью do-while ---
        // do-while сначала выполняет тело, а потом проверяет условие,
        // поэтому тело выполнится минимум один раз. Проверяем n > 0, чтобы не выйти за границы.
        int sumDoWhile = 0;
        if (n > 0) {
            int j = 0;
            do {
                sumDoWhile += array[j];
                j++;
            } while (j < n);
        }

        // --- Сумма с помощью while ---
        // while сначала проверяет условие, и только потом выполняет тело.
        int sumWhile = 0;
        int k = 0;
        while (k < n) {
            sumWhile += array[k];
            k++;
        }

        System.out.println("Сумма (do-while): " + sumDoWhile);
        System.out.println("Сумма (while):    " + sumWhile);

        // --- Поиск максимума и минимума ---
        if (n > 0) {
            int max = array[0]; // считаем, что первый элемент пока самый большой
            int min = array[0]; // ...и самый маленький
            int m = 1;
            while (m < n) {
                if (array[m] > max) max = array[m]; // нашли больше — запоминаем
                if (array[m] < min) min = array[m]; // нашли меньше — запоминаем
                m++;
            }
            System.out.println("Максимальный элемент: " + max);
            System.out.println("Минимальный элемент:  " + min);
        } else {
            System.out.println("Массив пустой — максимума и минимума нет.");
        }

        scanner.close();
    }
}
