package HackerRank.DEBUG.PrimeDates;
// Debug Challenge
// https://www.hackerrank.com/challenges/prime-date/problem
public class PrimeDates {

	public static int[] month = new int[13];
	
	public static void updateLeapYear(int year) {
        if(year % 400 == 0) {
            month[2] = 29; // change '28' to '29'
        } else if(year % 100 == 0) {
            month[2] = 28; // change '29' to '28'
        } else if(year % 4 == 0) {
            month[2] = 29;
        } else {
            month[2] = 28;
        }
    }
    
    public static void storeMonth() {
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
    }
   
   public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
        storeMonth();
    
        int result = 0;
    
        while(true) {
            int x = d1;
            x = x * 100 + m1;
            x = x * 10000 + y1; // change '1000' to '10000'
            if(x % 4 == 0 || x % 7 == 0) { // change && to ||
                result = result + 1;
            }
            if(d1 == d2 && m1 == m2 && y1 == y2) {
                break;
            }
            updateLeapYear(y1);
            d1 = d1 + 1;
            if(d1 > month[m1]) {
                m1 = m1 + 1;
                d1 = 1;
                if(m1 > 12) {
                    y1 =  y1 + 1;
                    m1 = 1; // change 'm1 = m1 + 1' to 'm1 = 1'
                }
            }
        }
        return result;
    }
   
   public static void main(String[] args) {
	   System.out.println(
			   findPrimeDates(25, 6, 2365, 7, 9, 8847)
			   );
	   // Expected result: 846403
   }
}
