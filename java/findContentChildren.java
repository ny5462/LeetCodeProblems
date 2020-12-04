/** program to assign cookies to children acc to their greed. Done using sorting both the cookie and greed arrays, and if the cookie is greater than or equal to greed, it is given, and both greed array and cookie array
traversed, if cookie< greed, only cookie array is traversed.
Approach 2 done using priority queue
TC-O(NlogN)
**/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        if(g.length==0||s.length==0)return 0;
       Arrays.sort(g);
       Arrays.sort(s); 
       int i=0,j=0;
        while(i<g.length&&j<s.length){
            int greed=g[i];
            int cookie=s[j];
            if(cookie>=greed){
                count++;
                i++;
                j++;
            }
            else if(cookie<greed){
                j++;
            }
        }
        return count;
    }
}

/** using priority queue**/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        if(g.length==0||s.length==0)return 0;
        PriorityQueue<Integer> pqCookie=new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqGreed=new  PriorityQueue<Integer>();
        for(int i:g){
            pqGreed.add(i);
        }
        for(int i:s){
            pqCookie.add(i);
        }
        while(!pqGreed.isEmpty()&&!pqCookie.isEmpty()){
            int greed=pqGreed.poll();
            int cookie=pqCookie.poll();
            if(cookie>=greed){
                count++;
              //  pqCookie.add(cookie-greed);
            }
            else if(cookie<greed){
                pqGreed.add(greed);
            }
        }
        return count;
    }
}
