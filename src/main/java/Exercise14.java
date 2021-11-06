import java.util.HashSet;
import java.util.Iterator;

public class Exercise14 {
    /**
     *
     * @param strs
     * @return String
     *
     * 这种方法的思路主要是使用到了set的不可重复性,但是时间复杂度实在是太高了
     * 这里有一个坑需要注意的是:set.toString方法输出的结果是带格式的,所以如果需要按照指定的格式输出可能需要重写方法
     */
    public static String longestCommonPrefix(String[] strs) {
        int minLength = strs[0].length();
        String res = "";
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() < minLength){
                minLength = strs[i].length();
            }
        }
        for (int j = 0; j < minLength; j++) {
            HashSet<String> set = new HashSet<>();
            for (int k = 0; k < strs.length; k++) {
                set.add(new String(new char[]{strs[k].charAt(j)}));
            }
            if (set.size() == 1) {
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    res += iterator.next();
                }
                set.clear();
            } else break;
        }
        return res;
    }

    /**
     *
     * @param strs
     * @return String
     *
     * 其实这个方法也就是通过遍历的方法解决的,思路就是首先将字符数组的第一个字符串设置成暂时的返回结果
     * 然后将返回结果和还没有对比的字符串一个一个字符进行比对,如果不满足条件就退出
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            // 这里的j之所以没有写在循环里面是因为后面调用截取字符的方法中需要使用到
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

}
