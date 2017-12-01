package com.feliperibeiro.adventofcode;

/**
 * Created by felipe on 01-12-2017.
 */
public class Day01 {
  static long part1(final String s) {
    return sumWithDistance(s, 1);
  }

  static long part2(final String s) {
    return sumWithDistance(s, s.length() / 2);
  }

  private static long sumWithDistance(final String s, final int distance) {
    long sum = 0;
    final int length = s.length();
    char c;
    char matchingC;
    for (int i = 0; i < length; i++) {
      c = s.charAt(i);
      matchingC = s.charAt((i + distance) % length);
      if (c == matchingC) sum += Character.getNumericValue(c);
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(part2(args[0]));
  }
}
