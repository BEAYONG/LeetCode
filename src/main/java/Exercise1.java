import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise1 {
    /**
     *
     * @param nums
     * @param target
     * @return int[]
     *
     * 暴力枚举解决问题,但是时间复杂度比较高,而且内存消耗比较高
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param nums
     * @param target
     * @return int[]
     *
     * 该方法的思路就是使用 map 记录数组中每个数值和另外一个使之满足条件的数值
     * 但是在实现的过程中,需要使用判断的条件比较多,所以最后的时间复杂度提升不明显,空间复杂度反而上升很多
     * 在做题的过程中,遇到了一个坑:
     * 基本数据类型是不可以使用数组工具类转换成为数组的,如果需要转换成为对应的包装类型
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        // 这里需要额外的判断,因为在目标值是2的倍数的时候比较复杂
        if (target % 2 == 0) {
            int half = target / 2;
            // 基本数据类型是不可以直接转换成为列表的,需要先转换成对应的包装类数组
            List<Object> list = Arrays.asList(Arrays.stream(nums).boxed().toArray());
            if (list.indexOf(half) >= 0 && list.lastIndexOf(half) >= 0 &&
                    list.indexOf(half) != list.lastIndexOf(half)) {
                result[0] = list.indexOf(half);
                result[1] = list.lastIndexOf(half);
            }else {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = nums.length - 1; i >= 0; i--) {
                    map.put(target - nums[i], i);
                }
                map.remove(half);
                for (int j = 0; j < nums.length; j++) {
                    if (map.containsKey(nums[j])) {
                        result[0] = j;
                        result[1] = map.get(nums[j]);
                        break;
                    }
                }
            }
            return result;
        } else {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                map.put(target - nums[i], i);
            }
            for (int j = 0; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    result[0] = j;
                    result[1] = map.get(nums[j]);
                    break;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param nums
     * @param target
     * @return int[]
     *
     * 其实方法二的思路和官方答案的思路是接近的，但是官方答案的思路更胜一筹的地方在于:
     * 方法三是动态进行判断的,这样就可以减少很多整个数组遍历完之后的不必要判断
     * 而且在条件满足的时候会立即跳出,可以不遍历完数组
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

