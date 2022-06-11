package homework;

import java.util.*;

import static homework.Education.HIGHER;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])

            );
        }

        long count = persons.stream()
                .filter(Random -> Random.getAge(100) < 18)
                .count();
        System.out.println("Количество несовершеннолетних " + count);

        System.out.println(" ");

        List<String> familiesList = persons.stream()
                .filter(Random -> Random.getAge(100) >= 18)
                .filter(Random -> Random.getAge(100) < 27)
                .map(Person::getFamily).toList();
        System.out.println(familiesList + " Призывники");

        System.out.println(" ");

        persons.stream()
                .filter((Random) -> Random.getAge(100) >= 18)
                .filter((Random) -> (Random.getSex() == Sex.WOMAN && Random.getAge(100) < 60) || (Random.getSex() == Sex.MAN && Random.getAge(100) < 65))
                .filter(Education -> Education.getEducation() == HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .sorted(Comparator.comparing(Person::getSex))
                .forEach(System.out::println);
    }
}
