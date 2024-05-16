package Java8.StreamsApi.SortingExample.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayIntegers {
  public static void main(String[] args) {
    int[] arr = {2,5,7,9,6,8,1,3,4,10};
    System.out.println("Sort array using streams and sorted method");
    sortArray(arr);
    System.out.println("Sort array using streams and sorted method in reverse Order");
    sortArrayReverse(arr);

    System.out.println("Sort array using comparable and streams");
    sortArrayUsingComparable(arr);
    System.out.println("Sort array using comparable and streams in reverse order");
    sortArrayUsingComparableReverse(arr);

    System.out.println("Sort array using comparator and streams");
    sortArrayUsingComparator(arr);
    System.out.println("Sort array using comparator and streams in reverse order");
    sortArrayUsingComparatorReverse(arr);

    System.out.println("Sort array using comparator and streams ");
    sortArrayUsingComparator(arr);
    System.out.println("Sort array using comparator, streams and Reversed ");
    sortArrayUsingComparatorReverse(arr);

    System.out.println("Sort array using comparator and streams ");
    sortArrayUsingComparator(arr);
    System.out.println("Sort array using comparator and streams in reverse order ");
    sortArrayUsingComparatorReverse(arr);


  }

  //sort using streams
  private static void sortArray(int[] arr) {
    Arrays.stream(arr).sorted().forEach(System.out::println);
  }

  //sort in reverse order using streams
  private static void sortArrayReverse(int[] arr) {
    Arrays.stream(arr).boxed().sorted((a, b) -> b - a)
        .forEach(System.out::println);
  }

  //sort using comparable and streams
  private static void sortArrayUsingComparable(int[] arr) {
    Arrays.stream(arr).boxed().sorted((a, b) -> a.compareTo(b))
        .forEach(System.out::println);
  }

  //sort using comparable and streams in reverseOrder
  private static void sortArrayUsingComparableReverse(int[] arr) {
    Arrays.stream(arr).boxed().sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);
  }


  //sort using comparator and streams
  private static void sortArrayUsingComparator(int[] arr) {
    Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(a -> a))
        .forEach(System.out::println);
  }

  //sort using comparator and reversed Order
  private static void sortArrayUsingComparatorReverse(int[] arr) {
    Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(a -> (int) a).reversed())
        .forEach(System.out::println);
  }

  // //sort using comparator and streams and natural Order
  private static void sortArrayUsingComparator1(int[] arr) {
    Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
  }

  //sort using comparator and reverse Order
  private static void sortArrayUsingComparatorReverse1(int[] arr) {
    Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
  }


}
