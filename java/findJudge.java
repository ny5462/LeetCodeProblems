/** program to find judge in a town of 2 dim array, where In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
Done by maintaining an array of count of trusts ,each individual gives, since judge doesn't trust anyone, its count will be zero, so we can check for 2nd condition.
Then iterating over trust array, maintaining a trust count of the suspected number,i.e looking at the no of trusts received by the suspected number.
If the count is one less than total individuals, it is the town judge.
TC- O(N*trust.length)
**/
class Solution {
    public int findJudge(int N, int[][] trust) {
        int [] person=new int[N+1];
        for(int i=0;i<trust.length;i++){
            person[trust[i][0]]+=1;
        }
        int trust_c=0;
        int cand=0;
        for(int p=1;p<=N;p++){
            if(person[p]==0){
                cand=p;
                for(int i=0;i<trust.length;i++){
                    if(trust[i][1]==p)trust_c++;
                }
            }
        }
        if(trust_c==N-1)return cand;
        else return -1;
    }
}

