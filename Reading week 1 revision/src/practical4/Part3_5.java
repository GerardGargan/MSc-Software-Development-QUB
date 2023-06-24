package practical4;

public class Part3_5 {

	public static void main(String[] args) {
		
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				System.out.print(i);
				if(i!=100) {
					System.out.print(", ");
				}
			}
		}

	}

}
