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
*/

public class J014_GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(1999));
    }
    static int guessNumber(int n) {
        return guessNumber(1, n);
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
    */
    static int guessNumberWhile(int a, int b) {
        //中间数m，判断的结果g
        int m = 0, g = 0;
        while (a < b) {
            m = (a + b) >>> 1;
            g = guess(m);
            if (g == 0)
                return m;
            else if (g == 1)
                a = m + 1;
            else
                b = m - 1;
        }
        return a;
    }
    static int guess(int n) {
        final int num = 9;
        if (n > num)
            return -1;
        else if (n < num)
            return 1;
        else
            return 0;
    }
}
