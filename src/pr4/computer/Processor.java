package pr4.computer;

/** Процессор: модель, количество ядер, частота. */
public class Processor {

    private final String model;
    private final int cores;
    private final double frequencyGHz;

    public Processor(String model, int cores, double frequencyGHz) {
        this.model = model;
        this.cores = cores;
        this.frequencyGHz = frequencyGHz;
    }

    public String getModel() { return model; }
    public int getCores() { return cores; }
    public double getFrequencyGHz() { return frequencyGHz; }

    /** Условная «мощность» для сравнения процессоров: ядра * частота. */
    public double getPowerScore() {
        return cores * frequencyGHz;
    }

    @Override
    public String toString() {
        return model + " (" + cores + " ядер, " + frequencyGHz + " ГГц)";
    }
}
