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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UniqueCharsTest {

  @Test
  @DisplayName("GIVEN two singletons, THEN assert instances are the same")
  public void testSingletonInstance() {
    UniqueChars instance1 = UniqueChars.getInstance();
    UniqueChars instance2 = UniqueChars.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  @DisplayName("GIVEN unique characters, THEN assert instances are the same")
  public void testUniqueChars() {
    UniqueChars chars = UniqueChars.getInstance();
    assertTrue(chars.isUniqueChars("abcdef"));
    assertTrue(chars.isUniqueChars(""));
    assertTrue(chars.isUniqueChars("a"));
  }
}
