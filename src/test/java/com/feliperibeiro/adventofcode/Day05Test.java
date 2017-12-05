package com.feliperibeiro.adventofcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day05Test {

  @Test
  public void testPart1() {
    assertEquals(5, Day05.part1(new Integer[]{0, 3, 0, 1, -3}));
  }

  @Test
  public void testPart2() {
    assertEquals(10, Day05.part2(new Integer[]{0, 3, 0, 1, -3}));
  }
}