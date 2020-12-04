/** program to add 1 to an array of integers, and return the resulting array
TC-O(n) -eg[1,0,0,9] --> [1,0,1,0]
**/
class Solution {
    public int[] plusOne(int[] digits) {
        int [] dig;
        boolean flag=true;
        for(int i=0;i<digits.length;i++){
            if(!(digits[i]==9)){
                flag=false;
            }
        }
        if(flag){
             dig=new int[digits.length+1];
            for(int i=0;i<dig.length;i++){
                if(i==0){
                    dig[i]=1;
                }else{
                    dig[i]=0;
                }               
            }
            return dig;
        }                  
        else{
            if(!(digits[digits.length-1]==9)){
                digits[digits.length-1]=digits[digits.length-1]+1;
                return digits;
            }else{
                int count=digits.length-1;
                while(digits[count]==9){
                    digits[count]=0;
                    --count;
                }
                digits[count]=digits[count]+1;
            }       
            }
        return digits;
        }     
    }
