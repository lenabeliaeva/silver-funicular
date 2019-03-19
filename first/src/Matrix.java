public class Matrix {

    private int rows, cols;
    private double[][] matrix;
    private Matrix result;

    public Matrix(int n, int m) {
        rows = n;
        cols = m;
        matrix = new double[rows][cols];
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void setElement(int i, int j, double value) {
        this.matrix[i][j] = value;
    }

    public double getElement(int i, int j) {
        return this.matrix[i][j];
    }

    public void Filling() {              //заполнение матрицы
        for (int i = 0; i < this.rows; ++i)
            for (int j = 0; j < this.cols; ++j)
                matrix[i][j] = (int) (Math.random() * 10);
    }

    public void Display() {
        for (int i = 0; i < this.rows; ++i) {
            System.out.println();
            for (int j = 0; j < this.cols; ++j)
                System.out.print(this.matrix[i][j] + " ");
        }
        System.out.println();
    }

    public Matrix Addition(Matrix B) {
        result = new Matrix(this.rows, B.cols);
        for (int i = 0; i < result.rows; ++i)
            for (int j = 0; j < result.cols; ++j)
                result.setElement(i, j, this.getElement(i, j) + B.getElement(i, j));
        return result;
    }

    public Matrix Multiplication(Matrix B) {
        result = new Matrix(this.rows, B.cols);
        double sum = 0;
        for (int i = 0; i < result.rows; ++i) {
            for (int j = 0; j < result.cols; ++j) {
                for (int k = 0; k < result.cols; ++k) {
                    result.setElement(i, j, result.getElement(i,j) + this.getElement(i, k) * B.getElement(k, j));
                }
            }
        }
        return result;
    }

    public Matrix Subtraction(Matrix B) {

        result = new Matrix(this.rows, B.cols);
        for (int i = 0; i < result.rows; ++i)
            for (int j = 0; j < result.cols; ++j)
                result.setElement(i, j, this.getElement(i, j) - B.getElement(i, j));
        return result;
    }

    public Matrix MultiplicationBy(int number) {
        result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < result.rows; ++i)
            for (int j = 0; j < result.cols; ++j)
                result.setElement(i, j, this.getElement(i, j) * number);
        return result;
    }

    public Matrix Transposition() {
        result = new Matrix(this.cols, this.rows);
        double t;
        for (int i = 0; i < this.cols; ++i)
            for (int j = i; j < this.rows; ++j) {
                t = this.getElement(i, j);
                result.setElement(i, j, this.getElement(j, i));
                result.setElement(j, i, t);
            }
        return result;
    }

    public void TranspositionForInverse() {
        double t;
        for (int i = 0; i < this.rows; ++i)
            for (int j = i; j < this.cols; ++j) {
                t = this.getElement(i, j);
                this.setElement(i, j, this.getElement(j, i));
                this.setElement(j, i, t);
            }
    }

    public void DivisionBy(int det) {
        for (int i = 0; i < this.rows; ++i)
            for (int j = 0; j < this.cols; ++j) {
                this.setElement(i, j, this.getElement(i, j) / det);
            }
    }

    public int Determinant() {
        int det = 1;
        if (this.cols != this.rows) {
            System.out.println("Матрица не квадратная, поэтому определитель вычислить нельзя");
            return 0;
        } else {
            result = new Matrix(this.rows, this.cols);
            for (int i = 0; i < result.rows; ++i)
                for (int j = 0; j < result.cols; ++j)
                    result.setElement(i, j, this.getElement(i, j));
            double t;
            for (int k = 0; k < result.rows; ++k) {
                for (int j = k + 1; j < result.cols; ++j) {
                    if (result.getElement(k, k) != 0)
                        t = result.getElement(j, k) / result.getElement(k, k);
                    else {
                        int m = 1;
                        while (m < result.rows && result.getElement(m, 0) == 0)
                            ++m;
                        if (m == result.rows)
                            return 0;
                        else {
                            for (int z = 0; z < result.cols; ++z)
                                result.setElement(k, z, result.getElement(k, z) + result.getElement(m, z));
                            t = result.getElement(j + k, k) / result.getElement(k, k);
                        }
                    }
                    for (int i = 0; i < result.cols; ++i)
                        result.setElement(j, i, result.getElement(j, i) - t * result.getElement(k, i));
                }
            }
            for (int i = 0; i < result.cols; ++i) {
                det *= result.getElement(i, i);
            }
        }
        return det;
    }

    public int Minor(int i, int j, Matrix arr) {
        Matrix current = new Matrix(arr.rows - 1, arr.cols - 1);
        int k, m;
        for (k = 0; k < i; ++k)
            for (m = 0; m < j; ++m)
                current.setElement(k, m, arr.getElement(k, m));
        for (k = i; k < arr.rows - 1; ++k)
            for (m = j; m < arr.cols - 1; ++m)
                current.setElement(k, m, arr.getElement(k + 1, m + 1));
        for (k = 0; k < i; ++k)
            for (m = j; m < arr.cols - 1; ++m)
                current.setElement(k, m, arr.getElement(k, m + 1));
        for (k = i; k < arr.rows - 1; ++k)
            for (m = 0; m < j; ++m)
                current.setElement(k, m, arr.getElement(k + 1, m));
        return current.Determinant();
    }

    public void InverseMatrix(int det) {
        if (this.cols != this.rows)
            System.out.println("Матрица не квадратная, поэтому обратить её нельзя");
        else {
            Matrix inverseMatrix = new Matrix(this.rows, this.cols);
            int n = this.rows, minor;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    minor = Minor(i, j, this);
                    if ((i + j) % 2 != 0) {
                        minor *= -1;
                    }
                    inverseMatrix.setElement(i, j, minor);
                }
            inverseMatrix.TranspositionForInverse();
            inverseMatrix.DivisionBy(det);
            inverseMatrix.Display();
            //inverseMatrix.Multiplication(this).Display();
        }
    }
}
