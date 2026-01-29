class NumArray {
    static int[] segTree;
    static int n;

    public NumArray(int[] nums){
        n = nums.length;

        segTree = new int[4*n];

        buildTree(nums,0,0,n-1);
    }

    void buildTree(int[] nums, int i, int l , int r){
        // Base Case
        if(l==r){
            segTree[i] = nums[l];
            return;
        }

        int mid = (l+r)/2;

        buildTree(nums,2*i+1,l,mid);
        buildTree(nums,2*i+2,mid+1,r);

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    
    public void update(int index, int val){
        updte(index,val, 0, 0, n-1);
    }

    public void updte(int idx , int val, int i, int l, int r){
        if(l==r){
            segTree[i] = val;
            return;
        }

        int mid = (l+r)/2;

        if(idx <= mid){
            updte(idx,val,2*i+1,l,mid);
        }else{
            updte(idx,val,2*i+2,mid+1,r);
        }

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    
    public int sumRange(int left, int right){
        return sum(left,right,0,0,n-1);
    }

    public int sum( int st, int ed, int i, int l, int r){
        // Complete Out Of Bound Case
        if(l > ed || r < st){
            return 0;
        }else if( st <= l && r <= ed){ // entirely under range
            return segTree[i];
        }else{ // OverLapping Case
            int mid = (l+r)/2;
            return sum(st,ed, 2*i+1,l,mid) + sum(st,ed,2*i+2,mid+1,r);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */