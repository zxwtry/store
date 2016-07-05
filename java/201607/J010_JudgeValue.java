import java.util.*;
public class J010_JudgeValue {
    static int val1 = 0, val2 = 0, val3 = 0;
    static long[] val = {0, 0, 0, 0, 0, 0};
    static int[] arr = {0, 0, 0, 0, 0, 0};
    static char[] opers = {'@', '!', '/', '*', '-', '+'};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入训练集：");
        while (true) {
            val1 = scan.nextInt();
            val2 = scan.nextInt();
            val3 = scan.nextInt();
            if (val1 == -1 && val2 == -1 && val3 == -1)
                break;
            myJudge();
        }
        System.out.println("输入待预测的关系：");
        while (true) {
            val1 = scan.nextInt();
            val2 = scan.nextInt();
            if (val1 == -1 && val2 == -1)
                break;
            mySolve(scan);
        }
        scan.close();
    }
    static void mySolve(Scanner scan) {
        long min = Long.MAX_VALUE;
        int record = -1;
        for (int i = opers.length-1; i >= 0; i --) {
            if (min > val[i]) {
                min = val[i];
                record = i;
            }
        }
        System.out.printf("%d和%d的关系是：%d\n",val1, val2, oper(opers[record]));
        System.out.print("是否正确：");
        char c = scan.next().charAt(0);
        if (c != 'y' && c != 'Y') {
            val[record] += 5;
        }
    }
    static void myJudge() {
        oper();
        for (int i = opers.length-1; i >= 0; i --) {
            val[i] += Math.abs(val3 - arr[i]);
        }
    }
    static void oper() {
        for (int i = opers.length-1; i >= 0; i --) {
            arr[i] = oper(opers[i]);
        }
    }
    static int oper(char c) {
        switch(c) {
            case '+':
                return val1+val2;
            case '-':
                return val1-val2;
            case '*':
                return val1*val2;
            case '/':
                if (val2 != 0)
                    return val1/val2;
            break;
            case '!':
                return val2-val1;
            case '@':
                if (val1 != 0)
                    return val2/val1;
            break;
        }
        return Integer.MAX_VALUE;
    }
}
