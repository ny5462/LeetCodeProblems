/**A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 

Note:

    S will have length in range [1, 500].
    S will consist of lowercase English letters ('a' to 'z') only.
Done by maintaining the last index of every letter in  a map
Traversing the string to find the lastindex of a substring and adding them to the list.
i.e we traverse and maintain 2 pointers to see for every letter if its the last occurence of it, if yes we add it to the list, but it should also be the last letter of that substring
credits- https://leetcode.com/problems/partition-labels/discuss/113259/Java-2-pass-O(n)-time-O(1)-space-extending-end-pointer-solution
**/

TC- O(N)
class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S==null || S.length()==0)return null;
        List<Integer> list=new ArrayList<>();
        
        int[] map=new int[26];
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a']=i;   
        }
        
        int last=0;
        int start=0;
        for(int i=0;i<S.length();i++){
            last=Math.max(last,map[S.charAt(i)-'a']);
            if(last==i){
                list.add(last-start+1);
                start=last+1;
            }
            
        }
        return list;
    }
}
