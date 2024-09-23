class Solution {
    public List<List<String>> groupAnagrams(String[] strs){

        Map<String,List<String>>  map = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String sortedString = new String(ch);

            if(!map.containsKey(sortedString)){
                map.put(sortedString , new ArrayList<>());
            }

            map.get(sortedString).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        ans.addAll(map.values());

        return ans;
    }
}