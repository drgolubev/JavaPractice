package pr41.t10transport;

/** Самолёт: самый быстрый и дорогой, но долгая регистрация и досмотр. */
public class Plane extends Transport {

    public Plane() {
        super("Самолёт", 800, 7.0, 30.0);
    }

    @Override
    public double getExtraHours() { return 3.0; } // дорога в аэропорт, регистрация, посадка

    @Override
    public int getMaxPassengers() { return 180; }

    @Override
    public double getMaxCargoTons() { return 20; }
}
