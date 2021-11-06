public class Exercise27 {
    /**
     * @param nums
     * @param val
     * @return 这道题题目中提及到了不可以使用新的空间, 所以一般来说就考虑使用双指针了
     * 但是在解答的过程中自己还是出错了多次:
     * 首先是如果第一个元素就是目标元素的情况没有考虑
     * 其次是快慢指针的移动没有模拟清楚
     */
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
