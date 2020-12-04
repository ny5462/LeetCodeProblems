/** program to check whether a lemonade seller is able to give everyone proper change for every transaction, where each lemonade costs 5, one can either pay using 5, 10, or 20, and receive proper change.
Done using if else statements , by maintaining a count of 5's and 10's
TC-O(N)
**/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int collect=0;
        int Fcount=0;
        int Tcount=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                collect+=5;
                Fcount+=1;
            }
            else if(bills[i]!=5&&(collect<(bills[i]-5)||Fcount==0))return false;
            else if(bills[i]==10){
                collect+=5;
                Fcount-=1;
                Tcount+=1;                
            }else if(bills[i]==20){
                if(Tcount==0){
                    Fcount-=3;
                }else{
                    Tcount-=1;
                    Fcount-=1;
                }
                if(Tcount<0||Fcount<0)return false;
                collect+=5;
            }
            
    }return true;
        
    }
}
