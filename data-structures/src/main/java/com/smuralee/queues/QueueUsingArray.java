/**
 * Copyright 2023 Suraj Muraleedharan
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

package com.smuralee.queues;

import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueUsingArray {

    private static final Logger logger = Logger.getLogger(QueueUsingArray.class.getName());

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
            logger.log(Level.WARNING, "Queue is full : {0} elements added", arr.length);
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
