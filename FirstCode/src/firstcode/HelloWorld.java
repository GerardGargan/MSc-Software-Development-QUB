/**
 * 
 */
package firstcode;

/**
 * @author ggargan
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World! I am alive. \n\nI can write on two lines!");
		
		System.out.println("\tHappy Christmas!");
		System.out.println("\t\t*");
		System.out.println("\t       ***");
		System.out.println("\t      *****");
		System.out.println("\t     *******");
		System.out.println("\t    *********");
		
		System.out.println("First Witch\tWhen shall we three meet again?");
		System.out.println("\t\tIn thunder, lightening, or in rain?\n");
		System.out.println("Second witch\tWhen the hurlybyrly's done,");
		System.out.println("\t\tWhen the battles lost and won\n");
		System.out.println("Third witch\tThat will be ere the set of sun.\n");
		
		String myName = "Gerard Gargan";
		System.out.println(myName);
		System.out.println("The input string is: "+myName.length()+" characters long");
		System.out.println("The first and second characters are: "+myName.charAt(0)+myName.charAt(1));
		System.out.println("Uppercase letters "+myName.toUpperCase());
		System.out.println("Replace all a with % "+myName.replace('a', '%'));
		System.out.println("Print out the position within the string of the first and last occurences of the character 'n': "+myName.indexOf('n'));
	}

}
