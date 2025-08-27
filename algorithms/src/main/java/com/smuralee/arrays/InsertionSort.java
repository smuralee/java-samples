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

import java.util.Arrays;

public class InsertionSort {

  /**
   * Implement binary insertion sort which reduces comparisons from O(n) to O(log n) per insertion.
   * Best for scenarios where comparisons are expensive.
   *
   * @param input the array to be sorted
   * @return a new sorted array
   */
  public static int[] sortWithBinarySearch(int[] input) {
    if (input == null || input.length < 2) {
      return input == null ? new int[0] : Arrays.copyOf(input, input.length);
    }

    int[] array = Arrays.copyOf(input, input.length);

    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int pos = binarySearch(array, 0, i, key);

      // Shift elements to make space
      // Uses System.arraycopy() for efficient bulk shifting
      System.arraycopy(array, pos, array, pos + 1, i - pos);
      array[pos] = key;
    }

    return array;
  }

  private static int binarySearch(int[] arr, int left, int right, int key) {
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
   * Sorts an array using the insertion sort algorithm. Creates a copy of the input array to avoid
   * modifying the original.
   *
   * @param input the array to be sorted
   * @return a new sorted array
   */
  public static int[] sort(int[] input) {
    if (input == null || input.length == 0) {
      return new int[0]; // Return empty array instead of throwing exception
    }

    // Create a copy to avoid modifying the original array
    int[] array = Arrays.copyOf(input, input.length);
    int length = array.length;

    // Arrays with 0 or 1 element is already sorted
    if (length < 2) {
      return array;
    }

    // Loop through the array
    // We need 2 pointers, i.e. key (i) and previous element (j)
    // The index starts from 1, since first element is considered as sorted
    for (int i = 1; i < length; i++) {
      int key = array[i];

      // Early termination if already in position
      if (array[i - 1] < key) {
        continue;
      }

      int j = i - 1;

      // Shift elements that are greater than key to the right
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }

      // Insert the current element at its correct right position
      array[j + 1] = key;
    }

    return array;
  }
}
