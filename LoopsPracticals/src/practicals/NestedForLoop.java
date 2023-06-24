package practicals;

public class NestedForLoop {

	public static void main(String[] args) {

		for(int outer=1; outer<=3; outer++) {

			
			for(int inner=1; inner<=10; inner++) {
				
				if(outer==1) {
					System.out.print("*"+inner);
				}
				else if(outer==2) {
					System.out.print("**"+inner);
				}
				else if(outer==3) {
					System.out.print("***"+inner);
				}
				
				
				//put in the commas excluding after 10
				if(inner!=10) {
					System.out.print(", ");
				}
				
				
			}//End of inner loop
			System.out.println();
			
		}//End of outer loop
		

	}

}
