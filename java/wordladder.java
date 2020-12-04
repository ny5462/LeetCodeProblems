/** progrm to find no of steps in which one can reach from a word to dest word, using only one letter change at a time. Done using BFS with
credits-https://leetcode.com/problems/word-ladder/discuss/444447/Java-BFS-less-complicated-that-from-Solution.-With-comments

TC-O(wordlist*minchanges)
**/
class Solution {    
     class Node{
           String word;
           int level;
           public Node(String word,int level){
               this.word=word;
               this.level=level;
           }
       }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q=new LinkedList();
        Set<String> set =new HashSet<>();
        
        if(beginWord==endWord)return 0;
        q.add(new Node(beginWord,0));
        
        while(!q.isEmpty()){
            
            Node word=q.remove();
            
            if(word.word.equals(endWord))return word.level+1;
            
            for(String w:wordList){
                String key=w;
                if(!set.contains(key)&&diff(word.word,w)){
                    q.add(new Node(w,word.level+1));
                    set.add(w);
                    
                }
            }
        }
        return 0;
    }
    
    public boolean diff(String a, String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
               {
                count++;
                if(count>1)return false;
                }
        }
        return count==1;
    }
    
}
