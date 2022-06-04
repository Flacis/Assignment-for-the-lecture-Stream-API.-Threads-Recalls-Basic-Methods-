package homework;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Class Main");
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Set<Integer> list = new TreeSet<>();
        for (Integer number : intList) {
            boolean x = number > 0 && number % 2 == 0;
            if (x) {
                list.add(number);
            }
        }
        for (int number : list) System.out.print(number + " ");
        System.out.println();
        new StreamMain();
    }
}
