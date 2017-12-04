package com.feliperibeiro.adventofcode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class Day03Test {

  @Test
  public void testGridSize() {
    assertEquals(1, Day03.gridSize(1));
    for (int i = 2; i < 10; i++) {
      assertEquals(3, Day03.gridSize(i));
    }

    for (int i = 10; i < 26; i++) {
      assertEquals(5, Day03.gridSize(i));
    }

    for (int i = 26; i < 50; i++) {
      assertEquals(7, Day03.gridSize(i));
    }
  }

  @Test
  public void testPos() {
    assertArrayEquals(new int[] {0, 0}, Day03.pos(1));

    assertArrayEquals(new int[] {1, 2}, Day03.pos(2));
    assertArrayEquals(new int[] {0, 2}, Day03.pos(3));
    assertArrayEquals(new int[] {0, 1}, Day03.pos(4));
    assertArrayEquals(new int[] {0, 0}, Day03.pos(5));
    assertArrayEquals(new int[] {1, 0}, Day03.pos(6));
    assertArrayEquals(new int[] {2, 0}, Day03.pos(7));
    assertArrayEquals(new int[] {2, 1}, Day03.pos(8));
    assertArrayEquals(new int[] {2, 2}, Day03.pos(9));

    assertArrayEquals(new int[]{0, 0}, Day03.pos(17));
    assertArrayEquals(new int[]{0, 1}, Day03.pos(16));
    assertArrayEquals(new int[]{0, 2}, Day03.pos(15));
    assertArrayEquals(new int[]{0, 3}, Day03.pos(14));
    assertArrayEquals(new int[]{0, 4}, Day03.pos(13));
    assertArrayEquals(new int[]{1, 4}, Day03.pos(12));
    assertArrayEquals(new int[]{2, 4}, Day03.pos(11));
    assertArrayEquals(new int[]{3, 4}, Day03.pos(10));
    assertArrayEquals(new int[]{4, 4}, Day03.pos(25));
    assertArrayEquals(new int[]{4, 3}, Day03.pos(24));
    assertArrayEquals(new int[]{4, 2}, Day03.pos(23));
    assertArrayEquals(new int[]{4, 1}, Day03.pos(22));
    assertArrayEquals(new int[]{4, 0}, Day03.pos(21));
    assertArrayEquals(new int[]{3, 0}, Day03.pos(20));
    assertArrayEquals(new int[]{2, 0}, Day03.pos(19));
    assertArrayEquals(new int[]{1, 0}, Day03.pos(18));
  }

  @Test
  public void testPart1() {
    assertEquals(0, Day03.part1(1));
    assertEquals(3, Day03.part1(12));
    assertEquals(2, Day03.part1(23));
    assertEquals(31, Day03.part1(1024));
  }

  @Test
  public void testPart2() {
    assertEquals(2, Day03.part2(1));
    assertEquals(4, Day03.part2(2));
    assertEquals(4, Day03.part2(3));
    assertEquals(5, Day03.part2(4));
    assertEquals(10, Day03.part2(5));
    assertEquals(10, Day03.part2(6));
    assertEquals(10, Day03.part2(7));
    assertEquals(10, Day03.part2(8));
    assertEquals(10, Day03.part2(9));
    assertEquals(11, Day03.part2(10));
    assertEquals(23, Day03.part2(11));
    assertEquals(23, Day03.part2(12));
    assertEquals(23, Day03.part2(13));
    assertEquals(23, Day03.part2(14));
    assertEquals(23, Day03.part2(15));
    assertEquals(23, Day03.part2(16));
    assertEquals(23, Day03.part2(17));
    assertEquals(23, Day03.part2(18));
    assertEquals(23, Day03.part2(19));
    assertEquals(23, Day03.part2(20));
    assertEquals(23, Day03.part2(21));
    assertEquals(23, Day03.part2(22));
    assertEquals(25, Day03.part2(23));
  }

}