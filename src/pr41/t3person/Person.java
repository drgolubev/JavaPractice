package pr41.t3person;

/*
 * ПР4.1, Задание 3. Класс Person: поля fullName, age; методы move() и talk();
 * два конструктора — Person() и Person(fullName, age).
 */
public class Person {

    String fullName;
    int age;

    /** Конструктор без параметров — ставим значения-заглушки. */
    public Person() {
        fullName = "Неизвестный";
        age = 0;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void move() {
        System.out.println(fullName + " идёт");
    }

    public void talk() {
        System.out.println(fullName + " говорит");
    }

    public static void main(String[] args) {
        Person p1 = new Person();                         // через Person()
        Person p2 = new Person("Голубев Денис", 20);      // через Person(fullName, age)

        p1.move();
        p1.talk();
        System.out.println("  возраст: " + p1.age);

        p2.move();
        p2.talk();
        System.out.println("  возраст: " + p2.age);
    }
}
