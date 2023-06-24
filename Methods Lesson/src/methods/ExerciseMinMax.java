package methods;

public class ExerciseMinMax {

	public static void main(String[] args) {
		
		min(1,2);
		max(10,20);
		avg(100,200,300,400);

	}
	
	public static void min(int a, int b) {
		
		if(a<b) {
			System.out.println(a);
		}
		else {
			System.out.println(b);
		}
		
	}
	
	public static void max(int a, int b) {
		if(a>b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}
	
	public static void avg(int a, int b, int c, int d) {
		
		int sum = a+b+c+d;
		double result = (double)sum/4;
		System.out.println(result);
		
	}

}
