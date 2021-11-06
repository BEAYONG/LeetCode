public class Exercise58 {
    /**
     *
     * @param s
     * @return
     *
     * 利用Java自带的api进行解题,不得不说还是十分简单的
     */
    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }

    /**
     *
     * @param s
     * @return
     * 这里需要足注意的是end取值取不取到等于是没有影响的,因为题目中提到了至少存在一个单词,所以总会有取到字母的时候
     * 还有一个细节需要注意的是start >= 0 && s.charAt(start) != ' '这个代码,在惯性思维中条件的互换是没有影响的
     * 但是这道题不是,如果条件进行互换的话,那么就会出现越界的问题,因为为了遍历到索引0位置的元素,start必须取到0
     * 但是接下来就会取到start=-1,如果第一个条件不满足的话,就不会继续走后面的逻辑
     */
    public static int lengthOfLastWord1(String s) {
        int end = s.length() - 1;
        int start = 0;
        while (s.charAt(end) == ' ' && end > 0){
            end --;
        }
        start = end;
        while (start >= 0 && s.charAt(start) != ' '){
            start --;
        }
        return end - start;
    }
}
