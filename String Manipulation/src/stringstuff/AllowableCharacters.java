package stringstuff;

/**
 * @author GarganGerard - 40061139
 */
public class AllowableCharacters {
	public static void main(String[] args) {
		String validName = "Gerard";
		String invalidName = ".Gerard";
		
		System.out.println(isValidName(validName));
		System.out.println(isValidName(invalidName));
	}

	private static boolean isValidName(String validName) {
		String lower = validName.toLowerCase();
		String allowed = "abcdefghijklmnopqrstuvwxyz ";
		
		for(int i=0; i<lower.length(); i++) {
			if(allowed.indexOf(lower.charAt(i))==-1){
				return false;
			}
		}
		
		return true;
	}
}
