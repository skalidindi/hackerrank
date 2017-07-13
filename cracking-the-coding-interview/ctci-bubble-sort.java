import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int numberOfSwaps = 0;
    int arr[] = new int[n];
    IntStream.range(0, n).forEach((i) -> {
      arr[i] = in.nextInt();
    });

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
          numberOfSwaps++;
        }
      }
    }
    System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
    System.out.println("First Element: " + arr[0]);
    System.out.println("Last Element: " + arr[n - 1]);
  }
}
