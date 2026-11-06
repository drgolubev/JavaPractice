package pr41.t5library;

/*
 * ПР4.1, Задание 5. «Читатели библиотеки».
 * Класс Reader хранит: ФИО, номер читательского билета, факультет, дату рождения, телефон.
 *
 * Методы takeBook() и returnBook() ПЕРЕГРУЖЕНЫ — у каждого три версии:
 *   1) принимает КОЛИЧЕСТВО книг (int)            → "Петров В. В. взял 3 книги"
 *   2) принимает НАЗВАНИЯ книг (String...)        → "Петров В. В. взял книги: Приключения, Словарь, ..."
 *   3) принимает ОБЪЕКТЫ Book (Book...)           → то же, но названия берутся из объектов
 * Java выбирает версию по типу аргументов в момент вызова.
 * "..." (varargs) значит «любое количество аргументов», внутри метода это массив.
 */
public class Reader {

    private final String fullName;
    private final int ticketNumber;
    private final String faculty;
    private final String birthDate;
    private final String phone;

    public Reader(String fullName, int ticketNumber, String faculty, String birthDate, String phone) {
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    // ---------- takeBook ----------

    public void takeBook(int count) {
        System.out.println(fullName + " взял " + count + " " + booksWord(count));
    }

    public void takeBook(String... titles) {
        System.out.println(fullName + " взял книги: " + String.join(", ", titles));
    }

    public void takeBook(Book... books) {
        System.out.println(fullName + " взял книги: " + titlesOf(books));
    }

    // ---------- returnBook ----------

    public void returnBook(int count) {
        System.out.println(fullName + " вернул " + count + " " + booksWord(count));
    }

    public void returnBook(String... titles) {
        System.out.println(fullName + " вернул книги: " + String.join(", ", titles));
    }

    public void returnBook(Book... books) {
        System.out.println(fullName + " вернул книги: " + titlesOf(books));
    }

    // ---------- вспомогательные методы (private — нужны только внутри класса) ----------

    /** Собирает названия книг через запятую. */
    private String titlesOf(Book[] books) {
        String[] titles = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            titles[i] = books[i].getTitle();
        }
        return String.join(", ", titles);
    }

    /** Правильное окончание: 1 книгу, 3 книги, 5 книг. */
    private String booksWord(int n) {
        int lastTwo = n % 100;
        int last = n % 10;
        if (lastTwo >= 11 && lastTwo <= 14) return "книг";
        if (last == 1) return "книгу";
        if (last >= 2 && last <= 4) return "книги";
        return "книг";
    }

    @Override
    public String toString() {
        return String.format("%-15s | билет №%d | %-10s | д.р. %s | тел. %s",
                fullName, ticketNumber, faculty, birthDate, phone);
    }
}
