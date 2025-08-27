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
package com.smuralee.queues;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
