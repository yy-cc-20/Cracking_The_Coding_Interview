// Implement an algorithm to determine if a string has all unique characters. What if you
// cannot use additional data structures?

public class Is_Unique {

	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	private static boolean solve(String string) {
		if (string == null || string.isBlank())
			return true;
		
		for (int i = 0; i < string.length(); ++i) {
			for (int j = i + 1; j < string.length(); ++j) {
				if (string.charAt(i) == string.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	// Optimal solution
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	private static boolean solve2(String string) {
		if (string == null || string.isBlank())
			return true;
		
		// Assumption: the string is an ASCII string
		final int NUMBER_OF_ASCII_CHARACTERS = 128;
		
		if (string.length() > NUMBER_OF_ASCII_CHARACTERS)
			return false;
		
		// Tweak: use a reference table
		boolean[] table = new boolean[NUMBER_OF_ASCII_CHARACTERS];
		for (int i = 0; i < string.length(); ++i) {
			if (table[string.charAt(i)])
				return false;
			else
				table[string.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String... args) {		
		String[] testCases = {"unique", "repeat", "special", null, "a", "/t", " "};
		for (int i = 0; i < testCases.length; ++i)
			System.out.println(testCases[i] + "\t" + solve2(testCases[i]));
	}
}
