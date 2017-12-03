package com.feliperibeiro.adventofcode;

import java.util.Arrays;
import java.util.Scanner;

public class Day02 {

  public static long part1(final String input) {
    final Integer[][] spreadsheet = parseInput(input);
    return
        Arrays.stream(spreadsheet)
            .map(Day02::diffMaxMin)
            .reduce(0, Integer::sum);
  }

  public static long part2(final String input) {
    final Integer[][] spreadsheet = parseInput(input);
    return
        Arrays.stream(spreadsheet)
            .map(Day02::evenDivision)
            .reduce(0, Integer::sum);
  }

  static int evenDivision(final Integer[] row) {
    for (int i = 0; i < row.length; i++) {
      for (int j = i + 1; j < row.length; j++) {
        int max = Integer.max(row[i], row[j]);
        int min = Integer.min(row[i], row[j]);
        if (max % min == 0) {
          return max / min;
        }
      }
    }

    return 0;
  }

  static int diffMaxMin(final Integer[] row) {
    int min = Arrays.stream(row).reduce(Integer.MAX_VALUE, Integer::min);
    int max = Arrays.stream(row).reduce(Integer.MIN_VALUE, Integer::max);
    return max - min;
  }

  static Integer[][] parseInput(final String input) {
    return Arrays.stream(input.split("\n"))
        .map(r ->
                 Arrays.stream(r.split("\\s+"))
                     .map(Integer::parseInt)
                     .toArray(Integer[]::new)
        )
        .toArray(Integer[][]::new);
  }

  public static void main(final String[] args) {
    Scanner in = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while (in.hasNextLine()) {
      sb.append(in.nextLine());
      sb.append("\n");
    }
    System.out.println(part2(sb.toString().trim()));
  }
}
