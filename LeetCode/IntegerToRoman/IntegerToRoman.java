/*
 * https://leetcode.com/problems/integer-to-roman/description/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public String intToRoman(int num) {
        StringBuilder romanNumerals = new StringBuilder();
        int i = 0;
        // M: Check if number is divisible by 1000
        for(; i < num / 1000; i++)
            romanNumerals.append("M");
        num %= 1000;
        // CM: Check if number is divisible by 900
        if(num / 900 == 1) {
            romanNumerals.append("CM");
            num -= 900;
        }
        // D: Check if number is divisible by 500
        if(num / 500 == 1) {
            romanNumerals.append("D");
            num -= 500;
        }
        // CD: Check if number is divisible by 400
        if(num / 400 == 1) {
            romanNumerals.append("CD");
            num -= 400;
        }
        // C: Check if number is divisible by 100
        for(i = 0; i < num / 100; i++)
            romanNumerals.append("C");
        num %= 100;
        // XC: Check if number is divisible by 90
        if(num / 90 == 1) {
            romanNumerals.append("XC");
            num -= 90;
        }
        // L: Check if number is divisible by 50
        if(num / 50 == 1) {
            romanNumerals.append("L");
            num -= 50;
        }
        // XL: Check if number is divisible by 40
        if(num / 40 == 1) {
            romanNumerals.append("XL");
            num -= 40;
        }
        // X: Check if number is divisible by 10
        for(i = 0; i < num / 10; i++)
            romanNumerals.append("X");
        num %= 10;
        // IX: Check if number is divisible by 9
        if(num / 9 == 1) {
            romanNumerals.append("IX");
            num -= 9;
        }
        // V: Check if number is divisible by 5
        if(num / 5 == 1) {
            romanNumerals.append("V");
            num -= 5;
        }
        // IV: Check if number is divisible by 4
        if(num / 4 == 1) {
            romanNumerals.append("IV");
            num -= 4;
        }
        // I: Check if number is divisible by 1
        for(i = 0; i < num / 1; i++)
            romanNumerals.append("I");
        return romanNumerals.toString();
    }
}
