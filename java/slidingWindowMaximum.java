/**given a sliding window of size k, it slides from left to right, return the maximum element of each sliding window as it slides.
Done using treemap and two pointers, we keep the value and frequency of each element, once frequency is zero ,we remove it from the map.
TC-O(nlogn)
**/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1)return nums;
        
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>((a,b)-> b-a);
        
        for(int i=0;i<k;i++){
            int key=nums[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        ans.add(map.firstKey());    
        
        int i=0,j=k-1;
        while(j<nums.length){
            j++;
            if(j<nums.length){
            int add=nums[j];
            map.put(add,map.getOrDefault(add,0)+1);
            }
            int remove=nums[i++];
            int val=map.get(remove);
            if(val==1){
                map.remove(remove);
            }else{
                map.put(remove,val-1);
            }if(j<nums.length)ans.add(map.firstKey());       
        }
       // ans.remove(ans.size()-1);
        
        int[] arr=new int[ans.size()];
        for(int x=0;x<arr.length;x++){
            arr[x]=ans.get(x);
        }return arr;
    }
}
