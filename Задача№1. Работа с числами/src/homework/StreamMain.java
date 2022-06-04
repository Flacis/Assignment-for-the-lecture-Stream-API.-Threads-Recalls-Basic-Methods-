package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMain {
    public StreamMain() {
        System.out.println("Class StreamMain");
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        intList.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(x -> System.out.print(x + " "));
    }
}
