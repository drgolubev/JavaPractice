package pr41.t10transport;

/** Корабль: медленный, но самая дешёвая перевозка груза и огромная вместимость. */
public class Ship extends Transport {

    public Ship() {
        super("Корабль", 30, 3.0, 1.0);
    }

    @Override
    public double getExtraHours() { return 4.0; } // погрузка в порту

    @Override
    public int getMaxPassengers() { return 2000; }

    @Override
    public double getMaxCargoTons() { return 50000; }
}
