package pr41.t7learners;

/** Подкласс «Студент»: дополнительно хранит вуз и курс. */
public class Student extends Learner {

    private final String university;
    private final int course;

    public Student(String name, int age, String university, int course) {
        super(name, age);
        this.university = university;
        this.course = course;
    }

    @Override
    public void study() {
        System.out.println(name + " учится в вузе " + university + ", " + course + " курс");
    }

    @Override
    public String toString() {
        return "Студент: " + super.toString() + ", " + university + ", " + course + " курс";
    }
}
