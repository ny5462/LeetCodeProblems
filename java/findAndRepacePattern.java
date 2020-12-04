/** program to find a pattern in the strings that matches with a given pattern and return such strings whih match the patter.
TC-O(A) where A is the total length of all strings.
**/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].length()==pattern.length()){
                if(match(words[i],pattern))ans.add(words[i]);
            }
        }
        return ans;
    }
    
    public boolean match(String a ,String b){
       HashMap<Character,Character> map= new HashMap<>();
       HashMap<Character,Character> bmap=new HashMap<>();
       for(int i=0;i<a.length();i++){
           char c=(char)a.charAt(i);
           if((map.containsKey(c)&&map.get(c)!=b.charAt(i))||(bmap.containsKey(b.charAt(i))&&bmap.get(b.charAt(i))!=c))return false;
           else{
               map.put(c,b.charAt(i));
               bmap.put(b.charAt(i),c);
           }
           
       }
        return true;
        
    }
}
