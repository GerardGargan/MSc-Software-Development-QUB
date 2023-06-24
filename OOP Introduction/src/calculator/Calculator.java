package calculator;

public class Calculator {
	private int memory;
	
	public int addNumbers(int a, int b) {
		int result = a+b;
		return result;
	}
	
	public int subtract(int a, int b) {
		int result = a-b;
		return result;
	}
	
	public int multiply(int a, int b) {
		int result = a*b;
		return result;
	}
	
	public int divide(int a, int b) {
		int result = a/b;
		return result;
	}
	
	public double sqrRoot(int a) {
		double result = (double)a/a;
		return result;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	public int getMemory() {
		return memory;
	}
	
	public void clearMemory() {
		memory = 0;
	}

}
