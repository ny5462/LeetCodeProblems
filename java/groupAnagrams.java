/** program to group anagrams, done by using hashmap of sorted string, and values as list of match strings, as two anagrams when sorted would be same string.
TC-O(NKlogK)
credits- https://leetcode.com/problems/group-anagrams/solution/
**/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map=new HashMap<>();
        for(String str:strs){
            char[]c=str.toCharArray();
            Arrays.sort(c);
            String key=String.valueOf(c);
            if(!map.containsKey(key))map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
    
}
