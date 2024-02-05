import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Reader {
    private final File file;

    public Reader(File file) {
        this.file = file;
    }

    public ArrayList<ArrayList<Fraction>> readMatrixFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return bufferedReader.lines()
                    .map(line -> Arrays.stream(line.split(" "))
                            .map(x -> new Fraction(Integer.parseInt(x), 1))
                            .collect(Collectors.toCollection(ArrayList::new)))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод матрицы.");
        }
        return null;
    }

}
