# Math Formulas
> This document contains math formulas that I have used when solving coding problems on HackerRank or ProjectEuler.

## Table of Contents
- [Sum of an arithmetic series](#sum-of-an-arithmetic-series)(#sum-of-the-first-n-natural-numbers)
- [Sum of the first n natural numbers](#sum-of-the-first-n-natural-numbers)
- [Permutations](#permutations)
   - [Permutation without repetition](#permutation-without-repetition)
- [Combinations](#combinations)
   - [Combinations without repetition](#combinations-without-repetition)
- [Tips](#tips)
   - [Palindrome of a number](#palindrome-of-a-number)
   - [Finding products of a number](#finding-products-of-a-number)
### Sum of an arithmetic series
`(n / 2) * (2a + (n - 1) * d)`
 *n* represents the number of terms to be added, *a* is the first term in the sequence, and *d* is the constant value between terms.

 **Example**
 <ins>You are trying to save money. You currently have $10 in your bank account. You plan to add $5 every week. How much money will you have saved in a year (52 weeks)?</ins>
 <ins>n = 52, a = 10, l = 5</ins>
1) Solve by formula:
   answer = (52 / 2) * (10 + 5)
   answer = 26 * 15
   answer = 390

**Coding Tip**
Be sure to use floating point precision when calculating the formula.

### Sum of the first n natural numbers
`(n * n + n) / 2`
Calculates the sum of *n*.
1 + 2 + 3 + ... + n

**Example**
<ins>Count every substring of a string of "aaaa".</ins> 
   <ins>n = the length of the string</ins>
1) Solve by formula: 
   (4 * 4 + 4) / 2 = 10
2) Solve manually:
   ["a", "a", "a", "a"] -> 4
   ["aa", "aa", "aa"] -> 3
   ["aaa", "aaa"] -> 2
   ["aaaa"] -> 1
   4 + 3 + 2 + 1 = 10

## Permutations
### Permutation without repetition
`n!/(n-r)!`
Permutation relates to the act of arranging all the members of a set into some sequence or order.
*n = total number of objects in the set
r = number of choosing objects from the set*

**Example**
1) There are 20 students. We must pick 3. One to be President, one to be Vice President, and one to be Treasurer. In this problem, the order we choose the students matter.
n = 20, r = 3
answer = 20! / (20 - 3)!
answer = 20! / 17!
answer = (18 \*  19 \* 20) / 1
answer = 6840

**Coding Tip**
Calculating a factorial can take a lot of time and the numbers tend to become very large. It is best to simplify the equation before calculating the factorial. The simplified version when programming is
`Formula: (n - r + 1) * ... * n `
```
answer = 0;
for(i = (n - r + 1); i <= n; i++){
   answer = answer * i;
}
```
<ins>How the formula is simplified. 
Example: n = 5, r = 2</ins>
answer = 5! / (5 - 2)!
answer = 5! / 3!
answer = (1 * 2 * 3 * 4 * 5) / (1 * 2 * 3)
*divide 1 * 2 * 3 from both sides*
answer = (4 * 5) **SAME AS** (n - r + 1) * ... * n

## Combinations
### Combinations without repetition
`n! / (r! (n - r)!)`
Combinations is a way of selecting items from a collection, such that the order of selection does not matter.
*n = total number of objects in the set
r = number of choosing objects from the set*
**Example**
1) There are 20 students. We must pick 3 to receive an A. In this problem, the order does not matter.
   n = 20, r = 3
   answer = 20! / (3!(20 - 3)!)
   answer = 20! / (3! \* 17!)
   answer = (18 \* 19 \* 20) / 3!
   answer = 6840 / 6
   answer = 1140

**Coding Tip**
Calculating a factorial can take a lot of time and the numbers tend to become very large. It is best to simplify the equation before calculating the factorial. The simplified version when programming is
```
### FORMULA ###
Formula if r > (n - r): 
   ((r + 1) * ... * n) / (n - r)!
Formula if r < (n - r):
   ((n - r + 1) * ... * n) / r!
```
```
### CODE ###
startingNumerator = r > (n - r) ? (r + 1) : (n - r + 1)
numerator = 0;
for(i = startingNumerator; i <= n; i++){
   numerator = numerator * i;
}
endingDenominator = r > (n - r) ? (n - r) : r
denominator = 0;
for(i = 1; i <= endingDenominator; i++){
   denominator = denominator * i;
}
result = numerator / denominator;
```
<ins>How the formula is simplified when r > (n - r)
n = 6, r = 4</ins>
answer = 6! / (4! (6 - 4)!)
answer = 6! / (4! 2!)
answer = (1 * 2 * 3 * 4 * 5 * 6) / ((1 * 2 * 3 * 4) (1 * 2)) 
*divide 1 * 2 * 3 * 4 from both sides*
answer = (5 * 6) / (1 * 2) **SAME AS** ((r + 1) * ... * n) / (n - r)!

<ins>How the formula is simplified when r < (n - r)
n = 5, r = 2</ins>
answer = 5! / (2! (5 - 2)!)
answer = 5! / (2! 3!)
answer = (1 * 2 * 3 * 4 * 5) / ((1 * 2) ( 1 * 2 * 3)) 
*divide 1 * 2 * 3 from both sides*
answer = (4 * 5) / (1 * 2) **SAME AS** ((n - r + 1) * ... * n) / r!

## Tips
### Palindrome of a number
All palindromes are divisible by **11**.
Proof using 1111:
P = 1000x + 100y + 10y + x
P = 1001x + 110y
P = **11**(91x + 11y)
### Finding products of a number
All products of a number can be found by checking numbers **1 to √n**
Example: Find all factors of 100.
√100 = 10
[1, <span style="color:Tomato">2</span>, <span style="color:SlateBlue">4</span>, <span style="color:MediumSeaGreen">5</span>, <span style="color:DodgerBlue">10</span>, <span style="color:DodgerBlue">10</span>, <span style="color:MediumSeaGreen">20</span>, <span style="color:SlateBlue">25</span>, <span style="color:Tomato">50</span>, 100]