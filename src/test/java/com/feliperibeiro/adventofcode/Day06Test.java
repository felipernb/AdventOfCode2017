package com.feliperibeiro.adventofcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day06Test {
  @Test
  public void testPart1() {
    assertEquals(5, Day06.part1(new Integer[]{0, 2, 7, 0}));
  }

  @Test
  public void testPart2() {
    assertEquals(4, Day06.part2(new Integer[]{0, 2, 7, 0}));
  }
}