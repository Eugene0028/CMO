public class GaussJordanMethod {
        private static final double EPSILON = 1e-10; // Малое число для проверки на ноль

        public static void main(String[] args) {

            System.out.println();

            double[][] matrix = {
                    { 1, 2, 3, 5 },
                    { 4, 5, 6, 8 },
                    { 7, 8, 0, 2 }
            };

            gaussJordan(matrix); // Применяем метод Гаусса-Жордана к матрице

            printMatrix(matrix); // Выводим результат
        }

        public static void gaussJordan(double[][] matrix) {
            int rows = matrix.length; // Количество строк в матрице
            int cols = matrix[0].length; // Количество столбцов в матрице

            int lead = 0; // Переменная для отслеживания ведущей строки
            for (int r = 0; r < rows; r++) {
                if (lead >= cols) {
                    break;
                }

                int i = r;
                while (Math.abs(matrix[i][lead]) < EPSILON) {
                    i++;
                    if (i == rows) {
                        i = r;
                        lead++;
                        if (lead == cols) {
                            return;
                        }
                    }
                }

                swapRows(matrix, i, r); // Обмениваем строку с ведущей строкой
                double lv = matrix[r][lead]; // Ведущий элемент
                if (Math.abs(lv) > EPSILON && Math.abs(lv) != 1) {
                    for (int j = 0; j < cols; j++) {
                        matrix[r][j] /= lv; // Делим ведущую строку на ведущий элемент
                    }
                }

                for (int j = 0; j < rows; j++) {
                    if (j != r) {
                        double factor = matrix[j][lead]; // Множитель для обнуления других элементов
                        for (int k = 0; k < cols; k++) {
                            matrix[j][k] -= factor * matrix[r][k]; // Обнуляем другие элементы
                        }
                    }
                }

                lead++;
            }
        }

        public static void swapRows(double[][] matrix, int i, int j) {
            if (i == j) return;
            double[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

        public static void printMatrix(double[][] matrix) {
            for (double[] row : matrix) {
                for (double val : row) {
                    System.out.print(val + " "); // Выводим каждый элемент матрицы
                }
                System.out.println();
            }
        }
    }