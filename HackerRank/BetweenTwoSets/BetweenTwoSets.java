import java.util.*;
// https://www.hackerrank.com/challenges/between-two-sets/problem
public class BetweenTwoSets {
	/*
	 * Time Complexity: O(a + b(minB / maxA))
	 * Space Complexity: O(minB / maxA)
	 * 		a = a.size()
	 * 		b = b.size()
	 * 		maxA is the largest integer in list a
	 * 		minB is the smallest integer in list b
	 */
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		// Get the greatest number in list a
		int maxA = a.stream().max((num1, num2) -> num1 - num2).get();
		// Get the smallest number in list b
		int minB = b.stream().min((num1, num2) -> num1 - num2).get();
		// Save all possible factors
        Set<Integer> factors = new HashSet<>();
        // Check if current num is a possible factor
        Integer currentNum = 0;
        // Only need to check factors that are less than or equal to the smallest number in list b
        while((currentNum += maxA) <= minB) {
        	boolean isFactor = true;
        	// If all numbers in list a divide into the curentNum then it is a possible factor
            for(Integer n : a) {
            	if(currentNum % n != 0) {
            		isFactor = false;
            		break;
            	}
            }
            if(isFactor)
            	factors.add(currentNum);
        }
        
        int factorCount = 0;
        // The factor count is incremented when all numbers in list b are divisible by a factor in the factors set
        for(Integer f : factors) {
            boolean isFactor = true;
            for(Integer bNum : b) {
                if(bNum % f != 0) {
                    isFactor = false;
                    break;
                }
            }
            if(isFactor)
            	factorCount++;
        }
        return factorCount;
	}
	
	public static void main(String[] args) {
		List a = Arrays.asList(100,99,98,97,96,95,94,93,92,91);
		List b = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(getTotalX(a,b)); // Expected Result: 0
		
		List c = Arrays.asList(2);
		List d = Arrays.asList(20,30,12);
		System.out.println(getTotalX(c,d)); // Expected Result: 1
		
		List e = Arrays.asList(2,4);
		List f = Arrays.asList(16,32,96);
		System.out.println(getTotalX(e,f)); // Expected Result: 3
		
		List g = Arrays.asList(3,4);
		List h = Arrays.asList(24,48);
		System.out.println(getTotalX(g,h)); // Expected Result: 2
		
		List i = Arrays.asList(1);
		List j = Arrays.asList(100);
		System.out.println(getTotalX(i,j)); // Expected Result: 9
	}
}
