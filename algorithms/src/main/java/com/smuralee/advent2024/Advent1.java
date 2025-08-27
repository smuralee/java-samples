/**
 * Copyright 2024 Suraj Muraleedharan
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
package com.smuralee.advent2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Advent1 {
  public static void main(String[] args) {
    final String filePath = args[0];
    runDay1(filePath);
  }

  public static void runDay1(String filePath) {
    long startTime = System.nanoTime();
    try {
      List<Integer> left = new ArrayList<>();
      List<Integer> right = new ArrayList<>();
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        // Process each line, the inputs are space-delimited
        String[] values = line.split(" {3}");
        left.add(Integer.valueOf(values[0]));
        right.add(Integer.valueOf(values[1]));
      }

      // Sort both collections
      Collections.sort(left);
      Collections.sort(right);

      // Find the differences in the list and get the total sum
      int sumOfDifferences =
          IntStream.range(0, Math.min(left.size(), right.size()))
              .map(i -> Math.abs(left.get(i) - right.get(i)))
              .sum();
      log.info("Sum of the differences - {}", sumOfDifferences);

      // Find the occurrences
      Map<Integer, Long> occurrences =
          right.stream().collect(Collectors.groupingBy(number -> number, Collectors.counting()));
      long sumOfOccurrences =
          left.stream()
              .filter(occurrences::containsKey)
              .mapToLong(value -> occurrences.get(value) * value)
              .sum();
      log.info("Sum of the occurrences - {}", sumOfOccurrences);

    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
    long endTime = System.nanoTime();
    log.info("Time: {} ms", (endTime - startTime) / 1_000_000.0);
  }
}
