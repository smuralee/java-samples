/**
 * Copyright 2025 Suraj Muraleedharan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smuralee.graph;

/**
 * Given an m x n 2D binary grid which represents a map of 'L's (land) and 'W's
 * (water),
 * return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

class Grid {
    private final char[][] grid;
    private final int rows;
    private final int cols;

    public Grid(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public boolean isLand(int row, int col) {
        return isValid(row, col) && grid[row][col] == 'L';
    }

    public void markVisited(int row, int col) {
        if (isValid(row, col))
            grid[row][col] = 'W';
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

record IslandExplorer(Grid grid) {

    public void exploreIsland(int row, int col) {
        if (!grid.isLand(row, col))
            return;

        grid.markVisited(row, col);
        exploreIsland(row + 1, col);
        exploreIsland(row - 1, col);
        exploreIsland(row, col + 1);
        exploreIsland(row, col - 1);
    }
}

public class IslandCounter {
    public int numIslands(char[][] gridArray) {
        Grid grid = new Grid(gridArray);
        IslandExplorer explorer = new IslandExplorer(grid);
        int count = 0;

        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                if (grid.isLand(i, j)) {
                    explorer.exploreIsland(i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
