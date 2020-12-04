/**
Reverse an Integer if it falls outside the limit, return 0
TC-O(n)
**/

class Solution {
    public int reverse(int x) {
        String num="";
        int number;
        String strx=""+x;
        if(strx.startsWith("-")){
            num+="-";
            for(int i=strx.length()-1;i>0;i--){
            num+=strx.charAt(i);
        }      
        }
        else{
        for(int i=strx.length()-1;i>=0;i--){
            num+=strx.charAt(i);
        }
          
        }
        try{
        number=Integer.parseInt(num);
        }
        catch(Exception e){
            return 0;
        }
        return number;
    }
}



/**
Reverse an Integer if it falls outside the limit, return 0
TC-O(log n)
involves taking the last bit off and storing it , and reducing input by 10 every instance
while storing in a different variable the last bit and multiplying by 10 every iteration to
add remainder
**/
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
