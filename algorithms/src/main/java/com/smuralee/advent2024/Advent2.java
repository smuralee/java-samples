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

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Advent2 {
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            int safeReports;
            int safeReportsWithDampener;
            try (Scanner scanner = new Scanner(file)) {
                safeReports = 0;
                safeReportsWithDampener = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (isSafe(line)) {
                        safeReports++;
                    }
                    if (isSafeWithDampener(line)) {
                        safeReportsWithDampener++;
                    }
                }
            }

            log.info("Number of safe reports: {}", safeReports);
            log.info("Number of safe reports with dampener: {}", safeReportsWithDampener);

        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static boolean isSafe(String report) {
        String[] levelsStr = report.split(" ");
        int[] levels = new int[levelsStr.length];

        for (int i = 0; i < levelsStr.length; i++) {
            levels[i] = Integer.parseInt(levelsStr[i]);
        }

        // Check if all levels are increasing or decreasing
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < levels.length - 1; i++) {
            if (levels[i] > levels[i + 1]) {
                increasing = false;
            }
            if (levels[i] < levels[i + 1]) {
                decreasing = false;
            }
        }

        // Check if any two adjacent levels differ by at least one and at most three
        boolean validDiff = true;
        for (int i = 0; i < levels.length - 1; i++) {
            int absDifference = Math.abs(levels[i] - levels[i + 1]);
            if (absDifference < 1 || absDifference > 3) {
                validDiff = false;
                break;
            }
        }

        return (increasing || decreasing) && validDiff;
    }

    public static boolean isSafeWithDampener(String report) {
        String[] levelsStr = report.split(" ");
        int[] levels = new int[levelsStr.length];

        for (int i = 0; i < levelsStr.length; i++) {
            levels[i] = Integer.parseInt(levelsStr[i]);
        }

        // Check if the report is already safe
        if (isSafe(report)) {
            return true;
        }

        // Check if removing a single level would make the report safe
        for (int i = 0; i < levels.length; i++) {
            // Here the element on the ith index will be removed
            // The remaining elements will be re-validated

            // Build a new array
            int[] newLevels = new int[levels.length - 1];

            // Drop the ith index element
            System.arraycopy(levels, 0, newLevels, 0, i);
            System.arraycopy(levels, i + 1, newLevels, i, levels.length - i - 1);

            // Build the new level
            StringBuilder newReport = new StringBuilder();
            for (int newLevel : newLevels) {
                newReport.append(newLevel).append(" ");
            }

            // Check if the level is safe
            if (isSafe(newReport.toString().trim())) {
                return true;
            }
        }

        return false;
    }
}