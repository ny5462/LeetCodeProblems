/** program to check if 2 strings are isomorphic, i.e one can replace the another, with change of characters. Done using 2 hashmaps, storing character,character, of both strings. Both hasmaps are tallied at every insertion, if mismatch is found , then not possible.
TC-O(N)
**/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        HashMap<Character,Character> m1=new HashMap<>();
        HashMap<Character,Character> m2=new HashMap<>();
        for(int i=0;i<s1.length;i++){
            if(m1.containsKey(s1[i])&&m1.get(s1[i])!=t1[i])return false;
            else if(m2.containsKey(t1[i])&&m2.get(t1[i])!=s1[i])return false;
            m1.put(s1[i],t1[i]);
            m2.put(t1[i],s1[i]);
        }
        return true;
    }
}

