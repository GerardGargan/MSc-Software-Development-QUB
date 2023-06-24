package practicals;

public class Test {
	
	

	public static void main(String[] args) {

		String[] words = new String[5];
		
		words[3] = "banana";
		words[4] = "strawberry";
		words[2]= "";
		
		int len1 = words.length;
		int len2 = words[4].length();
		int len3 = words[2].length();
		
		System.out.printf("a %d, b %d, c %d",len1,len2,len3);
	}
	
	

}
