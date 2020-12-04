/**Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.

You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.

 TC-O(N)
 **/
 class Solution {
    public int calculateTime(String keyboard, String word) {
        int prev=0;
        int total=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<keyboard.length();i++){
            map.put(keyboard.charAt(i),i);
        }
        for(int i=0;i<word.length();i++){
            int curr=map.get(word.charAt(i));
            total=total+Math.abs(curr-prev);
            prev=curr;
        }
        return total;
    }
}
