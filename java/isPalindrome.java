/** check for alphanumeric palindrome, spaces can be neglected
eg -"hi" ==" I H"
TC- O(N)
using stringbuilder , adding the lowercased string to sb, then iterating
through sb to check for symmetry
**/
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0||s.length()==1)return true;
        s=s.toLowerCase();
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>=97&&s.charAt(i)<123)||(s.charAt(i)>=48 &&s.charAt(i)<=57)){
                sb1.append(s.charAt(i));
            }
        }
            //System.out.print(sb1);
           for(int i=0;i<sb1.length()/2;i++){
            if(!(sb1.charAt(i)==sb1.charAt(sb1.length()-1-i))){
                return false;
            }
        }
    
        return true;
               }
             
               }
