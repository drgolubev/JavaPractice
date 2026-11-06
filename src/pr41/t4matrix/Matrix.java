package pr41.t4matrix;

/*
 * ПР4.1, Задание 4. Класс Matrix (матрица).
 * Поля: двумерный массив вещественных чисел, количество строк и столбцов.
 * Методы: сложение с другой матрицей, умножение на число, вывод на печать,
 *         умножение матриц (по желанию — тоже сделано).
 *
 * Методы НЕ меняют исходную матрицу, а возвращают новую — так безопаснее.
 */
public class Matrix {

    private final double[][] data; // двумерный массив: data[строка][столбец]
    private final int rows;
    private final int cols;

    /** Пустая (нулевая) матрица заданного размера. */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    /** Матрица из готового двумерного массива (значения копируются). */
    public Matrix(double[][] values) {
        this(values.length, values[0].length);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = values[i][j];
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    /** 1) Сложение: размеры должны совпадать, складываем поэлементно. */
    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Складывать можно только матрицы одинакового размера");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    /** 2) Умножение на число: каждый элемент умножаем на k. */
    public Matrix multiply(double k) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] * k;
            }
        }
        return result;
    }

    /**
     * 4) Умножение матриц A (rows x cols) * B (cols x n) = C (rows x n).
     * Условие: число столбцов A равно числу строк B.
     * Элемент C[i][j] = сумма A[i][k] * B[k][j] по всем k («строка на столбец»).
     * Это перегрузка: метод multiply с параметром Matrix, а выше — с параметром double.
     */
    public Matrix multiply(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно равняться числу строк второй");
        }
        Matrix result = new Matrix(rows, other.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    /** 3) Вывод на печать. */
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f", data[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        Matrix b = new Matrix(new double[][]{
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix c = new Matrix(new double[][]{
                {1, 0},
                {0, 1},
                {2, 3}
        });

        System.out.println("A:");
        a.print();
        System.out.println("B:");
        b.print();
        System.out.println("A + B:");
        a.add(b).print();
        System.out.println("A * 2.5:");
        a.multiply(2.5).print();
        System.out.println("C:");
        c.print();
        System.out.println("A * C (2x3 на 3x2 = 2x2):");
        a.multiply(c).print();
    }
}
