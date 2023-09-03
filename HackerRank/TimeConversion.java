// Java has classes to handle date-time formatting. I will not be using that class. I will be solving this in a way that is not language specific.
// https://www.hackerrank.com/challenges/time-conversion/problem
public class TimeConversion {
	
	/*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
	public static String solution(String s) {
		// Save result in this variable
		String militaryTime = "";
		
		// Separates the string into an array of parts. 
		// Example: "12:01:00PM" is separated into ["12", "01", "00PM"]
		String[] timeParts = s.split(":");
		
		// For readability, store each part in its own string
		String hours = timeParts[0];
		String minutes = timeParts[1];
		String seconds = timeParts[2].substring(0, 2);
		String middayIndicator = timeParts[2].substring(2, 4);

		// Convert 12-hour time to military time
		if(middayIndicator.equals("PM")) {
			if(hours.equals("12")) {
				militaryTime = s.substring(0, 8);
			} else {
				int militaryHour = Integer.valueOf(hours) + 12;
				militaryTime = militaryHour + ":" + minutes + ":" + seconds;
			}
		} else {
			if(hours.equals("12")) {
				militaryTime = "00:" + minutes + ":" + seconds;
			} else {
				militaryTime = s.substring(0, 8);
			}
		}
			
		return militaryTime;
	}

}
