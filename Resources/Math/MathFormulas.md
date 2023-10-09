# Math Formulas
> This document contains math formulas that I have used when solving coding problems on HackerRank or ProjectEuler.

## Table of Contents
- [Sum of an Arithmetic Series](#sum-of-an-arithmetic-series)
- [Sum of Squares](#sum-of-squares)
- [Sum of the First n Natural Numbers](#sum-of-the-first-n-natural-numbers)
- [Permutations](#permutations)
   - [Permutation Without Repetition](#permutation-without-repetition)
- [Combinations](#combinations)
   - [Combinations Without Repetition](#combinations-without-repetition)
- [Tips](#tips)
   - [Palindrome of a Number](#palindrome-of-a-number)
   - [Finding Products of a Number](#finding-products-of-a-number)
   - [Least Common Multiple](#least-common-multiple)
      - [Prime Factorization](#prime-factorization)
      - [Listing Multiples](#listing-multiples)
### Sum of an Arithmetic Series
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

### Sum of Squares
`(n * (n + 1) * (2 * n + 1)) / 6.0`
**This formula is equal to: 1^2 + 2^2 + 3^2 + ... + n^2**
There are similar formulas for exponents greater than 2. Such as the "Sum of Cubes Formula" and "Faulhaber's Formula" for the sum of the fourth powers. 
### Sum of the First n Natural Numbers
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
### Permutation Without Repetition
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
### Combinations Without Repetition
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
### Palindrome of a Number
All palindromes are divisible by **11**.
Proof using 1111:
P = 1000x + 100y + 10y + x
P = 1001x + 110y
P = **11**(91x + 11y)
### Finding Products of a Number
All products of a number can be found by checking numbers **1 to √n**
Example: Find all factors of 100.
√100 = 10
[1, <span style="color:Tomato">2</span>, <span style="color:SlateBlue">4</span>, <span style="color:MediumSeaGreen">5</span>, <span style="color:DodgerBlue">10</span>, <span style="color:DodgerBlue">10</span>, <span style="color:MediumSeaGreen">20</span>, <span style="color:SlateBlue">25</span>, <span style="color:Tomato">50</span>, 100]

### Least Common Multiple
The smallest number that two or more numbers can divide into evenly
#### Prime Factorization
Every number is a factor of a prime number. Prime factorization involves breaking down numbers into their prime factors then calculating the least common multiple. The solution requires a list of all prime numbers less than and equal to the factor.
Solution:
1) Find the greatest prime factors of each multiple
2) Multiple the prime factors

```
// prime numbers
p = [1, 2, 3, 5, 7, ..., 97]
// greatest factor
f = [0, 0, 0, 0, 0, ..., 0] // must be same size as prime numbers array

// For each multiple
   // Calculate all prime factors of p[i] ≤ n
   // p[i]^f[i] = n can be re-written as f[i] = log(n) / log(p[i]).
   // f[i] must be an integer so round down f[i] = floor(log(n) / log(p[i]))

// After you've found the greatest value of f[i] for all multiples
greatestPrimeFactor = 1
for(int i = 0; i < p.size(); i++)
   greatestPrimeFactor *= p[i]^f[i]
```
[For more information](https://projecteuler.net/overview=0005)
[Code Solution](https://github.com/Jeff-Enriquez/CodingChallenges/blob/main/ProjectEuler/SmallestMultiple/SmallestMultiple.java)
#### Listing Multiples
Solution given 6 and 4:
1. List the factors of the both numbers
	6 = [1, 2, 3, 6], 4 = [1, 2, 4]
2. Identify the greatest common factor (GCF)
	2
3. Multiply the given numbers: 6, 4
	24 = 6 * 4
4. Divide the multiple *24* by the GCF
	12 = 24 / 2
5. Answer = 12
[Code Solution](https://github.com/Jeff-Enriquez/CodingChallenges/blob/main/ProjectEuler/SmallestMultiple/SmallestMultiple.java)