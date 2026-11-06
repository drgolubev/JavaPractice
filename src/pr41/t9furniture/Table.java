package pr41.t9furniture;

/** Стол. Своё поле — количество мест. */
public class Table extends Furniture {

    private final int seats;

    public Table(String material, double price, int seats) {
        super("Стол на " + seats + " мест", material, price);
        this.seats = seats;
    }

    public int getSeats() { return seats; }

    @Override
    public String getPurpose() {
        return "чтобы есть или работать";
    }
}
