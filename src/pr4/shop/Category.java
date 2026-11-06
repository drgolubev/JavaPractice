package pr4.shop;

/*
 * ПР4, Задание 3 «Интернет-магазин». Перечисление каталогов (категорий) товаров.
 */
public enum Category {
    ELECTRONICS("Электроника"),
    BOOKS("Книги"),
    CLOTHES("Одежда");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
