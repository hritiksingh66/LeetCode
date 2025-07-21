class Solution {
    public String makeFancyString(String s){
        
        StringBuilder str=new StringBuilder();

        char prev=s.charAt(0);

        str.append(prev);

        int freq=1;
        int n = s.length();

        for(int i=1;i < n;i++){

            if(s.charAt(i)!=prev){
                str.append(s.charAt(i));
                prev=s.charAt(i);
                freq=1; 
            }
            else if(s.charAt(i)==prev && freq!=2){
                str.append(s.charAt(i));
                freq=2;
            }   

        }
        return str.toString();
    }
}