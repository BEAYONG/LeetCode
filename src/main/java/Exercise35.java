public class Exercise35 {
    /**
     *
     * @param nums
     * @param target
     * @return
     * 给定排序数组找合适的位置,这个应该第一时间想到二分查找法
     * 其实代码没有十分难的部分,即使首位位置更新的时候需要注意一下就可以了
     */
    public static int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        if (target > nums[tail]){
            return tail + 1;
        }
        if (target < nums[head]){
            return 0;
        }
        while (head <= tail){
            int centre = (head + tail) / 2;
            if (target < nums[centre]) {
                tail = centre - 1;
            }else if (target > nums[centre]){
                head = centre + 1;
            }else {
                return centre;
            }
        }
        return head;
    }
}
