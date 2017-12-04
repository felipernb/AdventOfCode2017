package com.feliperibeiro.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day04 {

  static boolean isValidPassphrase(String passphrase) {
    Set<String> words = new HashSet<>();
    for (String s : passphrase.split(" ")) {
      if (words.contains(s)) {
        return false;
      }
      words.add(s);
    }
    return true;
  }

  static long part1(List<String> passphrases) {
    return passphrases.stream().filter(Day04::isValidPassphrase).count();
  }

  static String sortChars(String s) {
    char[] c = s.toCharArray();
    Arrays.sort(c);
    return new String(c);
  }

  static boolean isValidPassphrasePart2(String passphrase) {
    Set<String> words = new HashSet<>();
    for (String s : passphrase.split(" ")) {
      String sortedChars = sortChars(s);
      if (words.contains(sortedChars)) {
        return false;
      }
      words.add(sortedChars);
    }
    return true;
  }

  static long part2(List<String> passphrases) {
    return passphrases.stream().filter(Day04::isValidPassphrasePart2).count();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    List<String> passphrases = new ArrayList<>();
    while (in.hasNextLine()) {
      passphrases.add(in.nextLine());
    }

    System.out.println(part2(passphrases));
  }
}
