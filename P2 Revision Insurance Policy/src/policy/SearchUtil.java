package policy;

import java.util.ArrayList;

public class SearchUtil {

	/**
	 * Search method, searches a given array list for a motor policy with an age
	 * between an upper and lower bound
	 * 
	 * @param list
	 * @param ageLower
	 * @param ageUpper
	 * @returns an array list of objects of type MotorPolicy, containing the matches
	 */
	public static ArrayList<MotorPolicy> searchByAge(ArrayList<MotorPolicy> list, int ageLower, int ageUpper)
			throws IllegalArgumentException {
		if (list == null) {
			throw new IllegalArgumentException("Array list cannot be null");
		} else if (ageLower < 0 || ageUpper > 100) {
			throw new IllegalArgumentException("Invalid age range (<0 or >100)");
		} else {
			ArrayList<MotorPolicy> result = new ArrayList<MotorPolicy>();

			for (MotorPolicy p : list) {
				if (p.getAge() >= ageLower && p.getAge() <= ageUpper) {
					result.add(p);
				}
			}

			return result;
		}
	}

	/**
	 * Searchs a given array list of motor policy objects for a specified motor type
	 * 
	 * @param list
	 * @param motorType
	 * @returns an array list of motorpolicy objects that match the motor type
	 *          passed in
	 */
	public static ArrayList<MotorPolicy> searchForAllByMotorPolicyType(ArrayList<MotorPolicy> list, MotorType motorType)
			throws IllegalArgumentException {
		if (list == null) {
			throw new IllegalArgumentException("Array list cannot be null");
		} else if (motorType == null) {
			throw new IllegalArgumentException("Motor type cannot be null");
		} else {
			ArrayList<MotorPolicy> result = new ArrayList<MotorPolicy>();

			for (MotorPolicy p : list) {
				if (p.getMotorType() == motorType) {
					result.add(p);
				}
			}

			return result;
		}
	}
}
