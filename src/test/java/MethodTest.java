import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MethodTest {
    @Test
    public void exercise1(){
        System.out.println(Arrays.toString(Exercise1.twoSum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(Exercise1.twoSum1(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(Exercise1.twoSum1(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(Exercise1.twoSum1(new int[]{2,5,5,11}, 10)));
        System.out.println(Arrays.toString(Exercise1.twoSum1(new int[]{1,3,4,2}, 6)));
        System.out.println(Arrays.toString(Exercise1.twoSum1(new int[]{0,3,-3,4,-1}, -1)));
    }


    @Test
    public void exercise7(){
        System.out.println(Exercise7.reverse1(123));
        System.out.println(Exercise7.reverse1(-123));
        System.out.println(Exercise7.reverse1(120));
        System.out.println(Exercise7.reverse1(0));
    }

    @Test
    public void exercise9() {
        System.out.println(Exercise9.isPalindrome(121));
        System.out.println(Exercise9.isPalindrome(-121));
    }

    @Test
    public void exercise13() {
        System.out.println(Exercise13.romanToInt("MCMXCIV"));
    }


    @Test
    public void exercise14() {
        //System.out.println(Exercise14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(Exercise14.longestCommonPrefix1(new String[]{"flower","flow","flight"}));
    }

    @Test
    public void exercise20() {
        System.out.println(Exercise20.isValid("()[]{}"));
        System.out.println(Exercise20.isValid("()"));
    }

    @Test
    public void exercise26() {
        System.out.println(Exercise26.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(Exercise26.removeDuplicates(new int[]{1,2}));
    }

    @Test
    public void exercise27(){
        System.out.println(Exercise27.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(Exercise27.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(Exercise27.removeElement(new int[]{2,2,3}, 2));
    }

    @Test
    public void exercise28(){
        System.out.println(Exercise28.strStr("hello", "ll"));
        System.out.println(Exercise28.strStr("Jason", "on"));
        System.out.println(Exercise28.strStr("mississippi", "ssip"));
        System.out.println(Exercise28.strStr("a", "a"));
        System.out.println(Exercise28.strStr("aaa", "aa"));
        System.out.println(Exercise28.strStr("ksspssissip", "ssip"));
        System.out.println(Exercise28.strStr("abbababbabbbabaa", "abbabbbabaa"));
    }
    @Test
    public void exercise35(){
        System.out.println(Exercise35.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(Exercise35.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void exercise53(){
        System.out.println(Exercise53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void exercise58(){
        System.out.println(Exercise58.lengthOfLastWord("Hello World"));
        System.out.println(Exercise58.lengthOfLastWord1("Hello World"));
    }

    @Test
    public void exercise67(){
        System.out.println(Exercise67.addBinary("11", "1"));
        System.out.println(Exercise67.addBinary("1010", "1011"));
    }

    @Test
    public void exercise70(){
        System.out.println(Exercise70.climbStairs1(43));
        System.out.println(Exercise70.climbStairs2(43));
        int n = 43;
        while (n > 0){
            if ((n & 1) == 1){
                System.out.print(true + "\t");
            }else System.out.print(false + "\t");
            n >>= 1;
            System.out.println(n);
        }
    }


}
