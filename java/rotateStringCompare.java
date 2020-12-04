/** program to find whether string A can be rotated to find string B. Done By adding A to A and check if it contains substring B, also A and B must be of same length.
credits for algorithm https://leetcode.com/problems/rotate-string/solution/.
TC-O(N^2)**/
class Solution {
    public boolean rotateString(String A, String B) {
       return A.length()==B.length()&&(A+A).contains(B);
}
}
