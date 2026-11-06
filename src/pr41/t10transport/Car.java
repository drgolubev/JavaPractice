package pr41.t10transport;

/** Автомобиль: быстро «сел и поехал», мало мест и груза. */
public class Car extends Transport {

    public Car() {
        super("Автомобиль", 80, 5.0, 12.0);
    }

    @Override
    public double getExtraHours() { return 0.2; }   // ~12 минут на сборы

    @Override
    public int getMaxPassengers() { return 4; }

    @Override
    public double getMaxCargoTons() { return 0.5; }
}
