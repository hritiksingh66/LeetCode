class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ; i >=0 ; i--){
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],nums2[st.peek()]);
            }

            st.push(i);
        }

        int[] ans = new int[nums1.length];
        int i = 0;
        for(int num : nums1){
            ans[i++] = map.get(num);
        }

        return ans;
    }
}