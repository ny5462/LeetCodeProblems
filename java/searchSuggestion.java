/**
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]

Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]

Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]

Done using Trie , we first sorted all the words in lexicographical order, then as we insert, for every letter we encounter, we maintain a linked list of three words that contain the letters encountered till then.

credits - https://leetcode.com/problems/search-suggestions-system/discuss/436151/JavaPython-3-Simple-Trie-and-Binary-Search-codes-w-comment-and-brief-analysis.
TC- O(length of longest word)
**/
class Solution {
    
    class Trie{
        Trie[] sub=new Trie[26];
        LinkedList<String> suggestion=new LinkedList<>();
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie root=new Trie();
        for(String p:products){
            insert(p,root);
        }
        return search(searchWord,root);
        
    }
    
    public void insert(String p, Trie root){
        Trie t=root;
        for(char c:p.toCharArray()){
            if(t.sub[c-'a']==null)t.sub[c-'a']=new Trie();
            t=t.sub[c-'a'];
            if(t.suggestion.size()<3){	//filling linked list upto the seen letters
                t.suggestion.offer(p);
            }      
            
        }
    }
    
    public List<List<String>> search(String searchword,Trie root){
        List<List<String>> ans=new ArrayList<>();
        for(char c:searchword.toCharArray()){
            if(root!=null)
                root=root.sub[c-'a'];
            ans.add(root==null ? Arrays.asList() : root.suggestion); // giving suggestion LL
            
        }
        return ans;
    }
}

