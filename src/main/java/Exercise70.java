public class Exercise70 {
    /**
     * @param n
     * @return 使用的是递归的思想解决问题:
     * 这里需要解释一下的是:递归公式是climbStairs(n) = climbStairs(n - 1) + climbStairs(n - 2),
     * 公式的含义就是第n阶上来的话前面只有两种情况:一种是只通过一节台阶就上来了,另外一种是通过两阶台阶上来的
     * 得到递推公式之后按道理来说递归的代码就基本完成了,只需要找到终止条件即可
     * 这里有两个终止条件,就分别是if就进行了判断
     * 虽然这个方法是真的简单,但是似乎提交的时候会超时,
     * 而且Leetcode的官方解答并不推崇递归的写法
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * @param n
     * @return 其实都可以得到递归公式了, 将递归转换成非递归也是可以的
     * 这道题只需要通过一个for循环就可以解决问题
     * 首先p代表的是前两阶台阶处所拥有的方案数,q代表的是前一节台阶拥有的方案数
     * 为了方便理解,在官方的解答上面略作修改,首先是台阶数是1,2的情况就直接返回
     * 然后我们可以知道第n阶台阶的解决方案只有和前面两阶台阶的解决方案数有关,
     * 所以r = p + q得到的就是结果
     * 下面两行代码的意图也十分明显:就是不断更新前面两阶台阶的解决方案数,这样就可以相加
     * p = q;
     * q = r;
     * 上面这个方案,解答中也有一个名字就是动态规划
     */
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int p = 1, q = 2, r = 0;
        for (int i = 3; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

    /**
     * @param n
     * @return 根据官方的解答, 还提供了一种根据矩阵快速幂解决问题的方案
     *
     * 代码主要分为三个部分:
     * 其中最简单的部分就是设计一个矩阵相乘的函数,这个根据矩阵运算的定义设计即可
     * 不过这里还是总结一下,就是求c[i][j]的话,就是a的行的值都是取i,b的列的值都是取j
     * 变化的只是a的列,和b的行,而且这两个的取值是相同的
     *
     * 代码的第二部分其实初一看是比较难理解的:
     * 在设计的时候主要是运用了二进制的位运算,这样的话就可以减少很多的判断
     * 比如说以43为例子,其二进制数值为10 1011
     * 首先对n的二进制形式数值的第一个数字进行判断,如果是1的话,就作运算multiply(tem, matrix),43的数值为1,所以会走该逻辑
     * 然后通过 n >>= 1 将位数移到下一位,而我们知道的,这是2^1,所以通过matrix = multiply(matrix, matrix)得到矩阵的2^1次方
     * 然后判断现在的位置的数值是否为0,很明显是1,所以满足if的条件,执行其内部的逻辑
     * 通过一直执行上面的逻辑,最后n可以取到最高位
     * 这里还有一点就是循环终止的条件是n > 0,代码 n >>= 1有两方面的理解,一方面就是每次移动的位数是一位,但是也可以理解为除2,
     * 经过多次除2为0之后就说明已经遍历完了
     *
     * 最后就到了调用之前的编写的函数解题的最后步骤了,但是这里自己想了很久都不明白为什么计算的是f(n + 1)的值,
     * 其实这是因为为了方便得到结果,f(n)的取值在代码中取的是0,但是实际上,取值应该从1开始,这个也是题目的意思,
     * 至此为止,代码相关的解释完毕
     */
    public static int climbStairs2(int n) {
        int[][] matrix = {{0, 1}, {1, 1}};
        int[][] result = pow(matrix, n );
        return result[1][1];
    }

    private static int[][] pow(int[][] matrix, int n) {
        int[][] tem = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                tem = multiply(tem, matrix);
            }
            n >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return tem;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}


