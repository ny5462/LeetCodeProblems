/** add binary strings and return the resultant string
TC- O(n)
Code derived from Yasmin's Code https://leetcode.com/problems/add-binary/discuss/312536/Java-Solution **/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
       int carry=0;
        for(int i=a.length()-1, j=b.length()-1 ;i>=0||j>=0;i--,j--){      
            int digit1=0;
            int digit2=0;
            if(i>=0){
                digit1=Character.getNumericValue(a.charAt(i));
            }
            if(j>=0){
                digit2=Character.getNumericValue(b.charAt(j));
            }
            if(digit1+digit2+carry<2){
                sb.append(digit1+digit2+carry);
                carry=0;
            }else{
                sb.append(digit1+digit2+carry-2);
                carry=1;
            }
        }if(carry==1)sb.append(1);
        return sb.reverse().toString();
}
}
