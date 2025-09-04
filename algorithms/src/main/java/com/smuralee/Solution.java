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
package com.smuralee;

import com.smuralee.graph.Graph;
import com.smuralee.graph.Node;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  private Solution() {}

  public static Solution getInstance() {
    return Holder.INSTANCE;
  }

  /**
   * Implement binary insertion sort which reduces comparisons from O(n) to O(log n) per insertion.
   * Best for scenarios where comparisons are expensive.
   *
   * @param input the array to be sorted
   * @return a new sorted array
   */
  public int[] insertionSortWithBinarySearch(int[] input) {
    if (input == null || input.length < 2) {
      return input == null ? new int[0] : Arrays.copyOf(input, input.length);
    }

    int[] array = Arrays.copyOf(input, input.length);

    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int pos = binarySearchForInsertionSort(array, 0, i, key);

      // Shift elements to make space
      // Uses System.arraycopy() for efficient bulk shifting
      System.arraycopy(array, pos, array, pos + 1, i - pos);
      array[pos] = key;
    }

    return array;
  }

  private int binarySearchForInsertionSort(int[] arr, int left, int right, int key) {
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > key) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * Insertion sorting algorithm
   *
   * @param input the array to be sorted
   * @return a new sorted array
   */
  public final int[] insertionSort(final int[] input) {

    if (input == null || input.length == 0) {
      return new int[0]; // Return empty array instead of throwing exception
    }

    int[] arr = Arrays.copyOf(input, input.length);

    int n = arr.length;

    if (n < 2) {
      return arr;
    }

    for (int i = 1; i < n; i++) {

      // Extract the key
      int key = arr[i];

      // Early termination if already in correct position
      if (arr[i - 1] <= key) {
        continue;
      }

      int j = i - 1;

      // Check if the current > key
      // If yes, move current to the next position, towards right
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      // Move the key to the next position, towards right
      arr[j + 1] = key;
    }

    return arr;
  }

  /**
   * Merge sort algorithm
   *
   * @param input the array to be sorted
   * @return a new sorted array
   */
  public int[] mergeSort(int[] input) {
    if (input == null || input.length < 2) {
      return input == null ? new int[0] : input;
    }

    int[] arr = Arrays.copyOf(input, input.length);
    int mid = arr.length / 2;

    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
    return merge(left, right);
  }

  private int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int leftIndex = 0, rightIndex = 0, resultIndex = 0;

    while (leftIndex < left.length && rightIndex < right.length) {
      if (left[leftIndex] <= right[rightIndex]) {
        result[resultIndex++] = left[leftIndex++];
      } else {
        result[resultIndex++] = right[rightIndex++];
      }
    }

    while (leftIndex < left.length) {
      result[resultIndex++] = left[leftIndex++];
    }

    while (rightIndex < right.length) {
      result[resultIndex++] = right[rightIndex++];
    }

    return result;
  }

  private Graph graphBuilder(char[][] grid) {
    Graph graph = new Graph();
    Map<String, Node> nodeMap = new HashMap<>();

    // Create nodes for land cells and build graph
    // The nodeMap and graph is only adding the islands
    // nodeMap key is x,y and value is node, with data value as (x * row-length + y)

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          String key = i + "," + j;
          // Create node directly instead of using lambda
          Node current = nodeMap.get(key);
          if (current == null) {
            current = new Node(i * grid[0].length + j);
            nodeMap.put(key, current);
          }
          graph.addVertex(current);

          // Add edges to already processed neighbors
          for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
              String neighbourKey = x + "," + y;
              Node neighbour = nodeMap.get(neighbourKey);
              if (neighbour != null) { // Only connect if neighbor was already processed
                graph.addEdge(current, neighbour);
              }
            }
          }
        }
      }
    }

    return graph;
  }

  /**
   * <b>Problem:</b> Number of Islands using DFS
   *
   * <p>Given a 2D grid of '1's (land) and '0's (water), count the number of islands. An island is
   * surrounded by water and formed by connecting adjacent lands horizontally or vertically. <br>
   * <b>Example:</b> <br>
   *
   * <p><b>Input:</b> <br>
   * 1 1 0 0 0 <br>
   * 1 1 0 0 0 <br>
   * 0 0 1 0 0 <br>
   * 0 0 0 1 1 <br>
   *
   * <p><b>Output:</b> 3
   */
  public int numberOfIslandsDFS(char[][] grid) {
    Graph graph = graphBuilder(grid);

    // Count connected components using Graph's DFS
    Set<Node> visited = new HashSet<>();
    int islands = 0;

    for (Node node : graph.getVertices()) {
      if (!visited.contains(node)) {
        graph.dfs(node, visited);
        islands++;
      }
    }

    return islands;
  }

  /**
   * <b>Problem:</b> Number of Islands using BFS
   *
   * <p>Given a 2D grid of '1's (land) and '0's (water), count the number of islands. An island is
   * surrounded by water and formed by connecting adjacent lands horizontally or vertically. <br>
   * <b>Example:</b> <br>
   *
   * <p><b>Input:</b> <br>
   * 1 1 0 0 0 <br>
   * 1 1 0 0 0 <br>
   * 0 0 1 0 0 <br>
   * 0 0 0 1 1 <br>
   *
   * <p><b>Output:</b> 3
   */
  public int numberOfIslandsBFS(char[][] grid) {

    Graph graph = graphBuilder(grid);

    // Count connected components using BFS
    Set<Node> visited = new HashSet<>();
    int count = 0;

    for (Node node : graph.getVertices()) {
      if (!visited.contains(node)) {
        graph.bfs(node, visited);
        count++;
      }
    }

    return count;
  }

  private static class Holder {
    static final Solution INSTANCE = new Solution();
  }
}
