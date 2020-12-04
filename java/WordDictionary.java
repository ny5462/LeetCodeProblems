/**Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

TC-O(length of word for add)
TC-O(length of search word)
credits- https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/59554/My-simple-and-clean-Java-code
**/
class WordDictionary {

      public class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isWord=false;
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();   
    }
    
  
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.isWord=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char[]  chs, int k, TrieNode node){
        if(k==chs.length) return node.isWord;
        if(chs[k]!='.')
            return node.children[chs[k]-'a']!=null&&match(chs,k+1,node.children[chs[k]-'a']);
        else{
            for(int i=0;i<node.children.length;i++){
                if(node.children[i]!=null &&match(chs,k+1,node.children[i])){
                    return true;
                }
            }
        }
        return false;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
