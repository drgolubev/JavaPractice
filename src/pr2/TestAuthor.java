package pr2;

/*
 * Тестовый класс для Author: проверяем конструктор, все геттеры, сеттер и toString().
 */
public class TestAuthor {

    public static void main(String[] args) {
        Author a1 = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'M');
        Author a2 = new Author("Sue Grant", "suGrant@somewhere.com", 'F');
        Author a3 = new Author("Аноним", "anon@mail.ru", 'x'); // некорректный пол → станет 'U'

        // println(объект) автоматически вызывает у объекта toString()
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        // Геттеры
        System.out.println("Имя: " + a1.getName());
        System.out.println("Email: " + a1.getEmail());
        System.out.println("Пол: " + a1.getGender());

        // Сеттер: меняем почту и проверяем, что изменение сохранилось
        a1.setEmail("tan.new@somewhere.com");
        System.out.println("После setEmail: " + a1);

        // a1.name = "Другое имя";  // ОШИБКА КОМПИЛЯЦИИ: поле name private, извне класса к нему доступа нет
        // a1.setName("...");      // ОШИБКА КОМПИЛЯЦИИ: такого метода нет, имя менять нельзя по условию
    }
}
