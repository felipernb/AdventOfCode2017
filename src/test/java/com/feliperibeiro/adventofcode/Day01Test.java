package com.feliperibeiro.adventofcode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by felipe on 01-12-2017.
 */
public class Day01Test {

  @Test
  public void testPart1() throws Exception {
    assertEquals(3, Day01.part1("1122"));
    assertEquals(4, Day01.part1("1111"));
    assertEquals(0, Day01.part1("1234"));
    assertEquals(9, Day01.part1("91212129"));
  }

  @Test
  public void testPart2() throws Exception {
    assertEquals(6, Day01.part2("1212"));
    assertEquals(0, Day01.part2("1221"));
    assertEquals(4, Day01.part2("123425"));
    assertEquals(12, Day01.part2("123123"));
    assertEquals(4, Day01.part2("12131415"));
  }
}
