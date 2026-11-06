package pr4.computer;

/*
 * ПР4, Задание 4. Класс Computer (компьютер).
 *
 * Компьютер СОСТОИТ из процессора, памяти и монитора — это композиция:
 * поля класса имеют типы других классов (Processor, Memory, Monitor).
 * Марка — поле типа enum Brand.
 */
public class Computer {

    private final Brand brand;
    private final String model;
    private final Processor processor;
    private final Memory memory;
    private final Monitor monitor;
    private boolean on;

    public Computer(Brand brand, String model, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    public Brand getBrand() { return brand; }
    public Processor getProcessor() { return processor; }
    public Memory getMemory() { return memory; }
    public Monitor getMonitor() { return monitor; }

    /** Включение компьютера включает и монитор — объект управляет своими частями. */
    public void turnOn() {
        on = true;
        monitor.turnOn();
        System.out.println(brand + " " + model + " включён.");
    }

    public void turnOff() {
        on = false;
        monitor.turnOff();
        System.out.println(brand + " " + model + " выключен.");
    }

    public boolean isOn() { return on; }

    @Override
    public String toString() {
        return "Компьютер " + brand + " " + model + " (страна марки: " + brand.getCountry() + ")\n"
                + "  Процессор: " + processor + "\n"
                + "  Память:    " + memory + "\n"
                + "  Монитор:   " + monitor;
    }

    public static void main(String[] args) {
        Computer mac = new Computer(Brand.APPLE, "MacBook Air",
                new Processor("Apple M3", 8, 4.05),
                new Memory(8, "LPDDR5"),
                new Monitor(13.6, 2560, 1664));

        Computer gaming = new Computer(Brand.ASUS, "ROG Strix",
                new Processor("Intel Core i7-13650HX", 14, 4.9),
                new Memory(16, "DDR5"),
                new Monitor(16, 2560, 1600));

        System.out.println(mac);
        System.out.println(gaming);

        System.out.println();
        mac.turnOn();
        System.out.println("Монитор включён? " + mac.getMonitor().isOn());
        mac.getMemory().upgrade(8);
        System.out.println("После апгрейда памяти: " + mac.getMemory());
        mac.turnOff();

        // Сравниваем процессоры по условной мощности
        Computer stronger = mac.getProcessor().getPowerScore() > gaming.getProcessor().getPowerScore()
                ? mac : gaming;
        System.out.println("Процессор мощнее у: " + stronger.getBrand());

        // Все доступные марки — через values()
        System.out.print("Доступные марки: ");
        for (Brand b : Brand.values()) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
