package com.feliperibeiro.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day05 {

  static int part1(Integer[] steps) {
    int index = 0;
    int count = 0;
    while (index >= 0 && index < steps.length) {
      index += steps[index]++;
      count++;
    }
    return count;
  }

  public static int part2(final Integer[] steps) {
    int index = 0;
    int count = 0;
    while (index >= 0 && index < steps.length) {
      final int offset = steps[index];
      steps[index] += (offset >= 3 ? -1 : 1);
      index += offset;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Integer> l = new ArrayList<>();
    while (in.hasNextInt()) {
      l.add(in.nextInt());
    }
    Integer[] steps = new Integer[l.size()];
    System.out.println(part2(l.toArray(steps)));
  }
}

