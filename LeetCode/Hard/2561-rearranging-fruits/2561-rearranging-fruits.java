class Solution {
    public long minCost(int[] basket1, int[] basket2){
        int n = basket1.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(basket1[i],map.getOrDefault(basket1[i],0)+1);
            map.put(basket2[i],map.getOrDefault(basket2[i],0)+1);
        }

        for (Integer value : map.values()) {
            if(value % 2 != 0){
                return -1;
            }
        }

        long res = 0L;
        Arrays.sort(basket1);
        Arrays.sort(basket2);


        for(int i = 0 ; i < n ; i++){
            if(basket1[i] == basket2[i]){
                map.put(basket1[i],map.get(basket1[i])-2);
            }else{
                if(map.get(basket1[i])==0 || map.get(basket2[i])==0){
                    continue;
                }
                if(map.get(basket1[i])%2==0 && map.get(basket2[i])%2==0){
                    map.put(basket1[i],map.get(basket1[i])-2);
                    map.put(basket2[i],map.get(basket2[i])-2);
                    res += (long)Math.min(basket1[i],basket2[i]);
                }else if(map.get(basket1[i])%2!=0 || map.get(basket2[i])%2!=0){
                    return -1;
                }
            }
        }



        return res;
    }
}