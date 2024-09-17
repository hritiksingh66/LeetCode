class Solution {
    public String[] uncommonFromSentences(String s1, String s2){
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        Map<String,Integer> wordFreq = new HashMap<>();

        for(String str : str1){
            wordFreq.put(str,wordFreq.getOrDefault(str,0)+1);
        }

        for(String str : str2){
            wordFreq.put(str,wordFreq.getOrDefault(str,0)+1);
        }

        List<String> li = new ArrayList<>();

        for(String s : wordFreq.keySet()){
            if(wordFreq.get(s) == 1){
                li.add(s);
            }
        }
        return li.toArray(new String[0]);
        
    }
}