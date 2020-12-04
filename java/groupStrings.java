/**
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"

Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

Done using hashmap and lists of lists. by using common key for strings with same properties, and shifting characters in each string using caesar cipher, as a result , all similar strings are stuffed in their respective lists , as determined by their keys
TC- O(no of characters in all strings)
**/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strings){
            char [] c=str.toCharArray();
            int shift=c[0]-'a';
            for(int i=0;i<c.length;i++){
                c[i]=(char)((c[i]-shift)%26);
            }
            String temp=String.valueOf(c);
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        List<List<String>> ans= new ArrayList<>();
        for(String list: map.keySet()){
            ans.add(map.get(list));
        }
        return ans;
    }
}
