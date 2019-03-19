import java.util.Scanner;

public class Main {
    private static int sizeReading(Scanner in) {
        int rows = in.nextInt();
        while (rows <= 0) {
            System.out.println("Введите число больше 0: ");
            rows = in.nextInt();
        }
        return rows;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк для первой матрицы: ");
        int n1 = sizeReading(in);
        System.out.print("Введите количество столбцов для первой матрицы: ");
        int m1 = sizeReading(in);
        System.out.print("Введите количество строк для второй матрицы: ");
        int n2 = sizeReading(in);
        System.out.print("Введите количество столбцов для второй матрицы: ");
        int m2 = sizeReading(in);
        Matrix one = new Matrix(n1, m1);
        Matrix two = new Matrix(n2, m2);
        one.Filling();
        two.Filling();

        one.Display();
        two.Display();

        if (one.getRows() != two.getRows() || one.getCols() != two.getCols())
            System.out.println("Матрицы не могут быть сложены, так как они разного размера");
        else {
            System.out.print("    Сложение матриц");
            one.Addition(two).Display();
        }

        if (one.getCols() != two.getRows())
            System.out.println("Матрицы не могут быть умножены, так как они разного размера");
        else {
            System.out.print("    Умножение матриц");
            one.Multiplication(two).Display();
        }

        if (one.getRows() != two.getRows() || one.getCols() != two.getCols())
            System.out.println("Матрицы не могут быть вычтены, так как они разного размера");
        else {
            System.out.print("    Вычитание матриц");
            one.Subtraction(two).Display();
        }

        System.out.print("    Умножение первой матрицы на 2:");
        one.MultiplicationBy(2).Display();

        System.out.print("    Транспонирование второй матрицы:");
        two.Transposition().Display();

        int detOne = one.Determinant();
        //System.out.println(detOne);
        int detTwo = two.Determinant();
        //System.out.println(detTwo);
        if (detOne != 0) {
            System.out.println("Обратная к первой матрица");
            one.InverseMatrix(detOne);
        } else System.out.println("Определитель первой матрицы равен 0, поэтому обратную матрицу найти нельзя");
        if (detTwo != 0) {
            System.out.println("Обратная к второй матрица");
            two.InverseMatrix(detTwo);
        } else System.out.println("Определитель второй матрицы равен 0, поэтому обратную матрицу найти нельзя");
    }
}
