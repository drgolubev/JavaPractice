package pr41.t7learners;

/*
 * ПР4.1, Задание 7. Суперкласс «Учащийся» (Learner).
 * Общее для школьника и студента: имя и возраст, метод study().
 */
public class Learner {

    protected String name;
    protected int age;

    public Learner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println(name + " учится");
    }

    @Override
    public String toString() {
        return name + ", " + age + " лет";
    }
}
