/**
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
output :"wertf"

All approaches break the problem into three steps.

    Extracting dependency rules from the input. For example "A must be before C", "X must be before D", or "E must be before B".
    Putting the dependency rules into a graph with letters as nodes and dependencies as edges (an adjacency list is best).
    Topologically sorting the graph nodes.

We encourage you to go and have another go at implementing these steps yourself if you think you now know what to do. If this all sounded overwhelming and confusing though, don't panic, because we're going to work through it all in detail.
credits -https://leetcode.com/problems/alien-dictionary/solution/
**/
class Solution {
    public String alienOrder(String[] words) {
    	//adjacency list of all characters and map of count of each character
        Map<Character,List<Character>> adjList=new HashMap<>();
        Map<Character,Integer>  counts=new HashMap<>();
        
        //adding adjacency list and count map key only
        for(String word:words){
            for(char c:word.toCharArray()){
                counts.put(c,0);
                adjList.put(c,new ArrayList<>());
            }
        }
        
        // traversing two words at a time to check for character difference,then filling maps
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            // char which separates two words , if word2 is prefix of word1 , invalid
            if(word1.length()>word2.length()&& word1.startsWith(word2)){
                return "";
            }
            
            // filling when char differs
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j),counts.get(word2.charAt(j))+1);
                    break;
                }
            }
        }
            // performing bfs topological sort by first adding to queue chars with 0 indegrees
            StringBuilder sb= new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for(Character c: counts.keySet()){
                if(counts.get(c)==0){
                    queue.add(c);
                }
            }
            //adjusting count by adding to queue ele with 0 indegrees
            while(!queue.isEmpty()){
                Character c=queue.remove();
                sb.append(c);
                for(Character next: adjList.get(c)){
                    counts.put(next,counts.get(next)-1);
                    if(counts.get(next)==0){
                        queue.add(next);
                    }
                }
            }
            
        if(sb.length() < counts.size()){
            return "";
        }
        
        return sb.toString();
        } 
    }

