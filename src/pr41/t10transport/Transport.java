package pr41.t10transport;

/*
 * ПР4.1, Задание 10. Абстрактный класс «Транспортное средство».
 *
 * Общее для всех: название, средняя скорость (км/ч), тариф за пассажиро-километр
 * и за тонно-километр груза. Время в пути считается одинаково для всех: расстояние / скорость
 * + время на подготовку (getExtraHours — у каждого вида своё: посадка в аэропорту, погрузка и т.п.).
 *
 * Абстрактные методы (их обязаны реализовать подклассы):
 *   getExtraHours()        — доп. время на посадку/погрузку;
 *   getMaxPassengers()     — сколько пассажиров можно взять;
 *   getMaxCargoTons()      — сколько тонн груза можно взять.
 */
public abstract class Transport {

    protected String name;
    protected double speedKmh;
    protected double passengerRatePerKm; // руб. за 1 пассажира на 1 км
    protected double cargoRatePerTonKm;  // руб. за 1 тонну на 1 км

    public Transport(String name, double speedKmh, double passengerRatePerKm, double cargoRatePerTonKm) {
        this.name = name;
        this.speedKmh = speedKmh;
        this.passengerRatePerKm = passengerRatePerKm;
        this.cargoRatePerTonKm = cargoRatePerTonKm;
    }

    public abstract double getExtraHours();
    public abstract int getMaxPassengers();
    public abstract double getMaxCargoTons();

    /** Время в пути, часов. Общая формула для всех — поэтому метод обычный, не абстрактный. */
    public double travelTime(double distanceKm) {
        return distanceKm / speedKmh + getExtraHours();
    }

    /** Стоимость перевозки пассажиров. Если пассажиров больше вместимости — нужно несколько рейсов. */
    public double passengerCost(double distanceKm, int passengers) {
        checkCapacity(passengers, getMaxPassengers(), "пассажиров");
        return distanceKm * passengers * passengerRatePerKm;
    }

    /** Стоимость перевозки груза. */
    public double cargoCost(double distanceKm, double tons) {
        checkCapacity(tons, getMaxCargoTons(), "тонн груза");
        return distanceKm * tons * cargoRatePerTonKm;
    }

    private void checkCapacity(double amount, double max, String what) {
        if (amount > max) {
            System.out.printf("  (!) %s вмещает максимум %.0f %s, понадобится несколько рейсов%n", name, max, what);
        }
    }

    public String getName() {
        return name;
    }
}
