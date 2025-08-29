import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank){
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(end)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.offer(start);
        visited.add(start);

        int level = 0;
        char[] genes = {'A','C','G','T'};

        while(!que.isEmpty()){
            int size = que.size();

            while(size-- > 0){
                String curr = que.poll();

                if(curr.equals(end)){
                    return level;
                }

                char[] arr = curr.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char old = arr[i];
                    for(char ch : genes){
                        if(ch == old) continue;
                        arr[i] = ch;
                        String nbr = new String(arr);

                        if(!visited.contains(nbr) && bankSet.contains(nbr)){
                            visited.add(nbr);
                            que.offer(nbr);
                        }
                    }
                    arr[i] = old;
                }
            }

            level++;
        }

        return -1;
    }
}
