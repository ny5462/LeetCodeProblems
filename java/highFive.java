/**
get average of top5 scores for all ids
TC-O(NlogN)
**/
class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        for(int i=0;i<items.length;i++){
            if(!map.containsKey(items[i][0])){
                map.put(items[i][0],new ArrayList<Integer>());
            }
            map.get(items[i][0]).add(items[i][1]);
        }
        int[][]ans = new int[map.size()][2];
        int index=0;
        for(int i:map.keySet()){
            ans[index][0]=i;
            List<Integer> temp=map.get(i);
            if(temp.size()<=5){
                int total=0;
                for(int num:temp){
                    total+=num;
                }
                ans[index][1]=total/temp.size();
            }else{
                Collections.sort(temp,Collections.reverseOrder());
                int total=0;
                for(int ind=0;ind<5;ind++){
                    total+=temp.get(ind);
                }
                ans[index][1]=total/5;
            }    
            index++;
        }
        return ans;
        
    }
}
