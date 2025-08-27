/**
 * Copyright 2025 Suraj Muraleedharan
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smuralee.graph;

/**
 * Given an m x n 2D binary grid which represents a map of 'L's (land) and 'W's (water), return the
 * number of islands.
 *
 * <p>An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 */

/**
 * Grid class represents a 2D grid for island counting problem. Encapsulates grid operations and
 * boundary checking.
 */
class Grid {
  private final char[][] grid;
  private final int rows;
  private final int cols;

  /**
   * Constructor initializes grid with given 2D array. Time Complexity: O(1) Space Complexity: O(1)
   * - only stores references
   */
  public Grid(char[][] grid) {
    this.grid = grid;
    this.rows = grid.length;
    this.cols = grid[0].length;
  }

  /** Checks if given position contains land ('L'). Time Complexity: O(1) Space Complexity: O(1) */
  public boolean isLand(int row, int col) {
    return isValid(row, col) && grid[row][col] == 'L';
  }

  /**
   * Marks visited land as water ('W') to avoid revisiting. Time Complexity: O(1) Space Complexity:
   * O(1)
   */
  public void markVisited(int row, int col) {
    if (isValid(row, col)) grid[row][col] = 'W';
  }

  /**
   * Validates if coordinates are within grid boundaries. Time Complexity: O(1) Space Complexity:
   * O(1)
   */
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

/**
 * IslandExplorer performs DFS traversal to explore connected land cells. Uses flood-fill algorithm
 * to mark entire island as visited.
 */
record IslandExplorer(Grid grid) {

  /**
   * Recursively explores island using DFS in 4 directions. Marks visited cells to prevent counting
   * same island multiple times. Time Complexity: O(1) per call, O(m*n) worst case for single island
   * Space Complexity: O(m*n) worst case due to recursion stack depth
   */
  public void exploreIsland(int row, int col) {
    // Base case: invalid position or already visited/water
    if (!grid.isLand(row, col)) return;

    // Mark current cell as visited
    grid.markVisited(row, col);

    // Explore all 4 adjacent directions (down, up, right, left)
    exploreIsland(row + 1, col);
    exploreIsland(row - 1, col);
    exploreIsland(row, col + 1);
    exploreIsland(row, col - 1);
  }
}

/**
 * IslandCounter counts number of distinct islands in 2D grid. Islands are connected land cells
 * ('L') surrounded by water ('W').
 */
public class IslandCounter {
  /**
   * Counts total number of islands using DFS approach. Time Complexity: O(m*n) where m=rows, n=cols
   * - visits each cell once Space Complexity: O(m*n) worst case for recursion stack (single
   * snake-like island)
   */
  public int numIslands(char[][] gridArray) {
    Grid grid = new Grid(gridArray);
    IslandExplorer explorer = new IslandExplorer(grid);
    int count = 0;

    // Iterate through every cell in grid
    for (int i = 0; i < grid.getRows(); i++) {
      for (int j = 0; j < grid.getCols(); j++) {
        // When land found, explore entire island and increment counter
        if (grid.isLand(i, j)) {
          explorer.exploreIsland(i, j); // Marks entire island as visited
          count++;
        }
      }
    }
    return count;
  }
}
