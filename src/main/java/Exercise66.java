public class Exercise66 {
    /**
     *
     * @param digits
     * @return
     *
     * 这个解法其实十分巧妙,首先根据提议给最后一位加1,然后通过if判断末尾是否是0,
     * 也就是if (digits[i] != 0),如果不为0的话就会走return语句,整个代码结束,如果是0,
     * 说明会有进位,就会继续循环,直到没有进位为止
     * 但是如果都有进位呢？
     * 那么这个数就一定是整十整百的数字了,所以在循环体结束以后,代码创建了一个新的数组,
     * 但是数组的长度是原来的长度加1,而且设置第一位数是1,这样的话就可以囊括所有的情况
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i --){
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        int[] result  = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
