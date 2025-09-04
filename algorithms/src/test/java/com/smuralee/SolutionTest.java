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
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.smuralee.graph.Node;
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

  @Test
  @DisplayName("Validate clone graph algorithm")
  void cloneGraph() {
    // Test null input
    assertNull(solution.cloneGraph(null));

    // Test single node
    Node single = new Node(1);
    Node clonedSingle = solution.cloneGraph(single);
    assertEquals(1, clonedSingle.getVal());
    assertEquals(0, clonedSingle.getNeighbours().size());
    assertNotSame(single, clonedSingle);

    // Test connected graph: 1-2-3-1 (triangle)
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);

    node1.getNeighbours().add(node2);
    node1.getNeighbours().add(node3);
    node2.getNeighbours().add(node1);
    node2.getNeighbours().add(node3);
    node3.getNeighbours().add(node1);
    node3.getNeighbours().add(node2);

    Node cloned = solution.cloneGraph(node1);

    assertEquals(1, cloned.getVal());
    assertEquals(2, cloned.getNeighbours().size());
    assertNotSame(node1, cloned);

    // Verify structure is preserved
    Node clonedNode2 = cloned.getNeighbours().get(0);
    Node clonedNode3 = cloned.getNeighbours().get(1);

    assertEquals(2, clonedNode2.getVal());
    assertEquals(3, clonedNode3.getVal());
    assertEquals(2, clonedNode2.getNeighbours().size());
    assertEquals(2, clonedNode3.getNeighbours().size());
  }
}
