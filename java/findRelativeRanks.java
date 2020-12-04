/** program to find relative ranks of players according to their scores, with top 3 getting their respective medals. Done by putting scores and index as key,value pairs in a tree map. Tree map sorts the keyset according to score, so lowest score is read first. It is then addded to a string array by iterating and fetching index from map of the given score, as ranking is obtained in descending order of iteration.
TC-(LogN). N being no of scores.
**/
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        String[] str=new String[nums.length];
        int rank=nums.length;
        for(Integer score: map.keySet()){
            if(rank==3)str[map.get(score)]="Bronze Medal";
            else if(rank==2)str[map.get(score)]="Silver Medal";
            else if(rank==1)str[map.get(score)]="Gold Medal";
            else{str[map.get(score)]=String.valueOf(rank);}
            rank--;
         
        }
        return str;
        }
    
}
