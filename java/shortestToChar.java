/** program to find the shortest distance to a given character in the string of every character.
Done using string traversals, and storing index of each occurence of given character in a list,
traversing the nearest distance and storing the min distance in the array.
TC-O(N)
**/
class Solution {
    public int[] shortestToChar(String S, char C) {
        int [] arr=new int[S.length()];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(c==C){
                list.add(i);
            }
        }
        
        int near=0;
        for(int i=0;i<arr.length;i++){
            if(list.get(near)==i)arr[i]=0;
            else{
                if(near<list.size()-1){
                int closer=Math.abs(i-list.get(near));
                int further=Math.abs(i-list.get(near+1));
                if(further<closer){
                    arr[i]=further;
                    near++;
                }else{
                    arr[i]=closer;
                }
                    
                    }
                arr[i]=Math.abs(i-list.get(near));
            }
        }
        return arr;
        
    }
}

/** approach 2 a much faster 2 pass approach, by first left to right, then right to left traversal.
Credits-https://leetcode.com/problems/shortest-distance-to-a-character/discuss/343839/java-98-100
TC-O(N)**/
class Solution {
    public int[] shortestToChar(String S, char C) {
        int [] arr=new int[S.length()];
        int distToC=S.length();
        int distToR=S.length();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==C)distToC=0;
            arr[i]=distToC;
             distToC++;
        
            
        }   
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)==C)distToR=0;
            arr[i]=Math.min(arr[i],distToR);
            distToR++;
            
        }
        return arr;      
    }
}
