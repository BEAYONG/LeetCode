public class Exercise9 {
    /**
     *
     * @param x
     * @return boolean
     *
     * 通过转换成为字符数组解决问题,思路十分简单
     */
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }else {
            char[] array = String.valueOf(x).toCharArray();
            for (int startIndex = 0,endIndex = array.length - 1; startIndex < endIndex; startIndex ++,endIndex --){
                if (array[startIndex] != array[endIndex]){
                    return false;
                }
            }

        }
        return true;
    }

    // todo 寻找时间复杂度低的方法
}
