package pr4.planet;

/*
 * Демонстрация методов enum из присланного файла:
 *   name()           — конечный (final) метод, возвращает имя константы, переопределить нельзя;
 *   toString()       — тоже возвращает имя, но его МОЖНО переопределить;
 *   ordinal()        — позиция константы, начиная с нуля;
 *   valueOf(String)  — получить константу по её имени-строке;
 *   values()         — массив всех констант.
 *
 * Замечание по исходному коду из файла: там метод main написан ОТДЕЛЬНО от класса —
 * так в Java нельзя, любой метод должен быть внутри класса. Поэтому main вынесен сюда.
 * Ещё в исходнике вес берётся из args[0]; если аргумент не передан, программа упала бы
 * с ArrayIndexOutOfBoundsException — здесь подставляется 70 кг по умолчанию.
 */
public class PlanetDemo {

    public static void main(String[] args) {
        // --- Методы enum ---
        Planet p = Planet.MARS;
        System.out.println("name()     = " + p.name());
        System.out.println("toString() = " + p);              // println сам вызывает toString()
        System.out.println("ordinal()  = " + p.ordinal());    // MARS — четвёртая, индекс 3
        System.out.println("valueOf(\"EARTH\") = " + Planet.valueOf("EARTH"));
        System.out.println("values().length = " + Planet.values().length);
        // Planet.valueOf("Земля") выбросило бы IllegalArgumentException — такой константы нет

        // --- Пример из файла: вес на каждой планете ---
        Planet pEarth = Planet.EARTH;
        double earthRadius = pEarth.radius(); // просто пример вызова метода у константы
        System.out.println("\nРадиус Земли: " + earthRadius + " м");

        double earthWeight = (args.length > 0) ? Double.parseDouble(args[0]) : 70;
        double mass = earthWeight / pEarth.surfaceGravity(); // вычисляем массу по весу на Земле
        System.out.println("Вес на Земле: " + earthWeight);
        for (Planet planet : Planet.values()) {
            System.out.printf("Your weight on %-8s is %8.2f%n", planet, planet.surfaceWeight(mass));
        }
    }
}
