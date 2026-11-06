package pr41.t6employer;

/*
 * ПР4.1, Задание 6. Класс Employer (сотрудник): имя, фамилия, зарплата.
 *
 * getIncome() возвращает годовой доход: месячная зарплата * 12
 * (в методичке пункт сформулирован неразборчиво — «...сумма дохода умножается на 12»;
 * понимаем его так: доход за год = 12 месячных зарплат).
 */
public class Employer {

    protected String firstName;
    protected String lastName;
    protected double income; // зарплата в месяц

    public Employer(String firstName, String lastName, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    public double getIncome() {
        return income * 12;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
