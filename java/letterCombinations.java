/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Done by maintaining a digitmap, which maps the letters with its digits. We maintain an array list and add an empty string to it, then using a helper function ,we iterate the input and we keep on updating the list, by adding to it, all reachable letters for that particular value.
credits- https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8118/Easy-understand-Java-Solution

Time complexity : O(3N×4M)\mathcal{O}(3^N \times 4^M)O(3N×4M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

Space complexity : O(3N×4M)\mathcal{O}(3^N \times 4^M)O(3N×4M) since one has to keep 3N×4M3^N \times 4^M3N×4M solutions.

**/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] digitmap=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0)return result;
        result.add("");
        
        for(int i=0;i<digits.length();i++){
            result=combine(digitmap[digits.charAt(i)-'0'], result);
        }
        return result;
        
    }
    
    public List<String> combine(String digit, List<String> l){
        List<String> result= new ArrayList<>();         
        for (int i=0; i<digit.length(); i++) 
            for (String x : l) 
                result.add(x+digit.charAt(i));
        return result;
    }
}
