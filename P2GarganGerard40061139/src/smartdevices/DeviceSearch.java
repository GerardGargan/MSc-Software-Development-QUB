package smartdevices;

/**
 * 
 * @author ggargan
 * Gerard Gargan, Student number 40061139
 */
 
import java.util.ArrayList;

public class DeviceSearch {

	/**
	 * Search method, searches a given array list of type smart radiator for a
	 * specified room
	 * 
	 * @param list
	 * @param room
	 * @returns an arraylist of objects of type SmartRadiator that meet the searh
	 *          criteria
	 * @throws an illegalArgumentExcepton if the list passed in is null, or the room
	 *            is null
	 */
	public static ArrayList<SmartRadiator> searchByRoom(ArrayList<SmartRadiator> list, Room room)
			throws IllegalArgumentException {

		if (list == null) {
			throw new IllegalArgumentException("List cannot be null");
		} else if (room == null) {
			throw new IllegalArgumentException("room cannot be null");
		} else {

			ArrayList<SmartRadiator> result = new ArrayList<SmartRadiator>();

			for (SmartRadiator s : list) {
				if (s.getRoom() == room) {
					result.add(s);
				}
			}

			return result;
		}
	}

	/**
	 * Searches an array list of type SmartRadiator for the current temperature
	 * within a given range (start and end)
	 * 
	 * @param list
	 * @param startTemp
	 * @param endTemp
	 * @returns an Array list of Objects (SmartRadaiator) for which their current
	 *          temperature is within the paramaters passed in (inclusive)
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<SmartRadiator> searchByTemp(ArrayList<SmartRadiator> list, double startTemp, double endTemp)
			throws IllegalArgumentException {

		if (list == null) {
			throw new IllegalArgumentException("list cannot be null");
		} else if (startTemp < -20 || endTemp > 50) {
			throw new IllegalArgumentException("Temp values are out of range, must be between -20 and 50");
		}
		ArrayList<SmartRadiator> result = new ArrayList<SmartRadiator>();

		for (SmartRadiator s : list) {
			if (s.getTempNow() >= startTemp && s.getTempNow() <= endTemp) {
				result.add(s);
			}
		}

		return result;

	}
}
