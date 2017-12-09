package com.feliperibeiro.adventofcode;

import java.util.Scanner;
import java.util.Stack;

public class Day09 {

  static int part1(String s) {
    String cleanString = sanitize(s);
    Stack<Integer> groups = new Stack<>();
    int sum = 0;
    int level = 1;
    for (char c : cleanString.toCharArray()) {
      if (c == '{') {
        groups.push(level++);
      } else if (c == '}') {
        sum += groups.pop();
        level--;
      }
    }
    return sum;
  }

  static String sanitize(final String s) {
    return sanitizeAndCount(s).cleanString;
  }

  static int garbageChars(final String s) {
    return sanitizeAndCount(s).countGarbageChars;
  }

  private static SanitizedString sanitizeAndCount(final String s) {
    StringBuilder sb = new StringBuilder();
    boolean insideGarbage = false;
    boolean ignoreNext = false;
    int countGarbageChars = 0;
    for (char c : s.toCharArray()) {
      if (ignoreNext) {
        ignoreNext = false;
      } else if (c == '!') {
        ignoreNext = true;
      } else if (insideGarbage) {
        if (c == '>') {
          insideGarbage = false;
        } else {
          countGarbageChars++;
        }
      } else if (c == '<') {
        insideGarbage = true;
      } else {
        sb.append(c);
      }
    }
    return new SanitizedString(sb.toString(), countGarbageChars);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(garbageChars(in.nextLine()));
  }

  private static class SanitizedString {

    private final String cleanString;
    private final int countGarbageChars;

    public SanitizedString(final String cleanString,
                           final int countGarbageChars) {
      this.cleanString = cleanString;
      this.countGarbageChars = countGarbageChars;
    }
  }
}
