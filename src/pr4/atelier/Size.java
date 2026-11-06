package pr4.atelier;

/*
 * ПР4, Задание 2 «Ателье». Перечисление размеров одежды XXS, XS, S, M, L.
 * У каждой константы — числовое значение euroSize (32, 34, 36, 38, 40),
 * которое передаётся в конструктор.
 * getDescription() возвращает "Взрослый размер", а для XXS переопределён → "Детский размер".
 */
public enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }
}
