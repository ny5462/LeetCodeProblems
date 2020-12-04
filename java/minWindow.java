/**iven two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Example 2:

Input: s = "a", t = "a"
Output: "a"
Done by using 2 points and 2 hasmaps, first put the string t in a hashmap with its frequency as values.
Now, we iterate the string s using two pointers such that they both start at index 0 and we keeping on moving right till from second pointer till we satisfy the conditions of all characters. Now, after that condition is satsified, we move from the first pointer toward the right to find the minimum such string possible. We move the first pointer as long as the presence of all characters is satisfied, as soons as condition is not met, we again iterate forward from the second pointer.
credits -https://leetcode.com/problems/minimum-window-substring/solution/
TC-O(N)
**/
class Solution {
    public String minWindow(String s, String t) {
    	// if strings are empty return empty string
        if(s.length()==0 || t.length()==0)return "";
        
        // map to store char frequencies of string t and s respectively
        HashMap<Character,Integer> tkeys=new HashMap<>();
        HashMap<Character,Integer> sub=new HashMap<>();
        
        int n=s.length();
        
        // will store the starting, ending, length of smallest matching string and match stores how many characters satisfy
        // the conditions so far
        int start=0, end=0, min=-1, match=0;
        
        // store char frequencies of string t
        for(int i=0;i<t.length();i++){
            char c= t.charAt(i);
            tkeys.put(c,tkeys.getOrDefault(c,0)+1);  
        }
        
        // no of match should equal req for satisfying the conditions of question
        int req=tkeys.size();
        int i=0,j=0;		// left and right pointer
        
        while(j<n){
            char c=s.charAt(j);
            sub.put(c,sub.getOrDefault(c,0)+1);
            // if after reading the right pointer if condition is satisfied for a character we increase match
            if(tkeys.containsKey(c) && sub.get(c).intValue()==tkeys.get(c).intValue()){
                match++;              
            }
            
            // if all characters match we iterate the left pointer till the match sustains inorder to find smallest string
            while(match==req && i<=j){
                char temp=s.charAt(i);
                // storing co-ordinates of minimum string of match
                if(min==-1 || min > j-i+1){
                    start=i;
                    end=j;
                    min=end-start+1;
                }
                // removing character as we move ahead from left pointer
                sub.put(temp,sub.get(temp)-1);
                
                // if conditions is not satisfied after removal of character we will have to get out of this loop
                if(tkeys.containsKey(temp) && sub.get(temp).intValue()<tkeys.get(temp).intValue()){
                    match--;
                }
            
                i++;
            }
            j++;    
            
        }
        return min==-1?"":s.substring(start,end+1);
    }
}
