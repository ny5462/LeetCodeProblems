/** program to arrange deck such that In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.
Done using deque, where the indexes are stored, after sorting the deck, one index is retrieved and added in the answer, the other index is added to the back of the deque.
Credits-https://leetcode.com/problems/reveal-cards-in-increasing-order/solution/
TC-O(NlogN)
**/
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
     int N=deck.length;
        int[] ans=new int[N];
        Deque<Integer> d=new LinkedList();
        //storing indices in deque 
        for(int i=0;i<N;i++){
            d.add(i);
        }
        // sorting the input deck
        Arrays.sort(deck);
        
        for(int card:deck){
            ans[d.pollFirst()]=card;
            if(!d.isEmpty()){
                d.add(d.pollFirst());
            }
        }
        return ans;
    }
}
