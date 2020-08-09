import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        //双指针
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int ret = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length){
            sum += nums[right];
            while(sum >= s){
                ret = Math.min(ret,right-left+1);
                sum-=nums[left];
                ++left;
            }
            ++right;
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}
