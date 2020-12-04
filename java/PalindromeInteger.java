/**
checking whether an integer is a palindrome , done without using strings
TC- O(log n)
first rejects negative number.
Reverses integer, compares original with reversed, if equal, then palindrome.
**/
class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        int temp=x;
        if(x<0){
            return false;
        }
        
        while(x!=0){
            int pop=x%10;
            x/=10;
            rev=rev*10+pop;
        }
        if(temp==rev)
            return true;
        return false;
    }
}
