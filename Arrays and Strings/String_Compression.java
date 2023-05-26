import java.util.Arrays;
import java.util.InputMismatchException;

/*
 * Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

public class String_Compression {
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static char[] solve2(char[] string) {
		if (string == null)
			throw new InputMismatchException();

		int count = 1;
		final int DECIMAL_RADIX = 10;
		int i, j;
		for (i = 1, j = 0; i < string.length; ++i) {
			if (string[i - 1] == string[i])
				count++;
			else {
				if (count > 1) {
					string[++j] = Character.forDigit(count, DECIMAL_RADIX);
					count = 1;
				}
				string[++j] = string[i];
			}
		}
		return Arrays.copyOf(string, j + 1);
	}

	public static void main(String... args) {			
		String[] testCases = {"uniq  ue", "apple", "aabbcccda", "fffffggghheeekkkkk", "a", "/t", "  "};
		for (int i = 0; i < testCases.length; ++i)
			System.out.println(solve2(testCases[i].toCharArray()));
	}
}
