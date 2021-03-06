/**Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
DOne by looking at the substring , iterating a slice of haystack of length of needle.
**/
class Solution {
    public int strStr(String haystack, String needle) {
        int L=haystack.length();
        int N=needle.length();
        if(needle=="")return 0;
        if(N>L)return -1;
        for(int i=0; i<=L-N;i++){
            if(haystack.substring(i,i+N).equals(needle))return i;
        }
        return -1;
    }
}
