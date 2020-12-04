/**
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701

Done by maintaining a variable for sum, iterating from behind the string, as soon as we move towards the front.
TC-O(N)
**/
class Solution {
    public int titleToNumber(String s) {
        int val=0;
        for(int i=s.length()-1;i>=0;i--){
            int diff=s.charAt(i)-'A';
            val+=(diff+1)*(Math.pow(26,(s.length()-i-1)));			//ZY=(26*26^1) + (25*26^0) 
            									
        }
     return val;                               
    }
}

 
