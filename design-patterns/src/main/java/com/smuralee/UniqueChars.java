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

public class UniqueChars implements Serializable {

  // Guarantees any change is visible to all threads
  private static volatile UniqueChars uniqueCharsObj = null;

  private UniqueChars() {
    // Private constructor
  }

  public static void main(String[] args) {
    UniqueChars chars = getInstance();
    boolean isUnique = chars.isUniqueChars("Absolute");
    System.out.println(isUnique);
  }

  // Ensuring mutual exclusion with synchronized
  public static synchronized UniqueChars getInstance() {
    if (uniqueCharsObj == null) {
      uniqueCharsObj = new UniqueChars();
    }

    return uniqueCharsObj;
  }

  public boolean isUniqueChars(String str) {
    if (str.length() > 128) {
      return false;
    }

    boolean[] charSet = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (charSet[val]) {
        return false;
      }
      charSet[val] = true;
    }
    return true;
  }
}
