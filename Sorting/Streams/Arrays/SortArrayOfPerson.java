package Java8.StreamsApi.SortingExample.Arrays;

import Java8.StreamsApi.model.Person;
import java.util.Arrays;
import java.util.Comparator;

public class SortArrayOfPerson {
  public static void main(String[] args) {
    Person p1 = new Person(5L, "CD");
    Person p2 = new Person(2L, "AB");
    Person p3 = new Person(3L, "BC");
    Person p4 = new Person(1L, "AA");
    Person p5 = new Person(4l, "CD");
    Person[] persons = {p1, p2, p3, p4, p5};

    System.out.println(
        "Sort array of person by name using streams and sorted method");
    sortArrayOfPersonName(persons);
    System.out.println(
        "Sort array of person by name using streams and sorted method in reverse Order");
    sortArrayOfPersonNameReverse(persons);

    System.out.println(
        "Sort array of person by id using streams and sorted method");
    sortArrayOfPersonId(persons);
    System.out.println(
        "Sort array of person by id using streams and sorted method in reverse Order");
    sortArrayOfPersonIdReverse(persons);

    System.out.println(
        "Sort array of person by name first and by id if name is same");
    sortArrayOfPerson(persons);
    System.out.println(
        "Sort array of person by name first and by id if name is same in reverse Order");
    sortArrayOfPersonReverse(persons);


  }


  //sort by name
  private static void sortArrayOfPersonName(Person[] persons) {
    Arrays.stream(persons).sorted((a, b) -> a.getName().compareTo(b.getName()))
        .forEach(System.out::println);
  }

  private static void sortArrayOfPersonNameReverse(Person[] persons) {
    Arrays.stream(persons).sorted((a, b) -> b.getName().compareTo(a.getName()))
        .forEach(System.out::println);
  }

  //sort by id
  private static void sortArrayOfPersonId(Person[] persons) {
    Arrays.stream(persons).sorted((a, b) -> a.getId().compareTo(b.getId()))
        .forEach(System.out::println);
  }

  private static void sortArrayOfPersonIdReverse(Person[] persons) {
    Arrays.stream(persons).sorted((a, b) -> b.getId().compareTo(a.getId()))
        .forEach(System.out::println);
  }

  //sort by name first and by id if name is same
  private static void sortArrayOfPerson(Person[] persons) {
    Arrays.stream(persons).sorted(
            Comparator.comparing(Person::getName).thenComparing(Person::getId))
        .forEach(System.out::println);
  }

  private static void sortArrayOfPersonReverse(Person[] persons) {
    Arrays.stream(persons).sorted(
            Comparator.comparing(Person::getName).thenComparing(Person::getId)
                .reversed())
        .forEach(System.out::println);
  }

}
