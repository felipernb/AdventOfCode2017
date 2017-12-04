package com.feliperibeiro.adventofcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day04Test {

  @Test
  public void testIsValidPassphrase() {
    assertTrue(Day04.isValidPassphrase("aa bb cc dd ee"));
    assertFalse(Day04.isValidPassphrase("aa bb cc dd aa"));
    assertTrue(Day04.isValidPassphrase("aa bb cc dd aaa"));
  }

  @Test
  public void testIsValidPassphrasePart2() {
    assertTrue(Day04.isValidPassphrasePart2("abcde fghij"));
    assertFalse(Day04.isValidPassphrasePart2("abcde xyz ecdab"));
    assertTrue(Day04.isValidPassphrasePart2("a ab abc abd abf abj"));
    assertTrue(Day04.isValidPassphrasePart2("iiii oiii ooii oooi oooo"));
    assertFalse(Day04.isValidPassphrasePart2("oiii ioii iioi iiio"));
  }
}