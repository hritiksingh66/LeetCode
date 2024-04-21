class Solution {
    private void sort(int[] arr,int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            sort(arr,left,mid);
            sort(arr,mid+1,right);
            merge(arr,left,right,mid);
        }
    }

    private void merge(int[] arr,int left,int right,int mid){
        int n1 = mid-left+1;
        int n2 = right-mid;

        //temp varibales
        int[] l = new int[n1];
        int[] r = new int[n2];

        for(int i = 0; i<n1;i++){
            l[i] = arr[left+i];
        }
        for(int j = 0; j<n2;j++){
            r[j] = arr[mid+j+1];
        }

        int i = 0,j = 0, k = left;
        while(i<n1 && j<n2){
            if(l[i] <= r[j]){
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k++] = l[i++];
        }
        while(j<n2){
            arr[k++] = r[j++];
        }
    }
    
    public int[] sortArray(int[] nums){
        sort(nums,0,nums.length-1);
        return nums;  
    }
}