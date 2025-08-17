/**
 * Copyright 2024 Suraj Muraleedharan
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

package com.smuralee.advent2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Advent3 {

    // Regular expression patterns to match valid mul instructions and conditional statements
    static Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            try (Scanner scanner = new Scanner(file)) {
                scanner.useDelimiter("\\Z");
                String memoryString = scanner.next();// Read the entire file

                int corruptedMemoryPart1 = parseCorruptedMemoryPart1(memoryString);
                log.info("Sum of results - Part-1: {}", corruptedMemoryPart1);

                int corruptedMemoryPart2 = parseCorruptedMemoryPart2(memoryString);
                log.info("Sum of results - Part-2: {}", corruptedMemoryPart2);
            }

        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static int parseCorruptedMemoryPart1(String memory) {
        Matcher matcher = mulPattern.matcher(memory);
        int total = 0;

        while (matcher.find()) {
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));
            total += num1 * num2;
        }

        return total;
    }

    public static int parseCorruptedMemoryPart2(String memory) {

        // Initialize flag to track whether mul instructions are enabled
        boolean mulEnabled = true;

        // Initialize sum of results
        int total = 0;

        // Iterate over the memory, processing one character at a time
        int i = 0;
        while (i < memory.length()) {
            // Check for do() instruction
            if (memory.startsWith("do()", i)) {
                mulEnabled = true;
                i += 4;
            }
            // Check for don't() instruction
            else if (memory.startsWith("don't()", i)) {
                mulEnabled = false;
                i += 6;
            }
            // Check for mul instruction
            else if (mulPattern.matcher(memory.substring(i)).find()) {
                Matcher matcher = mulPattern.matcher(memory.substring(i));
                matcher.find();
                String match = matcher.group(0);
                int j = i;
                while (j < i + match.length()) {
                    if (memory.charAt(j) != match.charAt(j - i)) {
                        break;
                    }
                    j++;
                }
                if (j == i + match.length()) {
                    if (mulEnabled) {
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        total += x * y;
                    }
                    i += match.length();
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        return total;
    }
}
