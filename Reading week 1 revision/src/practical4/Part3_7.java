package practical4;

public class Part3_7 {

	public static void main(String[] args) {
		
		for(int i=1000; i>=0; i--) {
			System.out.println(i+" ");
			if(i==333) {
				System.out.println("Launch aborted!");
				break;
			}
		}

	}

}
