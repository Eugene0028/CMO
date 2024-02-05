import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class JordanGauss {

    public static void printMatrix(ArrayList<ArrayList<Fraction>> matrix)
    {
        for (ArrayList<Fraction> row : matrix) {
            for (Fraction element : row) {
                System.out.printf("%15s", element.toString());
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void jordanGaussMethod(ArrayList<ArrayList<Fraction>> matrix) {
        for (int c = 0; c < matrix.size(); c++) {
            int index = c;
            for (int i = c + 1; i < matrix.size(); i++) {
                if (matrix.get(index).get(c).getAbs().lessThan(matrix.get(i).get(c).getAbs())) {
                    index = i;
                }
            }

            if (index != c) {
                ArrayList<Fraction> temp = matrix.get(index);
                matrix.set(index, matrix.get(c));
                matrix.set(c, temp);
                System.out.println("СВАП НА МАКСИМАЛЬНЫЙ");
                printMatrix(matrix);
            }

            if (matrix.get(c).get(c).getNumerator() == 0) continue;

            if (matrix.get(c).get(c).getNumerator() != matrix.get(c).get(c).getDenominator()) {
                ArrayList<Fraction> row = matrix.get(c);
                ArrayList<Fraction> normalizedRow = new ArrayList<>();
                for (Fraction element : row) {
                    normalizedRow.add(element.divide(matrix.get(c).get(c)));
                }
                matrix.set(c, normalizedRow);
                printMatrix(matrix);
            }

            for (int i = 0; i < matrix.size(); i++) {
                if (matrix.get(c).get(c).getNumerator() == 0) continue;
                if (i == c) continue;

                Fraction coefficient = matrix.get(i).get(c).multiply(new Fraction(-1, 1));


                for (int j = c; j < matrix.getFirst().size(); j++) {
                    Fraction updatedElement = matrix.get(i).get(j).add(matrix.get(c).get(j).multiply(coefficient));
                    matrix.get(i).set(j, updatedElement);
                }
            }
            printMatrix(matrix);
        }

        int noNullStr = 0;
        for (ArrayList<Fraction> row : matrix) {
            boolean flag = true;
            for (int j = 0; j < row.size() - 1; j++) {
                if (row.get(j).getNumerator() != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && row.getLast().getNumerator() != 0) {
                noNullStr = 0;
                break;
            } else if (flag && row.getLast().getNumerator() == 0) {
                continue;
            }
            noNullStr++;
        }

        System.out.println("Ответ:");
        if (noNullStr == 0) {
            System.out.println("нет решения");
        } else if (noNullStr == matrix.size() && noNullStr == matrix.getFirst().size() - 1) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < matrix.size(); i++) {
                tmp.add("x" + (i + 1) + " = " + matrix.get(i).get(matrix.getFirst().size() - 1));
            }
            System.out.println(tmp);
        } else {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < matrix.size(); i++) {
                StringBuilder strBuilder = new StringBuilder();
                if (matrix.get(i).get(i).getNumerator() == matrix.get(i).get(i).getDenominator()) {
                    strBuilder.append("x").append(i + 1).append(" = ").append(matrix.get(i).get(matrix.getFirst().size() - 1));
                    for (int j = 0; j < matrix.getFirst().size() - 1; j++) {
                        if (j == i) {
                            continue;
                        }
                        if (matrix.get(i).get(j).getNumerator() != 0) {
                            strBuilder.append(" + ").append("(").append(matrix.get(i).get(j).multiply(new Fraction(-1, 1))).append(")").append("x").append(j + 1);
                        }
                    }
                    tmp.add(strBuilder.toString());
                }
            }
            tmp.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader(new File("res/input.txt"));
        ArrayList<ArrayList<Fraction>> matrix = reader.readMatrixFromFile();
        printMatrix(matrix);
        jordanGaussMethod(matrix);
    }
}