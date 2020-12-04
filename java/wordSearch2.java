/**
find all the words in a board of character array. Done by storing all the words in a trie data structure, then performing dfs on the board along with trie node, if word exists, we add it to the list
TC-O(M*N*4^total characters in all words)
**/
class Solution {
    List<String> l=new ArrayList<>();
    class TrieNode{
        TrieNode[] next= new TrieNode[26];
        String word;
    }
    
    public TrieNode build(String[] words){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode node=root;
            for(char c: word.toCharArray()){
                int i=c-'a';
                if(node.next[i]==null)node.next[i]=new TrieNode();
                node=node.next[i];
            }
            node.word=word;
        }
        return root;
    }
    
    public void dfs(int i, int j, TrieNode root, char[][]board){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#'||root.next[board[i][j]-'a']==null  ){
            return;
        }
        char c= board[i][j];
        root=root.next[c-'a'];
        board[i][j]='#';
        if(root.word!=null){
            l.add(root.word);
            root.word=null;
        }
        
        dfs(i+1,j,root,board);
        dfs(i-1,j,root,board);
        dfs(i,j+1,root,board);
        dfs(i,j-1,root,board);
        board[i][j]=c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=build(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,root,board);
            }
        }
        return l;
    }
    
    
    
}
