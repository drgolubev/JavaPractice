package pr4.shop;

/*
 * Пользователь магазина: логин и пароль.
 * Пароль приватный и наружу не отдаётся — есть только метод проверки checkPassword().
 */
public class User {

    private final String login;
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public boolean checkPassword(String attempt) {
        return password.equals(attempt); // строки сравниваем через equals, а не через ==
    }
}
