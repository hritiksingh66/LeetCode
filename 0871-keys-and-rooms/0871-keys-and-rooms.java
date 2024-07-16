class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         Stack<Integer> keys = new Stack<>();
        Set<Integer> set = new HashSet<>();

        set.add(0);
        for(int ele : rooms.get(0)){
            keys.push(ele);
        }

        while(!keys.isEmpty()){
            int key = keys.pop();
            if(!set.contains(key)){
                set.add(key);

                for(int ele : rooms.get(key)){
                    if(!set.contains(ele)){
                        keys.push(ele);
                    }
                }
            }
                
        }

        if(set.size() == rooms.size()) return true;

        return false;
        
    }
}