package pr2;

/*
 * ПРАКТИЧЕСКАЯ РАБОТА №2. Класс Author (автор книги), реализованный строго по UML-диаграмме:
 *
 *   +------------------------------------------------------+
 *   |                       Author                         |
 *   +------------------------------------------------------+
 *   | -name: String                                        |
 *   | -email: String                                       |
 *   | -gender: char                                        |
 *   +------------------------------------------------------+
 *   | +Author(name: String, email: String, gender: char)   |
 *   | +getName(): String                                   |
 *   | +getEmail(): String                                  |
 *   | +setEmail(email: String): void                       |
 *   | +getGender(): char                                   |
 *   | +toString(): String                                  |
 *   +------------------------------------------------------+
 *
 * Обозначения UML:  "-" = private (виден только внутри класса),  "+" = public (виден всем).
 *
 * Инкапсуляция: поля закрыты (private), доступ к ним — только через методы (геттеры/сеттеры).
 * Сеттеров для name и gender НЕТ специально: имя и пол автора после создания не меняются.
 * Конструктора по умолчанию тоже нет: нет разумных значений по умолчанию для имени, почты и пола.
 */
public class Author {

    private String name;
    private String email;
    /** 'M' — мужчина, 'F' — женщина, 'U' — пол неизвестен. */
    private char gender;

    /** Единственный конструктор: инициализирует все три поля. */
    public Author(String name, String email, char gender) {
        // this.name — это поле объекта, а name — параметр конструктора.
        // this нужен, потому что у них одинаковые имена.
        this.name = name;
        this.email = email;
        // Проверяем, что пол — одно из трёх допустимых значений; иначе ставим 'U'
        char g = Character.toUpperCase(gender);
        this.gender = (g == 'M' || g == 'F') ? g : 'U';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    /** Почту изменить можно (например, автор сменил адрес). */
    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    /**
     * Формат из задания: имя[пробел](пол)[пробел]at[пробел]email
     * Пример: "Tan Ah Teck (m) at ahTeck@somewhere.com".
     * Аннотация @Override говорит, что мы переопределяем метод toString() класса Object.
     */
    @Override
    public String toString() {
        return name + " (" + Character.toLowerCase(gender) + ") at " + email;
    }
}
