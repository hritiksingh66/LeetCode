class Solution {
    public int compress(char[] chars){
        int n = chars.length;

        int i = 0;
        int index = 0;

        while(i < n){
            char curr_char = chars[i];
            int  count = 0;

            //Find count of duplicates
            while(i < n && chars[i] == curr_char){
                count++;
                i++;
            }

            //Do the Assigning work

            chars[index++] = curr_char;

            if( count > 1){
                String count_str = Integer.toString(count);
                char[] charArray = count_str.toCharArray();
                for(char ch : charArray){
                    chars[index] = ch;
                    index++;
                }
            }

        }
        return index;
    }
}