/*
    source: https://leetcode.com/problems/guess-number-higher-or-lower/
    rato:   4006/12834      Difficulty: Easy

    We are playing the Guess Game. The game is as follows:
    I pick a number from 1 to n. You have to guess which number I picked.
    Every time you guess wrong, I'll tell you whether the number is higher or lower.
    You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
    -1 : My number is lower
     1 : My number is higher
     0 : Congrats! You got it!

    Example:
    n = 10, I pick 6.
    Return 6.

    上面是第一题的信息，第二题的信息增加如下：
    a,  添加消耗，猜错成A，就需要消耗A
    b,  给定 1~n，需要得到的是：
        保证一定能够猜到的最小A和


    hint:
    1,  The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
    2,  Take a small example (n = 3). What do you end up paying in the worst case?
    4,  The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
*/

public class J014_GuessNumberHigherOrLowerII {
    public static void main(String[] args) {
        System.out.println(guessNumber(1999));
    }
    static int guessNumber(int n) {
        return guessNumberWhile(1, n);
    }
    /*
        猜的数字限定在 a <= k <= b
        这个是递归写法
    */
    static int guessNumber(int a, int b) {
        if (a == b)
            return a;
        // 中间数m
        int m = (a + b) >>> 1;
        int g = guess(m);
        if (g == 0)
            return m;
        else if (g == 1)
            return guessNumber(m+1, b);
        else
            return guessNumber(a, m-1);
    }
    /*
        猜的数字限定在 a <= k <= b
        这个是非递归写法
        II中，只更改非递归版本
    */
    static int guessNumberWhile(int a, int b) {
        //中间数m，判断的结果g
        final int num = b;
        int m = 0, g = 0, cou = 0;
        if (a == b)
            return a;
        while (a < b) {
            m = (a + b) >>> 1;
            g = guess(m, num);
            if (g == 0)
                return cou;
            else if (g == 1) {
                cou += m;
                a = m + 1;
            } else {
                cou += m;
                b = m - 1;
            }
        }
        return cou;
    }
    /*
        相对1作的修改有：
            将num设成传入参数
     */
    static int guess(int n, int num) {
        if (n > num)
            return -1;
        else if (n < num)
            return 1;
        else
            return 0;
    }
}
