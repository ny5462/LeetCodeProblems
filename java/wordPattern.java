/** program to verify if pattern text and string text follow the exact pattern.
Approach 1 using single hashmap. Storing pattern as character, string in map.
TC-O(N^2)
Approach 2 using 2 hashmaps, as conjugates of key and values for verification. TC-O(N)
**/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map=new HashMap<>();
        char[] ch=pattern.toCharArray();
        String []word=str.split(" ");
        if(word.length!=ch.length)return false;
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i])){
                if(!map.get(ch[i]).equals(word[i]))return false;   
                else {
                    for(char c:map.keySet()){
                        if(map.get(c).equals(word[i])&&(c!=(ch[i]))){
                            return false;
                        }
                    }
                }
            }else{
                for(char c:map.keySet()){
                    if(map.get(c).equals(word[i])&&c!=ch[i])return false;
                }
                map.put(ch[i],word[i]);
            }
        }
        return true;
        }
            
        }
    

/** Approach 2 credits to https://leetcode.com/problems/word-pattern/discuss/326764/O(n)-Java-solution-HashMap
 TC-O(N)
**/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();
        char[] ch=pattern.toCharArray();
        String []word=str.split(" ");
        if(word.length!=ch.length)return false;
        for(int i=0;i<ch.length;i++){
            if(map1.containsKey(ch[i])&&(!(map1.get(ch[i]).equals(word[i]))))return false;
            else if(map2.containsKey(word[i])&&((map2.get(word[i])!=ch[i])))return false;
            map1.put(ch[i],word[i]);
            map2.put(word[i],ch[i]);
        }
        return true;
            
        }
}
    

