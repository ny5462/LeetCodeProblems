/** program to sort array of strings using alien alphabetical order. Done using hashmap and comparing the strings using that map.
TC-O(N)
**/
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            if(!(comparator(map,words[i],words[i+1])))return false;
        }
        return true;
    }
    public boolean comparator(HashMap<Character,Integer> map,String a, String b){
        int l1=a.length();
        int l2=b.length();
        int i=0;
        if(l1>l2){
             while(i<l2){
                if(map.get(a.charAt(i))==map.get(b.charAt(i)))i++;
                if(map.get(a.charAt(i))<map.get(b.charAt(i)))return true;
                else return false;
            }        
    }else{
            while(i<l1){
                if(map.get(a.charAt(i))==map.get(b.charAt(i)))i++;
                if(map.get(a.charAt(i))<map.get(b.charAt(i)))return true;
                else return false;
            }
        }
        return true;
                   }
}
