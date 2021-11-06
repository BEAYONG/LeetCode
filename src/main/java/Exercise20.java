import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Exercise20 {
    /**
     * @param s
     * @return boolean
     * <p>
     * Deque是一个双端队列接口,继承自Queue接口,Deque的实现类是LinkedList、ArrayDeque、LinkedBlockingDeque
     * 其中LinkedList是最常用的
     */
    public static boolean isValid(String s) {
        // 首先判断长度,如果长度是奇数那么肯定是不匹配的
        if (s.length() % 2 == 1) {
            return false;
        }

        // 创建HashMap存储各种括号类型对应的关系
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');

        // 建立堆栈存储数据
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 判断是否包含所有的括号的右边部分
            if (pairs.containsKey(c)) {
                // 如果包含的话,此时堆栈是空的话是不满足条件的
                // 如果栈顶的元素不匹配的话也是不满足条件的
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                // 走到循环的这一步说明满足条件,弹出元素
                stack.pop();
                // 此处的else是一定不能省略的,否则会出错
                // 因为如果if条件满足的时候会继续走下面的逻辑
                // 也就是把c压进堆栈中
            }else {
                // 如果是括号左边类型中的一种的话把元素压入栈中
                stack.push(c);
            }
        }
        // 经过上面的遍历之后,如果栈不为空说明不匹配
        return stack.isEmpty();
    }
}
