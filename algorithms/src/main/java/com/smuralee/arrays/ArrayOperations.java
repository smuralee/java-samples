package com.smuralee.arrays;

public class ArrayOperations {

    /**
     * An array is a type of data structure that stores elements of the same
     * type in a contiguous block of memory.
     *
     * Reverse an array of integers
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
