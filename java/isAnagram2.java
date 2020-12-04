/** program to find whether 2 strings are anagrams
TC-O(N). approach 1 using hashmaps.
 approach 2 using arrays and counters(faster)
**/

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        for(char ch:s.toCharArray()){
            m1.put(ch,m1.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            m2.put(ch,m2.getOrDefault(ch,0)+1);
        }
        return m1.equals(m2);
    }
}



class Solution {
   public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
}



