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

package com.smuralee.arrays;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Sorts an array using the insertion sort algorithm.
     * Creates a copy of the input array to avoid modifying the original.
     * 
     * @param inputArray the array to be sorted
     * @return a new sorted array
     * @throws IllegalArgumentException if inputArray is null
     */
    public static int[] sort(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        // Create a copy to avoid modifying the original array
        int[] array = Arrays.copyOf(inputArray, inputArray.length);
        int length = array.length;

        // Arrays with 0 or 1 element is already sorted
        if (length < 2) {
            return array;
        }

        // Loop through the array
        // We need 2 pointers, current i.e. key and previous
        for (int i = 0; i < length; i++) {
            int key = array[i];
            int j = i - 1;

            // Shift elements that are greater than key to the right
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert the current element at its correct position
            array[j + 1] = key;
        }

        return array;
    }
}