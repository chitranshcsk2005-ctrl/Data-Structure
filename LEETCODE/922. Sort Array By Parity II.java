class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int edx=0;
        int odx=1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==0)//even
            {
                arr[edx]=nums[i];
                edx+=2;
            }
            else
            {
                arr[odx]=nums[i];
                odx+=2;
            }
        }
        return arr;
    }
}
