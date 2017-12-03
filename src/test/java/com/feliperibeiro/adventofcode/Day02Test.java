package com.feliperibeiro.adventofcode;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Day02Test {

  @Test
  public void testPart1() {
    assertEquals(18, Day02.part1("5 1 9 5\n"
                                 + "7 5 3\n"
                                 + "2 4 6 8\n"
    ));
  }

  @Test
  public void testPart2() {
    assertEquals(9, Day02.part2("5 9 2 8\n"
                                + "9 4 7 3\n"
                                + "3 8 6 5"));
  }

  @Test
  public void testParseInput() {
    Integer[][] parsedInput = Day02.parseInput("5 1 9 5\n"
                                               + "7 5 3\n"
                                               + "2 4 6 8\n");
    assertTrue(Arrays.deepEquals(new Integer[][]{
        {5, 1, 9, 5},
        {7, 5, 3},
        {2, 4, 6, 8}
    }, parsedInput));
  }

  @Test
  public void testDiffMinMax() {
    assertEquals(8, Day02.diffMaxMin(new Integer[]{5, 1, 9, 5}));
    assertEquals(4, Day02.diffMaxMin(new Integer[]{7, 5, 3}));
    assertEquals(6, Day02.diffMaxMin(new Integer[]{2, 4, 6, 8}));
  }

  @Test
  public void testEvenDivision() {
    assertEquals(4, Day02.evenDivision(new Integer[]{5, 9, 2, 8}));
    assertEquals(3, Day02.evenDivision(new Integer[]{9, 4, 7, 3}));
    assertEquals(2, Day02.evenDivision(new Integer[]{3, 8, 6, 5}));
  }
}