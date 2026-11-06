package pr4.computer;

/** Монитор: диагональ и разрешение. Умеет включаться и выключаться. */
public class Monitor {

    private final double diagonalInches;
    private final int widthPx;
    private final int heightPx;
    private boolean on;

    public Monitor(double diagonalInches, int widthPx, int heightPx) {
        this.diagonalInches = diagonalInches;
        this.widthPx = widthPx;
        this.heightPx = heightPx;
    }

    public void turnOn() { on = true; }
    public void turnOff() { on = false; }
    public boolean isOn() { return on; }

    @Override
    public String toString() {
        return diagonalInches + "\" " + widthPx + "x" + heightPx;
    }
}
