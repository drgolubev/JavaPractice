package pr1classes.stock;

/*
 * ПР1 «Классы», Задание №2: класс Stock (акции компании).
 *
 * UML-диаграмма класса (перерисовать в draw.io):
 *
 *   +-------------------------------------------+
 *   |                  Stock                    |
 *   +-------------------------------------------+
 *   | symbol: String                            |
 *   | name: String                              |
 *   | previousClosingPrice: double              |
 *   | currentPrice: double                      |
 *   +-------------------------------------------+
 *   | Stock(newSymbol: String, newName: String) |
 *   | getChangePercent(): double                |
 *   +-------------------------------------------+
 */
public class Stock {

    /** Обозначение (тикер) акций, например "SBER". */
    String symbol;

    /** Наименование, например "ПАО Сбербанк". */
    String name;

    /** Цена акции на момент закрытия предыдущего дня. */
    double previousClosingPrice;

    /** Цена акции в настоящий момент. */
    double currentPrice;

    /** Конструктор: создаёт акции с указанными обозначением и наименованием. */
    Stock(String newSymbol, String newName) {
        symbol = newSymbol;
        name = newName;
    }

    /**
     * Процент изменения цены со вчерашнего закрытия до текущей цены.
     * Формула: (текущая - вчерашняя) / вчерашняя * 100.
     * Положительное число — акции подорожали, отрицательное — подешевели.
     */
    double getChangePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }
}
