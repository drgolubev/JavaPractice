package pr41.t7learners;

/** Подкласс «Школьник»: дополнительно хранит класс (1–11). */
public class Schoolboy extends Learner {

    private final int grade;

    public Schoolboy(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void study() {
        System.out.println(name + " учится в школе, " + grade + " класс");
    }

    @Override
    public String toString() {
        return "Школьник: " + super.toString() + ", " + grade + " класс";
    }
}
