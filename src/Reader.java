import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    private final File file;

    public Reader(File file) {
        this.file = file;
    }

    public List<List<Fraction>> readMatrixFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
        {
            List<List<Fraction>> result = new ArrayList<>();

            while(bufferedReader.ready())
            {
                String[] tmp = bufferedReader.readLine().split(" ");
                List<Fraction> str = new ArrayList<>();
                for (var i : tmp)
                {
                    var z = i.split("/");
                    if (z.length == 2) str.add(new Fraction(Long.parseLong(z[0]), Long.parseLong(z[1])));
                    else str.add(new Fraction(Long.parseLong(z[0]), 1));


//                    if (i.contains("/")) {
//                        var z = i.split("/");
//                        str.add(new Fraction(Long.parseLong(z[0]), Long.parseLong(z[1])));
//                    } else {
//                        str.add(new Fraction(Long.parseLong(i), 1));
//                    }
                }
                result.add(str);
            }
            return result;


//            return bufferedReader.lines()
//                    .map(line -> Arrays.stream(line.split(" "))
//                            .map(x -> new Fraction(Integer.parseInt(x), 1))
//                            .collect(Collectors.toCollection(ArrayList::new)))
//                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод матрицы.");
        }
        return null;
    }

}
