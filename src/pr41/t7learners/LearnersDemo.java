package pr41.t7learners;

/*
 * Задание 7: массив объектов суперкласса Learner, заполненный школьниками и студентами.
 * Отдельно показываем студентов и школьников — проверяем реальный тип через instanceof.
 */
public class LearnersDemo {

    public static void main(String[] args) {
        Learner[] learners = {
                new Student("Денис", 20, "МИРЭА", 3),
                new Schoolboy("Петя", 12, 6),
                new Student("Аня", 19, "МГУ", 2),
                new Schoolboy("Маша", 16, 10),
                new Schoolboy("Коля", 8, 2)
        };

        System.out.println("Все учащиеся:");
        for (Learner l : learners) {
            l.study(); // у каждого своя версия study() — полиморфизм
        }

        System.out.println("\nСтуденты:");
        for (Learner l : learners) {
            if (l instanceof Student) {
                System.out.println("  " + l);
            }
        }

        System.out.println("\nШкольники:");
        for (Learner l : learners) {
            if (l instanceof Schoolboy) {
                System.out.println("  " + l);
            }
        }
    }
}
