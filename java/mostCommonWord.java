/** program to find most common word in paragraph, excluding the banned words. Done using hashset and hashmap, and use of regex. Alternatively, a faster approach is used using matcher and pattern class from java.
TC-O(Banned+Paragraph)
credits-https://leetcode.com/problems/most-common-word/discuss/334498/Java-Matcher-and-pattern-solution
**/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Pattern word = Pattern.compile("\\w+");
        Matcher m = word.matcher(paragraph);
        Map<String,Integer> f = new HashMap<>();
        String max = "";
        while(m.find()){
            String w = m.group().toLowerCase();
            if(!ban.contains(w)) {
                int freq = f.getOrDefault(w, 0) + 1;
                f.put(w, freq);
                if (freq > f.getOrDefault(max, 0)) max = w;
            }
        }
        return max;
    }
}

/** alternatively my approach using just regex ,hashmap and hashset**/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.toLowerCase();
        String[] words=paragraph.split("\\W+");
        HashMap<String,Integer> map= new HashMap<>();
        Set<String> set=new HashSet<>();
        for(String i:banned){
            set.add(i);
        }
        int max=Integer.MIN_VALUE;
        String mWord="";
        for(String i: words){
            int len=i.length();
            if(!set.contains(i)){
                map.put(i,map.getOrDefault(i,0)+1);
                int v=map.get(i);
                 if(v>max){
                      max=v;
                     mWord=i;
                  }
        } 
        }
        return mWord;
    }
}
