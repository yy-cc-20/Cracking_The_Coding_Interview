/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 */
import java.util.InputMismatchException;

public class Zero_Matrix {
		// Time Complexity: O(n^2)
	// Space Complexity: O(n)
	private static int[][] zeroMatrix(int[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new InputMismatchException();

		
		return matrix;
	}

	public static void main(String... args) {		
		int[][] matrix2x2 = {{0, 1},
							{2, 3}};
		int[][] matrix3x3 = {{0, 1, 2},
							{3, 4, 5},
							{6, 7, 8}};
		int[][] matrix4x4 = {{0, 1, 2, 3},
							{4, 5, 6, 7},
							{8, 9, 10, 11},
							{12, 13, 14, 15}};
		int[][] matrix5x5 = {{0, 1, 2, 3, 4},
							{4, 5, 6, 7, 8},
							{8, 9, 10, 11, 12},
							{12, 13, 14, 15, 15},
							{2, 4, 6, 8, 10}};

		int[][][] testCases = {matrix2x2, matrix3x3, matrix4x4, matrix5x5};
		int[][] zeroMatrix;
		for (int[][] testCase : testCases) {
			zeroMatrix = zeroMatrix(testCase);
			for (int i = 0; i < zeroMatrix.length; ++i) {
				for (int j = 0; j < zeroMatrix[0].length; ++j)
					System.out.print(zeroMatrix[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
}
