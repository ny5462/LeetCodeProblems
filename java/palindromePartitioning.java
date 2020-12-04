/**Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

Done by backtracking, we perform dfs on the string starting from first letter, we check if it is palindrome, then we add its substring in the list, then we put the remaining string for dfs, we only add it to the answer list when we reach the end of the string and the last character has verified the remaining string to be part of the palindrome. We add the clone of the list, not the actual list, since we have to find all such pairs, we return to the parent recursion node, and delete the last substring added, so that recursion with another variation continues ahead.
credits -  up the hell's post from https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java%3A-Backtracking-solution.
TC-N.2^N
**/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(ans, s,0,list);
        return ans;
    }
    
    public void dfs(List<List<String>> ans, String s, int pos, List<String> list){
        if(pos == s.length()) ans.add(new ArrayList<>(list));  //adds clone of the list if end of string is reached, valid partition
        else{
        //iterates through the remaining string, and checks if it finds a palindromic substring
            for(int i=pos;i<s.length();i++){	
                if(isPal(s,pos,i)){
                // if pal substring is found it is added and continue with dfs with remaining string
                    list.add(s.substring(pos,i+1));
                    dfs(ans,s,i+1,list);
                    // remove previous iteration from list to find a new combination if possible
                    list.remove(list.size()-1);
                }
            }
        }
    }
    
    public boolean isPal(String s , int low, int high){
        while(low<high)if(s.charAt(low++)!=s.charAt(high--))return false;
        return true;
    }
}
