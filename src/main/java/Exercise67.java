public class Exercise67 {
    /**
     *
     * @param a
     * @param b
     * @return
     *
     * 解答的主要思路:
     * 对两个字符串进行遍历,但是在遍历的时候终止的条件是“或”的关系,也即是只要有一个不为空就会继续遍历下去.
     * 所以才有了if的判断条件,i 或者 j 大于0,说明这个字符串还没有结束,所以就要把这个数值加上
     * 这里由字符转换为数字的思路比较巧妙,通过借助ASCII码进行转换
     * 然后这里定义了一个变量sum来存储两个数字的结果,所以sum % 2就可以得到结果的
     * 但是在实现的时候需要注意一点就是
     *      result.append(sum % 2);
     *      sum /= 2;
     * 两行代码是不可以交换顺序的,不然sum的数值就会提前变化
     * 还有就是sum这个数值是需要一直记录的,所以不能写在for循环里面,不然的话,每次循环都会被更新为0
     * 最后的if判断就是最后如果进位还不为0的话,就需要在结果上加1,也就是进位
     *
     */
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0; i --,j --){
            if (i >= 0){
                sum += a.charAt(i) - '0';
            }
            if (j >= 0){
                sum += b.charAt(j) - '0';
            }
            result.append(sum % 2);
            sum /= 2;

        }
        if (sum != 0){
            result.append(1);
        }
        return result.reverse().toString();
    }
}
