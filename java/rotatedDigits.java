/** program to count no of valid roated digits upto a given no. X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
Done using modulus operation and looking for invalid and valid remainders.
TC-O(N*length of number)
Credits- https://leetcode.com/problems/rotated-digits/discuss/352128/Simple-Java-Solution
**/
class Solution {
    public int rotatedDigits(int N) {
        int count=0;
        for(int i=1;i<=N;i++){
            if(isValid(i))count++;
        }
        return count;
    }
    public boolean isValid(int n){
        boolean valid=false;
        while(n>0){
            if(n%10==2||n%10==5||n%10==6||n%10==9)valid=true;
            if(n%10==3||n%10==4||n%10==7)return false;
            n/=10;
        }
        return valid;
    }
}
