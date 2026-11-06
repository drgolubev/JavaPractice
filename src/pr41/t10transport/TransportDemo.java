package pr41.t10transport;

/*
 * Задание 10: считаем время и стоимость перевозки пассажиров и грузов каждым транспортом.
 * Массив типа Transport (абстрактный класс) хранит конкретные объекты —
 * для каждого вызываются его собственные реализации абстрактных методов.
 */
public class TransportDemo {

    public static void main(String[] args) {
        double distance = 700;  // км, например Москва — Санкт-Петербург
        int passengers = 3;
        double cargoTons = 0.4;

        Transport[] fleet = {new Car(), new Plane(), new Train(), new Ship()};

        System.out.printf("Расстояние %.0f км, %d пассажира, %.1f т груза%n%n", distance, passengers, cargoTons);
        System.out.printf("%-11s | %10s | %18s | %14s%n", "Транспорт", "Время, ч", "Пассажиры, руб.", "Груз, руб.");
        System.out.println("------------+------------+--------------------+---------------");
        for (Transport t : fleet) {
            System.out.printf("%-11s | %10.1f | %18.0f | %14.0f%n",
                    t.getName(),
                    t.travelTime(distance),
                    t.passengerCost(distance, passengers),
                    t.cargoCost(distance, cargoTons));
        }

        // Найдём самый быстрый вариант
        Transport fastest = fleet[0];
        for (Transport t : fleet) {
            if (t.travelTime(distance) < fastest.travelTime(distance)) {
                fastest = t;
            }
        }
        System.out.println("\nБыстрее всего: " + fastest.getName());
    }
}
