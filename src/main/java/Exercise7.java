public class Exercise7 {

    /**
     *
     * @param x
     * @return int result
     *
     * 通过字符数组进行反转,但是这样的做法还是需要注意:
     * 在最后将字符数组转化成int的时候,可能数值是超过int范围的,所以需要进行异常处理
     */
    public static int reverse(int x) {
        if (x >= 0){
            return integerReverse(x);
        }else {
            x = -x;
            return - integerReverse(x);
        }

    }

    public static int integerReverse(int x){
        String str = String.valueOf(x);
        char[] array = str.toCharArray();
        for (int startIndex = 0, endIndex = array.length - 1; startIndex < endIndex;startIndex ++,endIndex --){
            char temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
        try {
            return Integer.parseInt(new String(array));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     *
     * @param x
     * @return int result
     *
     * 本来这道题目是十分简单的,如果没有存储数字大小的限制的话,可以在任意数字反转之后再进行判断是否有越界,
     * 但是现在题目加以限制就不能使用上述的思路
     * 最大值是2147483647,最小值是-2147483648
     * 这样一来,如果反转的数字本身小于最值的数量级的时候,是绝对不会越界的
     * 问题就复杂在:如果反转的数字的数量级是和最值是相同的数量级这种情况
     * 但是,这种情况下就意味着最后的一位数字是绝对会是0和1两个数字,是绝对不会存在越界问题的
     * 如果有问题那也绝对是出现在已经反转的数字的个位数之前的数字上,所以if判断中对最值除以10的原因就在于此
     */
    public static int reverse1(int x) {
        int result = 0;
        while (x != 0){
            if (result > Integer.MAX_VALUE / 10 && result < Integer.MIN_VALUE / 10){
                return 0;
            }
            int num =  x % 10;
            x = x / 10;
            result = result * 10 + num;
        }
        return  result;
    }
}
