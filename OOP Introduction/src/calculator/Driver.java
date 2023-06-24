package calculator;

public class Driver {

	public static void main(String[] args) {
		
		int a,b;
		a=2;
		b=5;
		
		Calculator calc = new Calculator();
		System.out.println(calc.addNumbers(a, b));
		System.out.println(calc.divide(a, b));
		System.out.println(calc.multiply(a, b));
		System.out.println(calc.sqrRoot(b));
		System.out.println(calc.subtract(a, b));
		calc.setMemory(10);
		System.out.println(calc.getMemory());
		calc.clearMemory();
		System.out.println(calc.getMemory());
	}

}
