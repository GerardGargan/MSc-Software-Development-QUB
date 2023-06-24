package practicals;



public class Part1Q5MatthewCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
     * Process a given input String
     * Count the vowels (case insensitive) and return them in a 5 element array
     * where index 0 is A/a, 1 is E/e, 2 is I/i, 3 is O/o and 4 is U/u
     * @param inputString
     * @return vowel count array of the specified form
     */
    private static int[] countVowels(String inputString) {
        int[] vowelCount = new int[5];
        // note these few lines could be replaced with:
        // char[] letters = name.toCharArray();
        char[] letters = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            letters[i] = inputString.charAt(i);
        }
        for (char currentChar : letters) {
            switch (currentChar) {
            case 'a':
            case 'A':
                vowelCount[0]++;
                break;
            case 'e':
            case 'E':
                vowelCount[1]++;
                break;
            case 'i':
            case 'I':
                vowelCount[2]++;
                break;
            case 'o':
            case 'O':
                vowelCount[3]++;
                break;
            case 'u':
            case 'U':
                vowelCount[4]++;
                break;
            default:// not a vowel
            }
        } // end of loop
        return vowelCount;
    }

}
