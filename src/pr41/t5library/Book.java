package pr41.t5library;

/** ПР4.1, Задание 5. Книга: название и автор. */
public class Book {

    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}
