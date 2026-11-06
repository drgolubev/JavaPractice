package pr41.t6employer;

/*
 * Manager (менеджер) — наследник Employer. Отличие: доп. выплаты от продаж.
 * averageSum — средняя сумма доп. выплат за продажи в месяц.
 *
 * getIncome() переопределён: берём доход как у обычного сотрудника (super.getIncome())
 * и добавляем выплаты с продаж за год (averageSum * 12).
 */
public class Manager extends Employer {

    private double averageSum;

    public Manager(String firstName, String lastName, double income, double averageSum) {
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }

    @Override
    public double getIncome() {
        return super.getIncome() + averageSum * 12;
    }
}
