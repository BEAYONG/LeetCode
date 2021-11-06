public class Exercise69 {
    /**
     *
     * @param x
     * @return
     *
     * 其实就是通过数学推演进行,借助指数函数求解,最后再判断一下,是否需要加1
     * 但是这里需要注意的是if判断条件需要类型强转,否则会出错
     */
    public static int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int result = (int) Math.exp(0.5 * Math.log(x));
        if ((long)(result + 1) * (result + 1) <= x){
            return result + 1;
        }else {
            return result;
        }
    }

    /**
     *
     * @param x
     * @return
     *
     * 这里求求平方根其实就是当作求根进行解题,既然是求根,那么就可以使用到著名的牛顿迭代法
     * 其实就是通过泰勒展开式求得的,也就是可以得到一个递推公式
     * 转换称为代码就是:首先随机指定一个值作为初始值,代码设置的值是start
     * 然后把第一次迭代的值赋给result这个变量
     * 接着就是进入循环了,判断循环是否需要停止的条件是两次迭代直接的绝对值是否小于精确值
     */
    public static int mySqrt1(int x) {
        if (x == 0){
            return 0;
        }
        double start = x;
        double tem = 0;
        double result = 0.5 * (start  + x / start);
        while (true){
            tem = 0.5 * (result + x / result);
            if (Math.abs(result - tem )< 1e-7){
                break;
            }
            result = tem;
        }
        return (int)result;
    }
}
