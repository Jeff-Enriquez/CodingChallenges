/*
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
 * 
 * Constraints:
 *      1 <= nums1.length, nums2.length <= 10^5
 *      1 <= nums1[i], nums2[j] <= 10^9
 *      Both nums1 and nums2 are sorted in non-decreasing order.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int n1Idx = 0;
        int n2Idx = 0;
        while(n1Idx < n1Len && n2Idx < n2Len) {
            if(nums1[n1Idx] < nums2[n2Idx])
                n1Idx++;
            else if(nums2[n2Idx] < nums1[n1Idx])
                n2Idx++;
            else
                return nums1[n1Idx];
        }
        return -1;
    }
}
