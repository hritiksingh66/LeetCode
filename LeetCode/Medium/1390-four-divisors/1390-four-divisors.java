class Solution {
    public int sumFourDivisors(int[] nums){
        int res = 0;
        for(int num : nums){
            int sum = 0;
            int fact_count = 0;
            for(int fact = 1; fact*fact <= num ; fact++){
                if(num % fact == 0){
                    int other_fact = num / fact;

                    if(other_fact == fact){
                        fact_count += 1;
                        sum += fact;
                    }else{
                        fact_count += 2;
                        sum = sum + fact + other_fact;
                    }

                    if(fact_count > 4){
                        break;
                    }
                }
            }

            if(fact_count == 4){
                res += sum;
            }
        }

        return res;
        
    }
}