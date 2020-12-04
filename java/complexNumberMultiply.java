/** program to multiply two complex nos, given as strings, and return their output as string.
Done using splitting their real and complex parts, and putting them in their multiplication formula, by parsing strings to integers.
TC-O(N)
**/
class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] num1=a.split("\\+",2);
        String[] num2=b.split("\\+",2);
        int realA=Integer.parseInt(num1[0]);
        int realB=Integer.parseInt(num2[0]);
        int complexA=Integer.parseInt(num1[1].substring(0,num1[1].length()-1));
        int complexB=Integer.parseInt(num2[1].substring(0,num2[1].length()-1));
        return ((""+(realA*realB+complexA*complexB*-1))+"+"+(realA*complexB+realB*complexA)+"i");
    }
}
