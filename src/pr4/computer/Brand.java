package pr4.computer;

/*
 * ПР4, Задание 4. Марки компьютеров — перечисление (так требует задание).
 * У каждой марки — страна производителя.
 */
public enum Brand {
    APPLE("США"),
    LENOVO("Китай"),
    ASUS("Тайвань"),
    HP("США"),
    DELL("США");

    private final String country;

    Brand(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
