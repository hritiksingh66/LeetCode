class Solution {
    public int compareVersion(String version1, String version2){
        String[] v1Rev = version1.split("\\.");
        String[] v2Rev = version2.split("\\.");

        int maxLen = Math.max(v1Rev.length , v2Rev.length);

        for(int i = 0 ; i < maxLen ; i++){
            int a = (i < v1Rev.length) ? Integer.parseInt(v1Rev[i]) : 0;
            int b = (i < v2Rev.length) ? Integer.parseInt(v2Rev[i]) : 0;

            if(a > b){
                return 1;
            }else if(b > a){
                return -1;
            }
        }

        return 0;
    }
}