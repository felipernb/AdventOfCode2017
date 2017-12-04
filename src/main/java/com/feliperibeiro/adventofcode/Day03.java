package com.feliperibeiro.adventofcode;

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
      switch(dir) {
        case UP:
          if (--y == 0) dir = Direction.LEFT;
          break;
        case DOWN:
          if (++y == size - 1) dir = Direction.RIGHT;
          break;
        case LEFT:
          if (--x == 0) dir = Direction.DOWN;
          break;
        case RIGHT:
          if (++x == size - 1) dir = Direction.UP;
          break;
      }
    }
    return new int[]{x, y};
  }

  static int gridSize(final int i) {
    final int ceilSqrt = (int) Math.ceil(Math.sqrt(i));
    return ceilSqrt + (ceilSqrt % 2 == 1 ? 0 : 1);
  }

  static int sumAdj(int[][] grid, int row, int col) {
    int sum = 0;
    for (int i = Math.max(row - 1, 0); i < Math.min( row + 1, grid.length - 1); i++) {
      for (int j = Math.max(col - 1, 0); j < Math.min(col + 1, grid.length - 1 ); j++) {
        sum += grid[i][j];
      }
    }
    return sum;
  }


  static int part2(final int n) {
    // TODO: IMPLEMENT ME!
    return 0;
  }

  public static void main(String args[]) {
    for (String s: args) {
      System.out.println(s + ": " + part1(Integer.parseInt(s)));
    }
  }
}
