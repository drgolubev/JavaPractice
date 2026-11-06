package pr1classes.stock;

/*
 * Клиент класса Stock: создаёт акции SBER «ПАО Сбербанк», цена закрытия 281.50,
 * текущая цена 282.87, и выводит процент изменения.
 */
public class TestStock {

    public static void main(String[] args) {
        Stock stock = new Stock("SBER", "ПАО Сбербанк");

        // Поля без модификатора доступа видны внутри своего пакета, поэтому можем присвоить напрямую
        stock.previousClosingPrice = 281.50;
        stock.currentPrice = 282.87;

        System.out.println("Акции: " + stock.symbol + " (" + stock.name + ")");
        System.out.println("Цена закрытия предыдущего дня: " + stock.previousClosingPrice);
        System.out.println("Текущая цена: " + stock.currentPrice);
        // (282.87 - 281.50) / 281.50 * 100 ≈ 0.49 %
        System.out.printf("Изменение цены: %.2f%%%n", stock.getChangePercent()); // %% — это знак процента
    }
}
