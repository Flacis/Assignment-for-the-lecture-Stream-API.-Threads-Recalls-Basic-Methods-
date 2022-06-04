package homework;

import java.util.*;
import java.util.stream.Collectors;

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

        List<String> familiesList = persons.stream()
                .filter(Random -> Random.getAge(100) > 17)
                .filter(Random -> Random.getAge(100) < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(familiesList + "Призывники");

        System.out.println("Мужчины");
        persons.stream()
                .filter(Random -> Random.getAge(100) > 17)
                .filter(Random -> Random.getAge(100) < 65)
                .filter(Sex -> Sex.getSex() == homework.Sex.MAN)
                .filter(Education -> Education.getEducation() == HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .sorted(Comparator.comparing(Person::getSex))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Женщины");
        persons.stream()
                .filter(Random -> Random.getAge(100) > 17)
                .filter(Random -> Random.getAge(100) < 60)
                .filter(Sex -> Sex.getSex() == homework.Sex.WOMAN)
                .filter(Education -> Education.getEducation() == HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .sorted(Comparator.comparing(Person::getSex))
                .forEach(System.out::println);
        System.out.println();
    }
}