/** program to add strings, done using stringBuilder 
TC-O(N)
**/
class Solution {
    public String addStrings(String num1, String num2) {
	if(num1==num2&&num1==null)return num1;
        if(num1==null)return num2;
        if(num2==null)return num1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        for(int i =num1.length()-1, j=num2.length()-1; i>=0||j>=0; i--, j--){
            int digit1=0,digit2=0;
            if(i>=0){
             digit1=Character.getNumericValue(num1.charAt(i));
            }
            if(j>=0){
                digit2=Character.getNumericValue(num2.charAt(j));
            }
            if(digit1+digit2+carry<10){
                sb.append(digit1+digit2+carry);
                carry=0;
            }
            if(digit1+digit2+carry>=10){
                String s=""+(digit1+digit2+carry);
                carry=1;
                sb.append(s.charAt(1));
            }
        }
        if(carry==1)sb.append(1);
        return sb.reverse().toString();      
    }
}
