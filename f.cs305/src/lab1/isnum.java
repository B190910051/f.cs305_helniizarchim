package lab1;

public class isnum {
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
			d = d * 1;
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
