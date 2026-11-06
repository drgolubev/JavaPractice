package pr41.t6employer;

/*
 * Проверка задания 6.
 */
public class EmployerDemo {

    public static void main(String[] args) {
        // б) Переменная типа Employer, которая ссылается на объект типа Manager (upcast)
        Employer boss = new Manager("Ольга", "Смирнова", 90000, 25000);
        // Вызывается Manager.getIncome(), хотя тип переменной — Employer (полиморфизм)
        System.out.printf("%s: доход за год %.0f руб.%n", boss.getFullName(), boss.getIncome());

        // г) Массив типа Employer, в нём и обычные сотрудники, и менеджеры
        Employer[] staff = {
                new Employer("Иван", "Петров", 60000),
                new Manager("Анна", "Козлова", 80000, 15000),
                new Employer("Сергей", "Новиков", 55000),
                boss
        };

        System.out.println("\nДоходы всех сотрудников за год:");
        for (Employer e : staff) {
            String role = (e instanceof Manager) ? "менеджер" : "сотрудник";
            System.out.printf("  %-18s (%-9s) %,10.0f руб.%n", e.getFullName(), role, e.getIncome());
        }
    }
}
