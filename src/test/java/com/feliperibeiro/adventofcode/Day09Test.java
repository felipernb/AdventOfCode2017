package com.feliperibeiro.adventofcode;

import org.junit.Test;

import static com.feliperibeiro.adventofcode.Day09.garbageChars;
import static com.feliperibeiro.adventofcode.Day09.part1;
import static com.feliperibeiro.adventofcode.Day09.sanitize;
import static org.junit.Assert.assertEquals;

public class Day09Test {

  @Test
  public void testPart1() {
    assertEquals(1, part1("{}"));
    assertEquals(6, part1("{{{}}}"));
    assertEquals(5, part1("{{},{}}"));
    assertEquals(16, part1("{{{},{},{{}}}}"));
    assertEquals(1, part1("{<a>,<a>,<a>,<a>}"));
    assertEquals(9, part1("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
    assertEquals(9, part1("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
    assertEquals(3, part1("{{<a!>},{<a!>},{<a!>},{<ab>}}"));
  }

  @Test
  public void testSanitize() {
    assertEquals("{}", sanitize("{}"));
    assertEquals("{{{}}}", sanitize("{{{}}}"));
    assertEquals("{{},{}}", sanitize("{{},{}}"));
    assertEquals("{{{},{},{{}}}}", sanitize("{{{},{},{{}}}}"));
    assertEquals("{,,,}", sanitize("{<a>,<a>,<a>,<a>}"));
    assertEquals("{{},{},{},{}}", sanitize("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
    assertEquals("{{},{},{},{}}", sanitize("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
    assertEquals("{{}}", sanitize("{{<a!>},{<a!>},{<a!>},{<ab>}}"));
  }

  @Test
  public void testGarbageChars() {
    assertEquals(0, garbageChars("<>"));
    assertEquals(17, garbageChars("<random characters>"));
    assertEquals(3, garbageChars("<<<<>"));
    assertEquals(2, garbageChars("<{!>}>"));
    assertEquals(0, garbageChars("<!!>"));
    assertEquals(0, garbageChars("<!!!>>"));
    assertEquals(10, garbageChars("<{o\"i!a,<{i<a>"));
  }
}