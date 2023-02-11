package com.smuralee.queues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QueueUsingArrayTest {

    private static QueueUsingArray queueUsingArray;

    @Test
    @DisplayName("GIVEN 6 elements, THEN add all to the queue")
    void add_to_queue() {
        String[] expected = {"A", "B", "C", "D", "E", "F"};

        queueUsingArray = new QueueUsingArray();
        queueUsingArray.initializeArray(6);

        queueUsingArray.addToQueue("A");
        queueUsingArray.addToQueue("B");
        queueUsingArray.addToQueue("C");
        queueUsingArray.addToQueue("D");
        queueUsingArray.addToQueue("E");
        queueUsingArray.addToQueue("F");

        assertArrayEquals(expected, queueUsingArray.getArr());

    }

    @Test
    @DisplayName("GIVEN 6 elements are added and remove, THEN first element is removed")
    void remove_from_queue() {
        String[] expected = {"B", "C", "D", "E", "F", null};

        queueUsingArray = new QueueUsingArray();
        queueUsingArray.initializeArray(6);

        queueUsingArray.addToQueue("A");
        queueUsingArray.addToQueue("B");
        queueUsingArray.addToQueue("C");
        queueUsingArray.addToQueue("D");
        queueUsingArray.addToQueue("E");
        queueUsingArray.addToQueue("F");

        queueUsingArray.removeFromQueue();

        assertArrayEquals(expected, queueUsingArray.getArr());

    }


}
