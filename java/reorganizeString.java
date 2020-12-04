/** program to reorganize string such that no two adjacent characters are same, done using priority queue of characters and their frequencies, if such a string is not possible return ""
O(NlogA)
**/
class Solution {
    public String reorganizeString(String S) {
       int [] letters=new int[26];
        for(char c:S.toCharArray()){
            letters[c-'a']+=1;
            if(letters[c-'a']>maxCount){
                maxCount=letters[c-'a'];
                maxIndex=c-'a';
            }
        }
        
        if(maxCount>(S.length()+1)/2)return "";
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(letters[i]>0){
                pq.add(new int[]{i,letters[i]});
            }
        }
        
        StringBuilder sb=new StringBuilder();
        while(sb.length()!=S.length()){
            int[] first=pq.poll();
            int[]second=new int[0];
            if(sb.length()>0&&first[0]==sb.charAt(sb.length()-1))return "";
          //  System.out.println((char)(first[0]+97));
            sb.append((char)(first[0]+97));
            first[1]-=1;
            if(pq.size()!=0){
                second=pq.poll();
                sb.append((char)(second[0]+97));
                second[1]-=1;
            }
            if(first[1]>0)pq.add(first);
            if(second.length>0&&second[1]>0){
                pq.add(second);
            }
        }
        return sb.toString();
        
    }
}
