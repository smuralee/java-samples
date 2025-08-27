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
package com.smuralee;

import java.io.Serializable;

public class HelloSingleton implements Serializable {

  // Counter to keep track of the instance invocation
  private static int instantiationCount = 0;

  // Instantiate as null
  private static HelloSingleton obj = null;

  private HelloSingleton() {
    // Keeps the constructor private, disallow instantiation outside the class
  }

  public static void main(final String[] args) {
    // Default execution of 1
    int executionCount = 1;

    // Extract the count if passed
    if (args.length > 0) {
      executionCount = Integer.parseInt(args[0]);
    }

    // Loop through the count
    for (int i = 1; i <= executionCount; i++) {
      HelloSingleton helloSingleton = getInstance();
      helloSingleton.printMessage(i);
    }
  }

  // getInstance for the singleton object
  public static HelloSingleton getInstance() {
    if (obj == null) {
      obj = new HelloSingleton();
      instantiationCount++;
    }
    return obj;
  }

  // Sample method for invocation
  public void printMessage(final int executionCount) {
    System.out.format(
        "You have invoked the singleton instance. The instantiation count is %d and execution count is %d%n",
        instantiationCount, executionCount);
  }

  public String buildMessage(final String message) {
    return "The response is - ".concat(message);
  }
}
