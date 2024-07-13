class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions){
        int n = positions.length;

        Integer[] actual_idx = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            actual_idx[i] = i;
        }

        Stack<Integer> st = new Stack<>();

        Arrays.sort(actual_idx, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer> result = new ArrayList<>();
        

        for(int curr_idx : actual_idx){
            if(directions.charAt(curr_idx) == 'R'){
                st.push(curr_idx);
            }else{ // towards left
                while(!st.isEmpty() && healths[curr_idx] > 0){
                    int top_idx = st.peek();
                    st.pop();

                    if(healths[curr_idx] > healths[top_idx]){
                        healths[curr_idx] -= 1;
                        healths[top_idx] = 0;
                    }else if(healths[curr_idx] < healths[top_idx]){
                        healths[top_idx] -= 1;
                        healths[curr_idx] = 0;
                        st.push(top_idx);
                    }else{
                        healths[curr_idx] = 0;
                        healths[top_idx] = 0;
                    }
                }
            }
        }

        for(int i  = 0 ; i < n ; i++){
            if(healths[i] > 0){
                result.add(healths[i]);
            }
        }

        return result;
    }
}