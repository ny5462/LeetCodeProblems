/** program to rearrange array so that no two adjacent numbers are same. Done using hashmap and priorityqueue, maintaining a frequency of numbers. taking top 2 most occuring elements first and rearranging them from heap till and adding them again after decreasing the count.
O(NlogN)
**/
   
class Solution {
   
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int [] ans=new int[barcodes.length];
        
        for(int i: barcodes){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<int[]> fm= new PriorityQueue<>((a,b)-> b[0]-a[0]);
        for(int i:map.keySet()){
            fm.add(new int[]{map.get(i),i});
        }
        int count=0;
        while(count!=barcodes.length){
            int[] first=fm.poll();
            int [] second=new int[0];
            ans[count++]=first[1];
            if(count<barcodes.length){
                second=fm.poll();
                ans[count++]=second[1];         
            }
            first[0]-=1;
            if(first[0]>0)fm.add(first);
            if(second.length!=0){
                second[0]-=1;
                if(second[0]>0)fm.add(second);
            }
            
            
        }
        return ans;
        
    }
    
}
