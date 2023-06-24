package maths.examples;

public class NumberCruncher {

	/**
	 * Add two numbers, reutn the result
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int addNumber(int num1, int num2) {
		return num1 + num2;
	}

	/**
	 * Add three numbers, return the result
	 * 
	 * @param num1
	 * @param num2
	 * @param num3
	 * @return
	 */
	public int addNumber(int num1, int num2, int num3) {

		return num1 + num2 + num3;
	}

	public int multiplyNumbers(int num1, int num2) {
		return num1 * num2;
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 * @throws Exception
	 */
	public double divNumbers(double num1, double num2) throws IllegalArgumentException {
		if (num2 == 0) {
			throw new IllegalArgumentException("Cant divide by zero");
		} else {
			return num1 / num2;
		}
	}
}
