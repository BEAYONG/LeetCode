public class Exercise13 {
    /**
     *
     * @param s
     * @return int
     *
     * 这道题主要是在于找规律,如果一个数字比前面的数字大久需要做减法,否则需要做加法
     * 这道题还有一个小问题就是:既然涉及到前后数字的比较,那么就需要给第一个进行比较的值进行赋值
     * 具体来说就是列表的第一个数值,这样可以解决遍历角标越界的问题
     */
    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = transfer(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = transfer(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public static int transfer(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new RuntimeException("输入的数据有误！");
        }
    }
}
