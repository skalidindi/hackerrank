import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public class TrieNode {
      private TrieNode[] children;
      private int size;
      public final static int NUMBER_OF_CHARACTERS = 26;
      public TrieNode() {
        this.children = new TrieNode[NUMBER_OF_CHARACTERS];
        this.size = 0;
      }

      public int size() {
        return this.size;
      }

      private int getCharIndex(char c) {
        return c - 'a';
      }

      public TrieNode getNode(char c) {
        return this.children[this.getCharIndex(c)];
      }

      public TrieNode add(char c) {
        if (this.getNode(c) == null) {
          this.children[this.getCharIndex(c)] = new TrieNode();
        }
        this.getNode(c).size++;
        return this.getNode(c);
      }
    }

    public class Trie {
      private TrieNode root;

      public Trie() {
        root = new TrieNode();
      }

      public void insert(String word) {
        TrieNode t = root;
        char arr[] = word.toCharArray();
        for (char c : arr) {
          t = t.add(c);
        }
      }

      public int findPartialCount(String partial) {
        TrieNode t = searchNode(partial);
        return t != null ? t.size() : 0;
      }

      public TrieNode searchNode(String word) {
        TrieNode t = root;
        char arr[] = word.toCharArray();

        for (char c : arr) {
          TrieNode child = t.getNode(c);
          if (child == null) {
            return null;
          }
          t = child;
        }

        return t;
      }
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      Solution s = new Solution();
      Trie t = s.new Trie();

      for(int a0 = 0; a0 < n; a0++){
        String op = in.next();
        String contract = in.next();

        if (op.equals("add")) {
          t.insert(contract);
        } else if (op.equals("find")) {
          System.out.println(t.findPartialCount(contract));
        } else {
          System.out.println("Error: Invalid operation!");
        }
      }
    }
}
