package com.feliperibeiro.adventofcode;

import java.util.Arrays;

public class Day03 {

  public static int part1(final int i) {
    int middle = (int) Math.ceil(gridSize(i) / 2);
    int[] p = pos(i);
    return Math.abs(p[0] - middle) + Math.abs(p[1] - middle);
  }

  enum Direction {
    UP, DOWN, LEFT, RIGHT;
  }

  static int[] pos(final int n) {
    final int size = gridSize(n);
    int y = size - 1;
    int x = size - 1;
    Direction dir = Direction.UP;

    for (int i = size * size; i > n; i--) {
      switch (dir) {
        case UP:
          if (--y == 0) {
            dir = Direction.LEFT;
          }
          break;
        case DOWN:
          if (++y == size - 1) {
            dir = Direction.RIGHT;
          }
          break;
        case LEFT:
          if (--x == 0) {
            dir = Direction.DOWN;
          }
          break;
        case RIGHT:
          if (++x == size - 1) {
            dir = Direction.UP;
          }
          break;
      }
    }
    return new int[]{x, y};
  }

  static int gridSize(final int i) {
    final int ceilSqrt = (int) Math.ceil(Math.sqrt(i));
    return ceilSqrt + (ceilSqrt % 2 == 1 ? 0 : 1);
  }

  static int part2(final int n) {
    final int sz = 1000;
    final int[] dr = new int[]{0, -1, 0, 1};
    final int[] dc = new int[]{1, 0, -1, 0};

    int grid[][] = new int[sz][sz];

    int row = sz / 2;
    int col = sz / 2;

    grid[row][col] = 1;

    int dir = 0;
    for (int steps = 1; steps < sz; steps++) {
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < steps; j++) {

          row += dr[dir];
          col += dc[dir];

          grid[row][col] =
              grid[row + 1][col] + grid[row][col + 1] +
              grid[row - 1][col] + grid[row][col - 1] +
              grid[row - 1][col - 1] + grid[row - 1][col + 1] +
              grid[row + 1][col - 1] + grid[row + 1][col + 1];

          if (grid[row][col] > n) {
            return grid[row][col];
          }
        }
        dir = (dir + 1) % 4;
      }
    }
    return 0;
  }

  public static void main(String args[]) {
    for (String s : args) {
      System.out.println(s + ": " + part2(Integer.parseInt(s)));
    }
  }
}
