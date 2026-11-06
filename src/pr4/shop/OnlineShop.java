package pr4.shop;

import java.util.List;
import java.util.Scanner;

/*
 * ПР4, Задание 3. Мини-приложение «Интернет-магазин» (консольное меню).
 *
 * Возможности (по пунктам задания):
 *   1) аутентификация — логин и пароль с клавиатуры (3 попытки);
 *   2) просмотр списка каталогов;
 *   3) просмотр товаров выбранного каталога;
 *   4) выбор товара в корзину;
 *   5) покупка товаров из корзины.
 *
 * Тестовые пользователи:  denis / 1234   и   admin / admin
 *
 * Запуск: Run → OnlineShop, дальше вводите цифры пунктов меню в консоли IntelliJ.
 */
public class OnlineShop {

    // «База» пользователей. static — общая для всего класса, объект магазина для этого не нужен
    private static final User[] USERS = {
            new User("denis", "1234"),
            new User("admin", "admin")
    };

    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart = new Cart();
    private User currentUser;

    public static void main(String[] args) {
        new OnlineShop().run();
    }

    void run() {
        System.out.println("Добро пожаловать в интернет-магазин!");
        if (!login()) {
            System.out.println("Слишком много неудачных попыток. До свидания.");
            return;
        }

        // Главный цикл меню: крутится, пока пользователь не выберет 0
        while (true) {
            System.out.println("\n----- Меню -----");
            System.out.println("1 — список каталогов");
            System.out.println("2 — товары каталога (и выбор в корзину)");
            System.out.println("3 — показать корзину");
            System.out.println("4 — купить товары в корзине");
            System.out.println("0 — выход");
            int choice = readInt("Ваш выбор: ");

            switch (choice) {
                case 1 -> showCategories();
                case 2 -> showProductsAndAddToCart();
                case 3 -> cart.print();
                case 4 -> buy();
                case 0 -> {
                    System.out.println("Спасибо, " + currentUser.getLogin() + ", ждём снова!");
                    return;
                }
                default -> System.out.println("Нет такого пункта меню.");
            }
            // (Это «новый» switch со стрелками ->: break писать не нужно, провала в следующий case нет.)
        }
    }

    /** 1) Аутентификация: ищем пользователя с таким логином и проверяем пароль. */
    private boolean login() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Логин: ");
            String login = scanner.nextLine().trim();
            System.out.print("Пароль: ");
            String password = scanner.nextLine().trim();

            for (User u : USERS) {
                if (u.getLogin().equals(login) && u.checkPassword(password)) {
                    currentUser = u;
                    System.out.println("Вы вошли как " + login + ".");
                    return true;
                }
            }
            System.out.println("Неверный логин или пароль (попытка " + attempt + " из 3).");
        }
        return false;
    }

    /** 2) Список каталогов — просто перебираем все константы enum Category. */
    private void showCategories() {
        System.out.println("Каталоги:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println("  " + (i + 1) + ". " + categories[i].getTitle());
        }
    }

    /** 3) + 4) Товары выбранного каталога и добавление выбранного товара в корзину. */
    private void showProductsAndAddToCart() {
        showCategories();
        Category[] categories = Category.values();
        int c = readInt("Номер каталога: ");
        if (c < 1 || c > categories.length) {
            System.out.println("Нет такого каталога.");
            return;
        }
        Category category = categories[c - 1]; // пользователь считает с 1, массив — с 0

        List<Product> products = Product.byCategory(category);
        System.out.println("Товары каталога «" + category.getTitle() + "»:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + products.get(i));
        }

        int p = readInt("Номер товара для корзины (0 — назад): ");
        if (p >= 1 && p <= products.size()) {
            Product chosen = products.get(p - 1);
            cart.add(chosen);
            System.out.println("«" + chosen.getTitle() + "» добавлен в корзину.");
        }
    }

    /** 5) Покупка: показываем итог, очищаем корзину. */
    private void buy() {
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста — нечего покупать.");
            return;
        }
        cart.print();
        System.out.printf("Покупка оформлена! Списано %.0f руб. Спасибо, %s!%n",
                cart.getTotal(), currentUser.getLogin());
        cart.clear();
    }

    /** Безопасное чтение числа: если ввели не число — переспрашиваем, программа не падает. */
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }
    }
}
