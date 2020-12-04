/** program to find index of all anagrams of a string p in a string s. Done using sliding window
approach, where substring was passed in another function. Brute Force low level solution.
TC-O(N^2)
**/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list= new ArrayList<>();
        if(s.length()<p.length())return list;
        for(int i=0;i<=s.length()-p.length();i++){
            String ns=s.substring(i,i+p.length());
            if(Anagram(ns,p))list.add(i);
        }
        return list;
    }
    public boolean Anagram(String s,String p){
        int [] chars=new int[26];
        int [] charsP=new int [26];
        for(char c:p.toCharArray()){
            charsP[c-'a']+=1;
        }
        for(int c:s.toCharArray()){
           chars[c-'a']+=1;
            }
        return Arrays.equals(chars,charsP);
    }
}

/** faster aprproach taken from https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/328848/A-simple-java-solution
**/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pc = new int[26];
        
        int length = p.length();
        for (int i = 0; i < length; i++) {
            pc[p.charAt(i) - 'a']++;
        }
        
        int[] sc = new int[26];
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i) - 'a']++;
            if (i >= length) {
                sc[s.charAt(i - length) - 'a']--;
            }
            
            boolean ana = true;
            for (int j = 0; j < 26; j++) {
                if (pc[j] > sc[j]) {
                    ana = false;
                    break;
                }
            }
            
            if (ana) {
                ans.add(i - length + 1);
            }
        }
        
        return ans;
    }
}
