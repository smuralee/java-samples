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
package com.smuralee.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

  @Test
  void testSortWithNullArray() {
    int[] emptyArray = {};
    int[] result = InsertionSort.sort(null);

    assertNotSame(emptyArray, result, "A new array should be returned");
    assertEquals(0, result.length);
  }

  @Test
  void testSortWithEmptyArray() {
    // Test sorting an empty array
    int[] emptyArray = {};
    int[] result = InsertionSort.sort(emptyArray);

    assertNotSame(emptyArray, result, "A new array should be returned");
    assertEquals(0, result.length);
  }

  @Test
  void testSortWithSingleElement() {
    // Test sorting an array with a single element
    int[] singleElementArray = {42};
    int[] result = InsertionSort.sort(singleElementArray);

    assertNotSame(singleElementArray, result, "A new array should be returned");
    assertArrayEquals(new int[] {42}, result);
  }

  @Test
  void testSortWithAlreadySortedArray() {
    // Test sorting an already sorted array
    int[] sortedArray = {1, 2, 3, 4, 5};
    int[] result = InsertionSort.sort(sortedArray);

    assertNotSame(sortedArray, result, "A new array should be returned");
    assertArrayEquals(new int[] {1, 2, 3, 4, 5}, result);
  }

  @Test
  void testSortWithReverseSortedArray() {
    // Test sorting a reverse-sorted array
    int[] reverseSortedArray = {5, 4, 3, 2, 1};
    int[] result = InsertionSort.sort(reverseSortedArray);

    assertNotSame(reverseSortedArray, result, "A new array should be returned");
    assertArrayEquals(new int[] {1, 2, 3, 4, 5}, result);
  }

  @Test
  void testSortWithRandomArray() {
    // Test sorting a randomly ordered array
    int[] randomArray = {3, 1, 4, 1, 5, 9, 2, 6};
    int[] result = InsertionSort.sort(randomArray);

    assertNotSame(randomArray, result, "A new array should be returned");
    assertArrayEquals(new int[] {1, 1, 2, 3, 4, 5, 6, 9}, result);
  }

  @Test
  void testSortWithDuplicateElements() {
    // Test sorting an array with duplicate elements
    int[] arrayWithDuplicates = {3, 1, 3, 2, 1, 3};
    int[] result = InsertionSort.sort(arrayWithDuplicates);

    assertNotSame(arrayWithDuplicates, result, "A new array should be returned");
    assertArrayEquals(new int[] {1, 1, 2, 3, 3, 3}, result);
  }

  @Test
  void testSortWithNegativeNumbers() {
    // Test sorting an array with negative numbers
    int[] arrayWithNegatives = {-3, 1, -5, 0, 4, -2};
    int[] result = InsertionSort.sort(arrayWithNegatives);

    assertNotSame(arrayWithNegatives, result, "A new array should be returned");
    assertArrayEquals(new int[] {-5, -3, -2, 0, 1, 4}, result);
  }

  @Test
  void testOriginalArrayNotModified() {
    // Test that the original array is not modified
    int[] originalArray = {5, 3, 1, 4, 2};
    int[] arrayCopy = Arrays.copyOf(originalArray, originalArray.length);

    InsertionSort.sort(originalArray);

    assertArrayEquals(arrayCopy, originalArray, "Original array should not be modified");
  }
}
