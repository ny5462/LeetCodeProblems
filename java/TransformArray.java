/** transform array till not transformable , by rules that if an element is smaller than its neighbours , increment it by 1, and if bigger by both, decrement by 1.
TC-O(N*C)
**/
class Solution {
    public List<Integer> transformArray(int[] arr) {
         List<Integer> list=new ArrayList<>();
        if(arr.length<2){
            for(int i: arr)list.add(i);
            return list;
        }
       
        while(true){
            int p=arr[0],t=0;
            boolean check=true;
            for(int i=1;i<arr.length-1;i++){    
                t=arr[i];
                if(p>arr[i]&&arr[i]<arr[i+1]){
                    arr[i]=arr[i]+1;
                    check=false;
                }
                else if(p<arr[i]&&arr[i]>arr[i+1]){
                    arr[i]=arr[i]-1;
                    check=false;
                }
                p=t;               
            }
            if(check){
                for(int i:arr) list.add(i);
                break;
            }
        }
        return list;
    }
}
