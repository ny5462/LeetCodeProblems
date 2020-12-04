/** program to find words in a given array of words , whose every character is present in 
the same row of the keyboard. Done using hashmap, using values as row no, keys as character.
TC-O(N*length of Word)
**/
class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character,Integer> map=new HashMap<>();
        String str="";
        char[] row1=new char[]{'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'};
        char[] row2=new char[]{'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'};
        char [] row3=new char[]{'z','x','c','v','b','n','m','Z','X','C','V','B','N','M'};
        for(char ch:row1)
            map.put(ch,1);
        for(char ch:row2)
            map.put(ch,2);
        for(char ch:row3)
            map.put(ch,3);
        for(String word:words){
            char[]ch=word.toCharArray();
            int row=map.get(ch[0]);
            String temp="";
            for(char c:ch){
                if(map.get(c)!=row){
                    temp="";
                    break;
                }
                else{
                    temp+=c;
                }                
            }
            if(temp!="")str+=temp+" ";
            
            }
        if(str=="")return new String[0];
        return str.split(" ");
        }
            
    }


