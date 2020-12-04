/** program to find shortest word containing all the letters in the license plate.
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
Done using frequency map of license plate, iterating through word list to look for smallest word, containing all the letters of map.
TC-O(N*length of longest word)
**/
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map=new int[26];
        for(char s:licensePlate.toCharArray()){
            if(Character.isLetter(s)){
                s=Character.toLowerCase(s);
                map[s-'a']+=1;
            }
        }
        String answer="";
        for(String word:words){
            boolean accept=true;
            int [] temp=new int[26];
            for(char c:word.toCharArray()){
                temp[c-'a']+=1;
            }
            for(int i=0;i<map.length;i++){
                if(map[i]>=1){
                    try{
                    if(temp[i]<map[i]){
                        accept=false;
                        break;
                    }
                }catch(Exception e){
                        accept=false;
                        break;
                    }
            }
              
        }
            if(accept&&answer==""){
                answer=word;
            }else if(accept&&answer.length()>word.length()){
                answer=word;
            }
    }
        return answer;
}
}
