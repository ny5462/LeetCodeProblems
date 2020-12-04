/** program to fit in an array nos which satisfy condition that, when "I" is read, a[i]<a[i+1].
if "D" is read, a[i]>a[i+1]. Done using 2 counters of big and small, where big starts with string length, and keeps decrementing , and small starts with zero and keeps incrementing.
TC-O(N)
**/
class Solution {
    public int[] diStringMatch(String S) {
        int[] arr=new int[S.length()+1];
        int big=S.length();
        int small=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='I'){
                arr[i]=small;
                small++;
            }else{
                arr[i]=big;
                big--;
            }
        }
        if(S.charAt(S.length()-1)=='D'){
            arr[S.length()]=big;
        }else{
            arr[S.length()]=small;
        }
        return arr;
    }
}
