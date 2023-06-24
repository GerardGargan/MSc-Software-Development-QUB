package practical4;

public class Part3_6 {

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			if(i%2==1) {
				System.out.print(i);
				if(i!=99) {
					System.out.print(", ");
				}
			}
		}

	}

}
