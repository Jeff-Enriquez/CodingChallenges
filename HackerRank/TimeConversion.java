// Java has classes to handle date-time formatting. Those classes are not used so that the solution is more language agnostic.
// https://www.hackerrank.com/challenges/time-conversion/problem
public class TimeConversion {
	
	/*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
	public static String solution(String s) {
		// Save result in this variable
		String militaryTime = "";
		
		// Saves the "hh" of "hh:mm:ssAM/PM"
		String hours = s.substring(0, 2);
		// Saves the ":mm:ss" of "hh:mm:ssAM/PM"
		String minutesAndSeconds = s.substring(2, 8);
		
		// Convert to military time
		if(s.endsWith("AM")) {
			// If it's AM and the hour is 12 then convert the hour to 00
			if(hours.equals("12")) {
				militaryTime = "00" + minutesAndSeconds;
			// It it's AM and the hour is NOT 12 then leave the time alone
			} else {
				militaryTime = hours + minutesAndSeconds;
			}
		} else {
			// If it's PM and the hour is 12 then leave the time alone
			if(hours.equals("12")) {
				militaryTime = hours + minutesAndSeconds;
			// If it's PM and the hour is NOT 12 then add 12 to the hour
			} else {
				militaryTime = (12 + Integer.valueOf(hours)) + minutesAndSeconds;
			}
		}
		
		// Return the military time
		return militaryTime;
	}

}
