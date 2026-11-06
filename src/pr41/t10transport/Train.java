package pr41.t10transport;

/** Поезд: средняя скорость, дёшево, много мест и груза. */
public class Train extends Transport {

    public Train() {
        super("Поезд", 70, 2.5, 3.0);
    }

    @Override
    public double getExtraHours() { return 0.5; }

    @Override
    public int getMaxPassengers() { return 600; }

    @Override
    public double getMaxCargoTons() { return 3000; }
}
