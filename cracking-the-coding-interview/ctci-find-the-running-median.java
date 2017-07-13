import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static float getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    if (lowers.size() == highers.size()) {
      return ((float) (lowers.peek() + highers.peek()) ) / 2.0f;
    } else if (lowers.size() > highers.size()) {
      return lowers.peek();
    } else {
      return highers.peek();
    }
  }

  public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    if (lowers.size() != highers.size()) {
      PriorityQueue biggerHeap = lowers.size() > highers.size() ? lowers : highers;
      PriorityQueue smallerHeap = lowers.size() < highers.size() ? lowers : highers;

      if ((biggerHeap.size() - smallerHeap.size()) >= 2) {
        smallerHeap.add(biggerHeap.poll());
      }
    }
  }

  public static void addElement(int data, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    if (lowers.size() == 0 || data < lowers.peek()) {
      lowers.add(data);
    } else {
      highers.add(data);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    PriorityQueue lowers = new PriorityQueue<Integer>((a, b)->b-a);
    PriorityQueue highers = new PriorityQueue<Integer>();
    for(int a_i=0; a_i < n; a_i++){
      int data = in.nextInt();
      addElement(data, lowers, highers);
      rebalance(lowers, highers);
      System.out.println(getMedian(lowers, highers));
    }
  }
}
