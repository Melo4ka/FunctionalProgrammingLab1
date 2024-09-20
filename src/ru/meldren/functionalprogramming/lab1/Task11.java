package ru.meldren.functionalprogramming.lab1;

public class Task11 {

    private static final int[][] DIRS = {
            {1, 0},
            {0, 1},
            {1, 1},
            {1, -1}
    };

    int maxProduct(int[][] grid) {
        int max = -1;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                for (int[] dir : DIRS) {
                    max = Math.max(product(grid, x, y, dir[0], dir[1]), max);
                }
            }
        }
        return max;
    }

    private int product(int[][] grid, int x, int y, int dx, int dy) {
        if (!isValid(grid, x + 3 * dx, y + 3 * dy)) {
            return -1;
        }
        int prod = 1;
        for (int i = 0; i < 4; i++, x += dx, y += dy) {
            prod *= grid[y][x];
        }
        return prod;
    }


    private static boolean isValid(int[][] grid, int x, int y) {
        return 0 <= y && y < grid.length && 0 <= x && x < grid[y].length;
    }
}
