package com.smuralee.queues;

import java.util.logging.Logger;

public class QueueUsingArray {

    private final Logger logger = Logger.getLogger(QueueUsingArray.class.getName());

    private String[] arr;
    private int size;
    private int end = 0;
    private int items = 0;

    public void initializeArray(int size) {
        this.size = size;
        this.arr = new String[size];
    }

    public String[] getArr() {
        return this.arr;
    }

    public void addToQueue(String element) {
        if (items >= size || end >= size) {
            logger.warning("Queue is full : " + arr.length + " elements added");
        } else {
            // Add the new element to the end of the array
            arr[end] = element;
            end++;
            items++;
        }
    }

    public void removeFromQueue() {
        if (items > 0) {
            // Move the array elements ahead by one position
            System.arraycopy(arr, 1, arr, 0, size - 1);

            // Set the last element position as null and decrement the max size and items count
            arr[end - 1] = null;
            end--;
            items--;
        }
    }
}
