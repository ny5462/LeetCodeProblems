/**
This program finds the longest commone prefix in an array of strings
first handles case where array is empty or has one element
Otherwise, checks for smallest element in array.
uses nested for loop with length of smallest element at outer loop to check
for commonality, if there is rejection, it enters if loop and returns , otherwise
adds to the common variable
TC-O(n^2)
**/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common="";
        if(strs.length==0){
            return common;
        }
        if(strs.length==1){
            return strs[0];
        }
        String first=strs[0];
        String smallest=strs[0];
        int count=0;
        int len= strs[0].length();
        for(int i=0;i<strs.length;i++){
            if(len>strs[i].length()){
                len=strs[i].length();
                smallest=strs[i];
            }
        }
        for (int i=0;i<len;i++){
            for(int j=0;j<strs.length;j++){
                if(smallest.charAt(i)!=strs[j].charAt(i)){
                    return common;
                }

            }
            common+=smallest.charAt(i);
        }
        return common;
    }
        
    }

/**
LeetCode solution O(n^2) with vertical spanning
**/
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
