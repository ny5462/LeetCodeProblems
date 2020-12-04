/** program to relatively sort array1 according to array 2. Done using hashmaps, to store frequency, and then storing matching and unmatching values in arraylists.
TC-O(NlogN)
**/
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<Integer> discard=new ArrayList<>();
        Arrays.sort(arr1);
        int[] fin=new int[arr1.length];
        if(arr2.length==0||arr1.length==0)return arr1;
        for(int i:arr2){
            map.put(i,0);
        }
        for(int i:arr1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                discard.add(i);
            }
        }
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<map.get(arr2[i]);j++){
                list.add(arr2[i]);
            }
        }
        for(int i=0;i<list.size();i++){
            fin[i]=list.get(i);
        }
        for(int i=list.size();i<arr1.length;i++){
            fin[i]=discard.get(i-list.size());
        }
        return fin;
    }
}
