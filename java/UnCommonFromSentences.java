/** program to find uncommon words from sentences.
Approach 1 using 2 hashmaps and traversal
Approach 2 using 1 Hashmap and traversal
TC-O(N+M) ,i.e length of 2 strings
**/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String str="";
        String[] a=A.split(" ");
        String[] b=B.split(" ");
        HashMap<String,Integer> m1=new HashMap<>();
        HashMap<String,Integer> m2=new HashMap<>();
        for(String word:a){
            m1.put(word,m1.getOrDefault(word,0)+1);
        }
        for(String word:b){
                m2.put(word,m2.getOrDefault(word,0)+1);
        }
        for(String key:m1.keySet()){
            if(!(m2.containsKey(key))&&m1.get(key)==1)
                str+=key+" ";
        } 
         for(String key:m2.keySet()){
            if(!(m1.containsKey(key))&&m2.get(key)==1)
                str+=key+" ";
        } 
        if(str=="")return new String[0];
        str=str.substring(0,str.length()-1);
        return str.split(" ");
}
}

/** faster to use an arraylist rather than appending to string **/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> res=new ArrayList<>();
        String[] a=A.split(" ");
        String[] b=B.split(" ");
        HashMap<String,Integer> m1=new HashMap<>();
        for(String word:a){
            m1.put(word,m1.getOrDefault(word,0)+1);
        }
        for(String word:b){
                m1.put(word,m1.getOrDefault(word,0)+1);
        }
        for(String key:m1.keySet()){
            if(m1.get(key)==1)
                res.add(key);
        }
        return res.toArray(new String[res.size()]);
}
}
