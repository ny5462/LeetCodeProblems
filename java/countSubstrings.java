/** program to count all possible palindromic substrings in a string. Done using traversal of different ranges, or slabs to iterate the string, and checking every slab for palindrome string.
TC-O(N^3)
**/
class Solution {
    public int countSubstrings(String s) {
        if(s=="")return 0;
        int count=0;
        int N=s.length();
        int range=1;
        while(range!=N){
            for(int i=0;i+range<=N;i++){
                if(isPalindrome(s.substring(i,i+range)))count++;
            }
            range++;
        }
        if(isPalindrome(s))count++;
        return count;
        
    }
    public boolean isPalindrome(String a){
        if(a.length()==1)return true;
        for(int i=0,j=a.length()-1;i<=j;i++,j--){
            if(a.charAt(i)!=a.charAt(j))return false;
        }
        return true;
    }
}

/**much better solution 
credits- https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome
worst case TC-O(N^2)
**/
class Solution{
	public int countSubstrings(String s){
	   int count=0;
	   for(int i=0;i<s.length();i++){
	   	count+=extractPalindromes(s,i,i); // odd length pals
	   	count+=extractPalindromes(s,i,i+1); //even length pals
	   	}
   	return count;
	}
	
	
	public int extractPalindromes(String s,int left,int right){
		 int count=0;
		 while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
		 		left--;
		 		right++;
		 		count++;
		 	
		 }
		 return count;
		}
		
}
