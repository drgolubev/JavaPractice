package pr4.seasons;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №4, Задание 1. Перечисление (enum) «Времена года».
 *
 * enum — особый класс с фиксированным набором объектов-констант (здесь их ровно 4).
 * Новых объектов Season создать нельзя: new Season(...) запрещено.
 *
 * Пункты задания:
 *   3) у каждой константы есть поле — средняя температура;
 *   4) конструктор принимает среднюю температуру;
 *   5) метод getDescription() возвращает "Холодное время года",
 *      а для ЛЕТА он переопределён и возвращает "Теплое время года".
 */
public enum Season {

    // Каждая константа вызывает конструктор Season(int) со своим значением температуры
    WINTER("Зима", -10),
    SPRING("Весна", 8),

    // У SUMMER есть своё «тело» в фигурных скобках — внутри мы переопределяем метод.
    // Технически Java создаёт для SUMMER анонимный подкласс Season.
    SUMMER("Лето", 22) {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },

    AUTUMN("Осень", 6); // точка с запятой обязательна, если после констант идут поля/методы

    private final String russianName;       // русское название для красивого вывода
    private final int averageTemperature;   // средняя температура, °C

    /** Конструктор enum всегда private (даже если не написать) — снаружи его вызвать нельзя. */
    Season(String russianName, int averageTemperature) {
        this.russianName = russianName;
        this.averageTemperature = averageTemperature;
    }

    public String getRussianName() {
        return russianName;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    /** Поведение «по умолчанию» для всех времён года. SUMMER его переопределяет. */
    public String getDescription() {
        return "Холодное время года";
    }
}
