import java.util.InputMismatchException;

/*
 * Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
 */

public class Palindrome_Permutation {
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static boolean solve2(String string) {
		if (string == null)
			throw new InputMismatchException();
		
		// Assumption: the string is an ASCII string
		final int NUMBER_OF_ASCII_CHARACTERS = 128;
		int[] characterFrequency = new int[NUMBER_OF_ASCII_CHARACTERS];
		boolean foundOdd = false;

		for (int i = 0; i < string.length(); ++i) 
			characterFrequency[string.charAt(i)]++;
		
		for (int count : characterFrequency) {

			// Tweak: use boolean variable to make sure only one odd frequncy
			if (count % 2 != 0)
				if (foundOdd)
					return false;
				else
					foundOdd = true;
		}
			
		return true;
	}

	public static void main(String... args) {		
		String[] testCases = {"abcba", "abccba", "unique", "repeat", "special", "a", "/t", " "};
		for (int i = 0; i < testCases.length; ++i)
			System.out.println(testCases[i] + "\t" + solve2(testCases[i]));
	}
}
