class Solution {
    public String largestNumber(int[] nums){

        int n = nums.length;
        String element[] = new String[n];

        for(int i = 0; i < n; i++){
            element[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(element , new Comparator<String>(){

            public int compare(String a , String b){
                String first = a+b;
                String sec = b+a;
                return sec.compareTo(first);
            }
        });

        if(element[0].equals("0")){
            return "0";
        }

        String ans = "";

        StringBuilder sb = new StringBuilder();

        for(String val : element){
            sb.append(val);
        }

        return sb.toString();
        
    }
}