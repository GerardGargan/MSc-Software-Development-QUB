package practical4;

public class Part3_8 {

	public static void main(String[] args) {
		
		String star = "*";
		for(int row=1; row<=3; row++) {
			for(int col=1; col<=10; col++) {
				System.out.print(star+""+col);
				if(col!=10) {
					System.out.print(", ");
				}
			}
			System.out.println();
			star +="*";
		}
	}

}
