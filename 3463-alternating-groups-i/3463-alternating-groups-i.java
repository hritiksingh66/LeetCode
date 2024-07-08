class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if(colors[i]==colors[(i+2)%n] && colors[i]!=colors[(i+1)%n]) result++;
        }
        return result;
    }
}