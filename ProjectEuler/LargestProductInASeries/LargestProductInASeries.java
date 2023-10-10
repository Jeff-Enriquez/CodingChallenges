// https://projecteuler.net/problem=8
public class LargestProductInASeries {

	/*
	 * Time Complexity: O(n), where n = s.length
	 * Space Complexity: O(n), where n = s.length
	 */
	public static long solution(String s, int adjacentDigits) {
		// Any product of 0 is 0, so we will not check for those
		String[] strs = s.split("0");
		long largestProduct = 0;
		// Get all product of each substring of s.
		for(int i = 0; i < strs.length; i++) {
			String str = strs[i];
			// The str is too small to calculate a product
			if(str.length() < adjacentDigits)
				continue;
			// Initialize the current product
			long currentProduct = 1;

			// Calculate the first product in the sequence
			for(int j = 0; j < adjacentDigits; j++) {
				currentProduct *= Integer.valueOf(String.valueOf(str.charAt(j)));
			}
			// Check if the product is the largest
			if(currentProduct > largestProduct) {
				largestProduct = currentProduct;
			}
			
			// Calculate all other possible products
			for(int j = adjacentDigits; j < str.length(); j++) {
				currentProduct /= Integer.valueOf(String.valueOf(str.charAt(j - adjacentDigits)));
				currentProduct *= Integer.valueOf(String.valueOf(str.charAt(j)));
				if(currentProduct > largestProduct) {
					largestProduct = currentProduct;
				}
			}

		}
		
		return largestProduct;
	}
	
	public static void main(String[] args) {
		String str = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		System.out.println(solution(str, 4));
		System.out.println(solution(str, 13));
	}
}
