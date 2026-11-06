package pr4.computer;

/** Оперативная память: объём и тип. Объём можно увеличить (апгрейд). */
public class Memory {

    private int sizeGb;
    private final String type; // например, DDR4, DDR5, LPDDR5

    public Memory(int sizeGb, String type) {
        this.sizeGb = sizeGb;
        this.type = type;
    }

    public int getSizeGb() { return sizeGb; }
    public String getType() { return type; }

    /** Добавить планку памяти. */
    public void upgrade(int extraGb) {
        sizeGb += extraGb;
    }

    @Override
    public String toString() {
        return sizeGb + " ГБ " + type;
    }
}
