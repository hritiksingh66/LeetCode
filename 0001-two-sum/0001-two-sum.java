/*Companies LIST :
    
    Acolite , Amazon , Microsoft, Infosys , Zoho , Flipkart , Morgan Stanley,
    FactSet, Hike , ABCO , Wipro , SAP Labs , CarWale
    
*/
    
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            int remaining = target -nums[i];
            
            if(mp.containsKey(remaining)){
                ans[0] = mp.get(remaining);
                ans[1] = i;
                break;
            }
            mp.put(nums[i],i);
        }
        return ans;
    }
}