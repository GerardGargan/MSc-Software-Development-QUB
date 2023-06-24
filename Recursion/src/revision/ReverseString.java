package revision;

public class ReverseString {

	public static void main(String[] args) {
		String toReverse = "Caoimhe Gargan";
		
		System.out.println(reverse(toReverse));

	}

	private static String reverse(String toReverse) {
		
		if(toReverse.length()<2) {
			return toReverse;
		} else {
			return reverse(toReverse.substring(1))+toReverse.charAt(0);
		}
		
	}

}
