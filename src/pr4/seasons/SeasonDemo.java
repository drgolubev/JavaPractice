package pr4.seasons;

/*
 * Демонстрация задания 1 (пункты 1, 2, 6).
 */
public class SeasonDemo {

    public static void main(String[] args) {
        // 1) Переменная с любимым временем года и вся информация о нём
        Season favourite = Season.SUMMER;
        System.out.println("Моё любимое время года: " + favourite.getRussianName());
        System.out.println("  name()       = " + favourite.name());       // имя константы: SUMMER
        System.out.println("  ordinal()    = " + favourite.ordinal());    // позиция с нуля: 2
        System.out.println("  температура  = " + favourite.getAverageTemperature() + " °C");
        System.out.println("  описание     = " + favourite.getDescription());

        // 2) Метод со switch
        System.out.println();
        whatILove(favourite);
        whatILove(Season.WINTER);

        // 6) В цикле печатаем все времена года: values() возвращает массив всех констант
        System.out.println("\nВсе времена года:");
        for (Season s : Season.values()) {
            System.out.printf("%-6s (%-6s): %4d °C, %s%n",
                    s.getRussianName(), s, s.getAverageTemperature(), s.getDescription());
        }
    }

    /**
     * 2) Принимает переменную типа Season и через switch выводит "Я люблю ...".
     * Внутри case пишется просто SUMMER, а не Season.SUMMER — Java сама знает тип.
     */
    static void whatILove(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break; // break нужен, чтобы не «провалиться» в следующий case
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
}
