/** program to find no of jewels in stones , given two strings,
one with jewels and one with stones, find the no of jewels in the stones.
Done using hashSet.
TC-O(N)
**/
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set=new HashSet<>();
        for(char ch:J.toCharArray()){
            set.add(ch);
        }
        int count=0;
        for(char ch:S.toCharArray()){
            if(set.contains(ch))count++;
        }
        return count;
    }
}
