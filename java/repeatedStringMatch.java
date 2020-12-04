/** program to find repeated String matches of B in A, if it occurs. i.e by repeating a multiple times, if it contains b, return the no of times it was repeated.
TC-O(MN)
**/
class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb=new StringBuilder();
        if(A.equals(B))return 1;
        int lenA=A.length();
        int lenB=B.length();
        int count=1;
        if(lenA>lenB){
            if(A.contains(B))return 1;
            else if((A+A).contains(B))return 2;
            return -1;
        }else{
            count=lenB/lenA +2;
            for(int i=1;i<=count;i++){
                sb.append(A);
                if(sb.toString().contains(B)){
                    return i;
                }
            }
            }
        return -1;
    }
}

/** approach 2 using the ad hoc approach taken from https://leetcode.com/problems/repeated-string-match/solution/**/
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
}
