/*
 * Copyright 2019 Andrew Rice <acr31@cam.ac.uk>, C.I. Griffiths
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.cig23.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class FibonacciTableTest {

  @Test
  public void fib_makesUseOfCache() {
    // Hint: use CountingMap!
    CountingMap cache = new CountingMap();
    FibonacciTable f = new FibonacciTable(cache);
    for (int i = 1; i <= 10; i++) {
      f.fib(i);
    }
    int test_result = cache.getCounter();
    assertThat(test_result).isGreaterThan(0);
  }

  @Test
  public void fibonacci_table_returns1_for1() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    int result = fibonacci.fib(1);

    // ASSERT
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void fibonacci_table_returns34_for9() {
    // ARRANGE
    FibonacciTable fibonacci = new FibonacciTable();

    // ACT
    int result = fibonacci.fib(9);

    // ASSERT
    assertThat(result).isEqualTo(34);
  }
}
