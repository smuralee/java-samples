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
package com.smuralee.matrix;

public class MatrixOperations {

  /**
   * For an array row [1,2,3] - The flip will be 1 to 3, 3 to 1 and 2 is static<br>
   * For and array row [1,2,3,4] - The flip is 1 to 4, 4 -1 and 2 to 3, 3 to 2<br>
   * For and array row [1,2,3,4,5] - The flip is 1 to 5, 5 -1 ; 2 to 4, 4 to 2 and 3 is static<br>
   * <br>
   * Number of flips = row length/2<br>
   * For even number of elements [4], all flip [2 flips]<br>
   * For odd number of elements [5], centre is untouched [2 flips]<br>
   * <br>
   * The loop on the row will be (int i = 1; i <= row.length / 2; i++)<br>
   * Initializing with i=1 since we need the index as, row.length -1<br>
   *
   * @param mat - Matrix for horizontal flip
   * @return Matrix after horizontal flip
   */
  public int[][] flip_matrix_horizontally(int[][] mat) {

    int temp;
    for (int[] row : mat) {
      for (int i = 1; i <= row.length / 2; i++) {
        temp = row[row.length - i];
        row[row.length - i] = row[i - 1];
        row[i - 1] = temp;
      }
    }
    return mat;
  }

  /**
   * Given matrix <br>
   * {1, 2, 3, 11},<br>
   * {4, 5, 6, 14},<br>
   * {7, 8, 9, 17},<br>
   * {10, 20, 30, 40} <br>
   * <br>
   *
   * <p>Matrix positions <br>
   * {0-0, 0-1, 0-2, 0-3},<br>
   * {1-0, 1-1, 1-2, 1-3},<br>
   * {2-0, 2-1, 2-2, 2-3},<br>
   * {3-0, 3-1, 3-2, 3-3}<br>
   *
   * <p><br>
   * row is 'i' and column is 'j'<br>
   * The transpose happens at the vertex of i=j, every time j = i+1<br>
   * The elements to transpose are to the right and bottom of i=j <br>
   * So we flip [i][j] = [j][i]<br>
   *
   * @param mat - Matrix to transpose
   * @return - Transposed matrix
   */
  public int[][] transpose_square_matrix(int[][] mat) {
    int temp;
    for (int i = 0; i < mat.length; i++) {
      for (int j = i + 1; j < mat.length; j++) {
        temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }
    return mat;
  }

  /**
   * Transpose a rectangular matrix
   *
   * @param mat - Matrix to transpose
   * @return - Transposed matrix
   */
  public int[][] transpose_rectangular_matrix(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;

    // Building a new transpose matrix
    // The row count of original matrix will be the column count here
    // The column count of the original matrix will be the row count here
    int[][] tMat = new int[cols][rows];

    // Swap the values
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        tMat[i][j] = mat[j][i];
      }
    }

    return tMat;
  }

  /**
   * Move the matrix elements ahead depending on the position shift requested
   *
   * @param mat - Matrix to be moved
   * @param positions_to_move - Positions to move for the matrix elements
   * @return - Moved matrix
   */
  public int[][] move_matrix(int[][] mat, int positions_to_move) {

    int rows = mat.length;
    int cols = mat[0].length;
    int previousRowLastElement = 0;

    // Loop for executing the one position shift "n" number of times
    for (int count = 1; count <= positions_to_move; count++) {

      // Iterate in reverse, since the last element is the first to displace
      // Store the last element [mxn] of the matrix
      // This is the first element to be displaced and will be used to move to [0x0] position
      int lastElement = mat[rows - 1][cols - 1];

      // Fill from the last position
      for (int i = rows - 1; i >= 0; i--) {
        if (i > 0) {
          // Store the last element of the previous row
          // This is to use in the first column of the current row
          previousRowLastElement = mat[i - 1][cols - 1];
        }
        for (int j = cols - 1; j >= 0; j--) {
          if (j > 0) {
            // In the current row, move the previous column's element
            // to the current column's element location
            mat[i][j] = mat[i][j - 1];
          } else {
            // If the position is 0th column,
            // replace with the last element of the previous row
            mat[i][j] = previousRowLastElement;
          }
        }
      }
      // Store the last element of the matrix to the 0th position
      // This is the original element which was displaced to start the right shift of elements
      mat[0][0] = lastElement;
    }

    return mat;
  }
}
