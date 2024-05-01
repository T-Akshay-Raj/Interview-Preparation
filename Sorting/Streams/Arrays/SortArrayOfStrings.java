package Java8.StreamsApi.SortingExample.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayOfStrings {
  public static void main(String[] args) {
    String[] arr = {"CD", "AB", "BC", "AA", "CD", "aa"};
    System.out.println(
        "Sort array of strings using streams and sorted method");//AA AB BC CD CD aa
    sortArray(arr);
    System.out.println(
        "Sort array of strings using streams and sorted method in reverse Order"); //aa CD CD BC AB AA
    sortArrayReverse(arr);

    System.out.println(
        "Sort array of strings using comparable and streams");//AA AB BC CD CD aa
    sortArrayUsingComparable(arr);
    System.out.println(
        "Sort array of strings using comparable and streams in reverse order"); //aa CD CD BC AB AA
    sortArrayUsingComparableReverse(arr);

    System.out.println(
        "Sort array of strings using comparator and streams");//AA AB BC CD CD aa
    sortArrayUsingComparator(arr);
    System.out.println(
        "Sort array of strings using comparator and streams in reverse order");//aa CD CD BC AB AA
    sortArrayUsingComparatorReverse(arr);

    System.out.println(
        "Sort array of strings using comparator and streams case insensitive");//AA aa AB BC CD CD
    sortArrayUsingComparatorCaseInsensitive(arr);
    System.out.println(
        "Sort array of strings using comparator and streams case insensitive in reverse order");//aa CD CD BC AB AA
    sortArrayUsingComparatorCaseInsensitiveReverse(arr);

    System.out.println(
        "Sort array of strings using comparator and streams ");//AA AB BC CD CD aa
    sortArrayUsingComparator2(arr);
    System.out.println(
        "Sort array of strings using comparator and streams in reverse order ");//aa CD CD BC AB AA
    sortArrayUsingComparator2Reversed(arr);

  }


  private static void sortArray(String[] arr) {
    Arrays.stream(arr).sorted().forEach(System.out::println);
  }

  private static void sortArrayReverse(String[] arr) {
    Arrays.stream(arr).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
  }

  private static void sortArrayUsingComparable(String[] arr) {
    Arrays.stream(arr).sorted((a, b) -> a.compareTo(b))
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparableReverse(String[] arr) {
    Arrays.stream(arr).sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparator(String[] arr) {
    Arrays.stream(arr).sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparatorReverse(String[] arr) {
    Arrays.stream(arr).sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparatorCaseInsensitive(String[] arr) {
    Arrays.stream(arr).sorted(String.CASE_INSENSITIVE_ORDER)
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparatorCaseInsensitiveReverse(
      String[] arr) {
    Arrays.stream(arr).sorted(String.CASE_INSENSITIVE_ORDER.reversed())
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparator2(String[] arr) {
    Arrays.stream(arr).sorted(Comparator.comparing(a -> a))
        .forEach(System.out::println);
  }

  private static void sortArrayUsingComparator2Reversed(String[] arr) {
    Arrays.stream(arr)
        .sorted(Comparator.comparing(s -> s.toString()).reversed())
        .forEach(System.out::println);
  }


}
