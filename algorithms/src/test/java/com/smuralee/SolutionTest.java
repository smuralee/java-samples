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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

  private final Solution solution = Solution.getInstance();

  @Test
  @DisplayName("Validate insertion sort algorithm")
  void insertionSort() {

    int[] givenArr1 = {5, 4, 3, 2, 1};
    int[] givenArr2 = {5, 3, 7, 1, 14};
    int[] givenArr3 = {5};
    int[] givenArr4 = {};

    int[] expectedArr1 = {1, 2, 3, 4, 5};
    int[] expectedArr2 = {1, 3, 5, 7, 14};
    int[] expectedArr3 = {5};
    int[] expectedArr4 = {};

    assertArrayEquals(expectedArr1, solution.insertionSort(givenArr1));
    assertArrayEquals(expectedArr2, solution.insertionSort(givenArr2));
    assertArrayEquals(expectedArr3, solution.insertionSort(givenArr3));
    assertArrayEquals(expectedArr4, solution.insertionSort(givenArr4));
    assertArrayEquals(expectedArr4, solution.insertionSort(null));

    assertArrayEquals(expectedArr1, solution.insertionSortWithBinarySearch(givenArr1));
    assertArrayEquals(expectedArr2, solution.insertionSortWithBinarySearch(givenArr2));
    assertArrayEquals(expectedArr3, solution.insertionSortWithBinarySearch(givenArr3));
    assertArrayEquals(expectedArr4, solution.insertionSortWithBinarySearch(givenArr4));
    assertArrayEquals(expectedArr4, solution.insertionSortWithBinarySearch(null));
  }

  @Test
  @DisplayName("Validate merge sort algorithm")
  void mergeSort() {

    int[] givenArr1 = {5, 4, 3, 2, 1};
    int[] givenArr2 = {5, 3, 7, 1, 14};
    int[] givenArr3 = {5};
    int[] givenArr4 = {};

    int[] expectedArr1 = {1, 2, 3, 4, 5};
    int[] expectedArr2 = {1, 3, 5, 7, 14};
    int[] expectedArr3 = {5};
    int[] expectedArr4 = {};

    assertArrayEquals(expectedArr1, solution.mergeSort(givenArr1));
    assertArrayEquals(expectedArr2, solution.mergeSort(givenArr2));
    assertArrayEquals(expectedArr3, solution.mergeSort(givenArr3));
    assertArrayEquals(expectedArr4, solution.mergeSort(givenArr4));
    assertArrayEquals(expectedArr4, solution.mergeSort(null));
  }

  @Test
  @DisplayName("Validate number of islands using DFS and BFS algorithm")
  void numberOfIslands() {
    char[][] grid1 = {{'1'}};
    char[][] grid2 = {{'0', '0'}, {'0', '0'}};
    char[][] grid3 = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };
    char[][] grid4 = {{'1', '1'}, {'1', '1'}};

    assertEquals(1, solution.numberOfIslandsDFS(grid1));
    assertEquals(0, solution.numberOfIslandsDFS(grid2));
    assertEquals(3, solution.numberOfIslandsDFS(grid3));
    assertEquals(1, solution.numberOfIslandsDFS(grid4));

    assertEquals(1, solution.numberOfIslandsBFS(grid1));
    assertEquals(0, solution.numberOfIslandsBFS(grid2));
    assertEquals(3, solution.numberOfIslandsBFS(grid3));
    assertEquals(1, solution.numberOfIslandsBFS(grid4));
  }
}
