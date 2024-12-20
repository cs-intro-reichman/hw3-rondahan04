

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String newStr1 = "";
		String newStr2 = "";
		for (int i = 0; i < str1.length(); i++) { // remove spaces from str1
			if (str1.charAt(i) != 32) {
				newStr1 = newStr1 + str1.charAt(i);
			}
		}
		for (int i = 0; i < str2.length(); i++) { // remove spaces from str2
			if (str2.charAt(i) != 32) {
				newStr2 = newStr2 + str2.charAt(i);
			}
		}
		int count1 = 0;
		int count2 = 0;
			for ( int i = 0 ; i<newStr1.length(); i++){ // runs on str1
				char c =newStr1.charAt(i); // takes the first letter in str1
				for (int j = 0 ; j<newStr1.length(); j++){ // comparing
					if (newStr1.charAt(j) == c ) count1++;
				   if (newStr2.charAt(j) == c  ) count2++;
				}

			}
			if (count1 != count2){
				return false;
			}
			return true;
		}
		
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String word = "";
			for ( int i = 0 ; i < str.length() ; i++){
			char c = str.charAt(i);
				if (c >= 'a' && c<= 'z') { // its a lower case letter.
				word = word + c;
				}
				if ( c >= 'A' && c<= 'Z'){ // its upper case need to add 32.
				c = (char) (c+32); // makes it lower case.
				word = word + c;
				}
				if ( c == 32) { // its a space
					word = word + c;
				}
			}
		return word;
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String ans = "";
		String str2=str; // copy of str so str will not be changed
		   for (int i = 0 ; i<str.length(); i++){
			   int random = (int)(Math.random() * str2.length()); // takes a random letter
			   ans = ans + str2.charAt(random); // adds the letter to the new string
			   str2 = str2.substring(0, random) + str2.substring(random + 1); // removes the letter from str2
		   }
		   return ans;
	}
}
