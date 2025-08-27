/**
 * Copyright 2023 Suraj Muraleedharan
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

public class ArrayOperations {

  /**
   * An array is a type of data structure that stores elements of the same type in a contiguous
   * block of memory.
   *
   * <p>Reverse an array of integers
   */
  public int[] reverseIntArray(int[] input) {
    // Create the return int array with the same size as input
    int arraySize = input.length;
    int[] output = new int[arraySize];

    // Iterate and store in the reverse order in the destination array
    for (int i : input) {
      output[arraySize - 1] = i;
      arraySize--;
    }
    return output;
  }
}
