import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int[] dic = new int[nums.length+2];

        for(int i = 0;i < nums.length;++i){
            if(nums[i] > 0 && nums[i] <= nums.length){//答案不会超过数组长度，直接舍弃
                dic[nums[i]] = 1;
            }

        }
        int i = 1;
        while(i < nums.length + 2){
            if(dic[i] != 1){
                return i;
            }
            ++i;

        }
        return 1;//输入为空时

    }

    public int firstMissingPositive2(int[] nums){
        for(int i = 0;i < nums.length;++i){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){//将i位置的值交换至值减一的位置上
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;

            }
        }
        for(int i = 0;i < nums.length;++i){//检查下标不为值减一
            if(nums[i] != i+1){
                return  i+1;

            }

        }
        return  nums.length+1;//均符合则返回长度加一
    }
}

