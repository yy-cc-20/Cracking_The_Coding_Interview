import java.util.InputMismatchException;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees.
 */

public class Rotate_Matrix {
	// Time Complexity: O(n^2)
	// Space Complexity: O(n)
	private static int[][] rotate(int[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new InputMismatchException();

		for (int layer = 0; layer < matrix.length / 2; ++layer) {
			int first = layer;
			int last = matrix.length - layer - 1;

			for (int pixel = first; pixel < last; ++pixel) {
				int offset = pixel - first;

				int top = matrix[first][pixel];

				// left -> top
				matrix[first][pixel] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[pixel][last];

				// top -> right
				matrix[pixel][last] = top;
			}
		}

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
		int[][] rotatedMatrix;
		for (int[][] testCase : testCases) {
			rotatedMatrix = rotate(testCase);
			for (int i = 0; i < rotatedMatrix.length; ++i) {
				for (int j = 0; j < rotatedMatrix[0].length; ++j)
					System.out.print(rotatedMatrix[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
}
