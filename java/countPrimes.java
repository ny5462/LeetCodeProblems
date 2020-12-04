/** program to find prime no of primes numbers less than a specific number. Done using sieve of eratosthenes algorithm, using a boolean array, iterating till square root of a number, and slashing
their multiples as false.
Code derived from https://leetcode.com/problems/count-primes/discuss/315151/Java(sieve-of-eratosthenes)-faster-than-95-solutions .
TC-O(N)
**/
class Solution {
    public int countPrimes(int n) {
    if(n<2)System.exit(0);
    boolean bool[]=new boolean[n+1];
    for(int i=0;i<bool.length;i++)
        bool[i]=true;
    for(int i=2;i*i<=n;i++){
        if(bool[i]==true){
            for(int j=i*i;j<=n;j+=i)
                bool[j]=false;
       
        }
    }
    int count=0;
    for(int i=2;i<n;i++){
        if(bool[i]==true){
            count++;
        }
    }
    return count;
    
    }
}
