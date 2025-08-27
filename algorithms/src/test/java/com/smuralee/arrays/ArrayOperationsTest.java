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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTest {

  private static final ArrayOperations arrayOperations = new ArrayOperations();

  @Test
  @DisplayName("GIVEN an integer array, THEN reverse the elements")
  void reverseIntArray() {

    int[] given = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] expected = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};

    int[] response = arrayOperations.reverseIntArray(given);
    assertArrayEquals(expected, response);
  }
}
