/** program to find all the digits of a numbers can divide the no itself.
Done using conversion of every digit to a character and iterating and checking for division condition. Brute Force approach.
TC-O(N*length of longest digit)
**/
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numbers=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(i<10)numbers.add(i);
            else{               
                char[] digits=String.valueOf(i).toCharArray();
                for(int j=0;j<digits.length;j++){
                    int num=Character.getNumericValue(digits[j]);
                    if(num==0||i%num!=0)break;
                    else if(j==digits.length-1){
                        numbers.add(i);
                    }
                }
            }
        }
        return numbers;
    }
}

/** faster approach without using strings, but using remainders to check for divisibility conditions
.TC-O(N* length of num)
**/
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numbers=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(i<10)numbers.add(i);
            else{               
               int num=i;
                while(num!=0){
                    int rem=num%10;
                    if(rem==0||i%rem!=0)break;
                    num=num/10;                  
                } 
                if(num==0)numbers.add(i);
                }
        }
        return numbers;
    }
}

