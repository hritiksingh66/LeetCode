class Solution {
    double eps = 0.01;
    boolean solve(List<Double> cards){
        if(cards.size()==1){
            return Math.abs(cards.get(0)-24.0) <= eps;
        }

        for(int i = 0 ; i < cards.size();i++){
            for(int j = 0 ; j < cards.size() ; j++){
                if(i==j){
                    continue;
                }

                List<Double> temp = new ArrayList<>();

                for(int k = 0 ; k < cards.size() ; k++){
                    if(k != i && k != j){
                        temp.add(cards.get(k));
                    }
                }

                double a = cards.get(i);
                double b = cards.get(j);

                List<Double> possVals = new ArrayList<>(Arrays.asList(a+b,a-b,b-a,a*b));

                if(Math.abs(b) > 0.0){
                    possVals.add(a/b);
                }
                if(Math.abs(a) > 0.0){
                    possVals.add(b/a);
                }

                for(double val : possVals){
                    temp.add(val);

                    if(solve(temp) == true){
                        return true;
                    }

                    temp.remove(temp.size()-1);
                }

            }
        }

        return false;
    }

    public boolean judgePoint24(int[] cards){
        List<Double> nums = new ArrayList<>();

        for(int el : cards){
            nums.add(1.0*el);
        }

        return solve(nums);
    }
}