package com.feliperibeiro.adventofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class Day08 {

  private final Map<String, Integer> registers;
  private Map<String, BiPredicate<String, Integer>> conditions;

  Day08() {
    this.registers = new HashMap<>();

    initConditions();
  }

  int getRegister(String r) {
    if (!registers.containsKey(r)) {
      registers.put(r, 0);
    }
    return registers.get(r);
  }

  void initConditions() {
    this.conditions = new HashMap<>();

    conditions.put(">", (a, b) -> getRegister(a) > b);
    conditions.put(">=", (a, b) -> getRegister(a) >= b);
    conditions.put("==", (a, b) -> getRegister(a) == b);
    conditions.put("<", (a, b) -> getRegister(a) < b);
    conditions.put("<=", (a, b) -> getRegister(a) <= b);
    conditions.put("!=", (a, b) -> getRegister(a) != b);
  }

  boolean satisfiesCondition(final String op, final String a, final int b) {
    return conditions.get(op).test(a, b);
  }

  void runCommand(final String cmd, final String a, final int n) {
    int x = getRegister(a);
    if (cmd.equals("inc")) {
      x += n;
    } else {
      x -= n;
    }

    registers.put(a, x);
  }

  void evalExpression(String expression) {
    String[] tokens = expression.split(" ");
    if (satisfiesCondition(tokens[5], tokens[4], Integer.parseInt(tokens[6]))) {
      runCommand(tokens[1], tokens[0], Integer.parseInt(tokens[2]));
    }
  }

  Integer maxRegister() {
    return registers.entrySet().stream().map(Map.Entry::getValue).max(Integer::compare).get();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(part2(in));
  }

  private static Integer part1(final Scanner in) {
    Day08 day08 = new Day08();

    while (in.hasNextLine()) {
      day08.evalExpression(in.nextLine());
    }

    return day08.maxRegister();
  }
  private static Integer part2(final Scanner in) {
    Day08 day08 = new Day08();
    Integer max = null;

    while (in.hasNextLine()) {
      day08.evalExpression(in.nextLine());
      int currentMax = day08.maxRegister();
      if (max == null || currentMax > max) max = currentMax;
    }

    return max;
  }
}
