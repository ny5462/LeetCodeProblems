/** program to check if reconstruction of ransom NOte possible from the magazine
, used two hashmaps for ransom note and magazine each, checked for counts of characters
and compared them. Slow approach as iterating through keys is expensive
TC-O(n^2)
**/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
 	if(ransomNote==null){
            return true;
        }
        if(magazine==null){
            return false;
        }
        HashMap<Character,Integer> ransom=new HashMap<>();
        HashMap<Character,Integer> magazine1=new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            if(ransom.containsKey(ransomNote.charAt(i))){
                ransom.put(ransomNote.charAt(i),ransom.get(ransomNote.charAt(i))+1);
            }
            else{
            ransom.put(ransomNote.charAt(i),1);
            }
        }
        for(int i=0;i<magazine.length();i++){
            if(magazine1.containsKey(magazine.charAt(i))){
                magazine1.put(magazine.charAt(i),magazine1.get(magazine.charAt(i))+1);
            }
            else{
            magazine1.put(magazine.charAt(i),1);
        }
	}
        for(Character key:ransom.keySet()){
            if(!magazine1.containsKey(key))return false;
            if(ransom.get(key)>magazine1.get(key))return false;
        }
        return true;
    }
}

/**
O(N) solution using array derived from https://leetcode.com/problems/ransom-note/discuss/313823/two-java-solution-by-array-and-hash
**/
 public boolean canConstructByArray3(String ransomNote, String magazine) {
        if(ransomNote==null){
            return true;
        }
        if(magazine==null){
            return false;
        }
        int[] nums=new int[26];
        for(char temp:magazine.toCharArray()){
            nums[temp-'a']++;
        }
        for(char temp:ransomNote.toCharArray()){
            int index=temp-'a';
            if(nums[index]==0){
                return false;
            }
            else{
                nums[index]--;
            }
        }
        return true;
    }
