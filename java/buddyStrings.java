 /** program to find if two strings can be equal after 2 swaps.
Approach 1 done using 2 hashmaps and comparing hashmaps and count of difference in characters.
Approach 2 done using int[] arrays of characters, and keeping a count of diffrence in chars at every index. diffrence can either be 0 or 2. if differnce is 2, the count arrays of both strings or both hashmaps should be equal. If difference is 0, at lease 1 character should be repeated.
TC-O(2N)
**/
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()<2||B.length()<2||A.length()!=B.length())return false;
       HashMap<Character,Integer> m1=new HashMap<>();
         HashMap<Character,Integer> m2=new HashMap<>();
        boolean flag=false;
        int diff=0;
        for(int i=0;i<A.length();i++){
            char a=A.charAt(i);
            char b=B.charAt(i);
            m1.put(a,m1.getOrDefault(a,0)+1);
             m2.put(b,m2.getOrDefault(b,0)+1);
            if(m1.get(a)>1||m2.get(b)>1)flag=true;
            if(a!=b)diff++;       
        }
        if(diff>2)return false;
        else if(m1.equals(m2)&&diff==2)return true;
        else if(diff==0&&flag==true)return true;
        return false;       
    }
}



/** approach 2 faster **/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()<2||B.length()<2||A.length()!=B.length())return false;
        int[] c1=new int[26];
        int[] c2=new int[26];
        boolean flag=false;
        int diff=0;
        for(int i=0;i<A.length();i++){
            char a=A.charAt(i);
            char b=B.charAt(i);
            c1[a-'a']+=1;
            c2[b-'a']+=1;    
            if(c1[a-'a']>1||c2[b-'a']>1)flag=true;
            if(a!=b)diff++;       
        }
        if(diff==0&&flag==true)return true;
        if(diff==2)return Arrays.equals(c1,c2);
        else return false;
        
    }
}
