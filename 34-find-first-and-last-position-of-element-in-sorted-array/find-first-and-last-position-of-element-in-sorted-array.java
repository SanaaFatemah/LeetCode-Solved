public class Solution {
public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findFirst(nums, target);
    
    result[1] = findLast(nums, target);
    return result;
}

private int findFirst(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        System.out.println(mid);
        //Trying to find the first index, so we are trying to push mid to the left
        if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}

private int findLast(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        //Trying to find the last index, so we are trying to push mid to the right
        if(nums[mid] <= target){
            
            start = mid + 1;
            
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}
}