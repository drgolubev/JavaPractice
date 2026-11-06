package pr41.t2phone;

/*
 * ПР4.1, Задание 2. Класс Phone (телефон) с полями number, model, weight.
 * Номера пунктов задания отмечены в комментариях.
 */
public class Phone {

    String number;
    String model;
    double weight;

    // 9) Конструктор без параметров
    public Phone() {
        this("не указан", "неизвестная модель"); // this(...) — вызов другого конструктора этого же класса
    }

    // 8) Конструктор с двумя параметрами: number, model
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    // 7) Конструктор с тремя параметрами: number, model, weight
    // 10) Из конструктора с тремя параметрами вызывается конструктор с двумя
    public Phone(String number, String model, double weight) {
        this(number, model);   // сначала заполняем number и model через конструктор с двумя параметрами
        this.weight = weight;  // потом дописываем вес
    }

    // 3), 4) receiveCall с одним параметром — имя звонящего
    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    // 11) Перегруженный receiveCall: имя звонящего + номер звонящего.
    // Перегрузка = методы с одинаковым именем, но разными параметрами.
    // Java выбирает нужный по количеству/типам аргументов при вызове.
    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " (" + callerNumber + ")");
    }

    // 5) Возвращает номер телефона
    public String getNumber() {
        return number;
    }

    // 13), 14) sendMessage с переменным числом аргументов (varargs).
    // String... numbers внутри метода — это обычный массив String[].
    public void sendMessage(String... numbers) {
        System.out.println("Сообщение отправлено на номера (" + numbers.length + " шт.):");
        for (String n : numbers) {
            System.out.println("  " + n);
        }
    }

    // 2) Вывод значений переменных
    public void printInfo() {
        System.out.println("Телефон: номер=" + number + ", модель=" + model + ", вес=" + weight + " г");
    }
}
