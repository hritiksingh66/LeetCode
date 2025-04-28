class Solution {
    public int findDigitSum(int num){
        int digitSum = 0;
        while(num > 0){
            digitSum += num % 10;
            num = num/10;
        }

        return digitSum;
    }
    public int countLargestGroup(int n){
        Map<Integer,Integer> map = new HashMap<>();

        int maxSize = 0;
        int count = 0;

        for(int num = 1 ; num <= n; num++){
            int digitSum = findDigitSum(num);
            map.put(digitSum , map.getOrDefault(digitSum,0)+1);

            if(map.get(digitSum) > maxSize){
                maxSize = map.get(digitSum);
                count = 1;
            }else if(map.get(digitSum) == maxSize){
                count++;
            }
        }

        return count;
    }
}