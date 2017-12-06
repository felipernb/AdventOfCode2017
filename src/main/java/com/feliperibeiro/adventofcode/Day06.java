package com.feliperibeiro.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day06 {

  static int part1(Integer[] bank) {
    Set<String> s = new HashSet<>();
    String a;
    while (!s.contains((a = Arrays.toString(bank)))) {
      s.add(a);
      redistribute(bank);
    }
    return s.size();
  }

  static int part2(Integer[] bank) {
    Map<String, Integer> s = new HashMap<>();
    String a;
    int i = 0;
    while (!s.containsKey((a = Arrays.toString(bank)))) {
      s.put(a, i++);
      redistribute(bank);
    }
    return i - s.get(a);
  }

  private static void redistribute(final Integer[] bank) {
    int maxIndex = 0;

    for (int i = 1; i < bank.length; i++) {
      if (bank[i] > bank[maxIndex]) {
        maxIndex = i;
      }
    }
    int distribute = bank[maxIndex];
    bank[maxIndex] = 0;
    for (int i = 1; i <= distribute; i++) {
      final int index = (maxIndex + i) % bank.length;
      bank[index]++;
    }
  }

  private static Integer[] parseInput() {
    Scanner in = new Scanner(System.in);
    List<Integer> l = new ArrayList<>();
    while (in.hasNextInt()) {
      l.add(in.nextInt());
    }
    Integer[] a = new Integer[l.size()];
    return l.toArray(a);
  }

  public static void main(String[] args) {
    System.out.println(part2(parseInput()));

  }

}
