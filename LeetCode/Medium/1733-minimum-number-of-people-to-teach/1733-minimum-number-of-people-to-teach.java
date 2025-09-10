class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships){
        Set<Integer> sadUser = new HashSet<>();

        for(int[] frnd : friendships){
            int frnd1 = frnd[0] - 1;
            int frnd2 = frnd[1] - 1;

            Set<Integer> frnd1known = new HashSet<>();
            // insert the languages known by friend1 into set
            for(int lang : languages[frnd1]){
                frnd1known.add(lang);
            }

            boolean isCommon = false;

            for(int lang : languages[frnd2]){
                if(frnd1known.contains(lang)){
                    isCommon = true;
                    break;
                }
            }

            if(!isCommon){
                sadUser.add(frnd1);
                sadUser.add(frnd2);
            }

        }

        int mostKnownLang = 0;
        int[] language = new int[n+1];


        for(int user : sadUser){
            for(int lang : languages[user]){
                language[lang]++;
                mostKnownLang = Math.max(mostKnownLang, language[lang]);
            }
        }

        return sadUser.size() - mostKnownLang;
    }
}