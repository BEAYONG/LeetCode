public class Exercise26 {
    /**
     *
     * @param nums
     * @return
     * 通过双指针可以快速解决本题：
     *     题目的思路主要是用快指针不断遍历数组,但遍历到的数值不是重复的时候,
     *     使用慢指针进行赋值,这样最后输出慢指针的位置就可以知道结果
     */
    public static int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;
        int length = nums.length;
        while (fast < length){
            if (nums[fast] != nums[slow]){
                slow ++;
                // 这里的判断的意图是:如果相连的数字都没有重复的话,
                // 就不需要进行赋值
                // 加上这一层判断,内存减少了,但是时间稍微高了一点
                if (fast - slow > 0) {
                    nums[slow] = nums[fast];
                }
            }
            fast ++;
        }
        return slow + 1;
    }
}
