package Java8编程官方参考教程;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page1000_正则表达式 {
    public static void main(String[] args) {
        test02_正则表达式();
    }
    
    static void test01_正则表达式() {
//        Pattern pat = Pattern.compile("a.+d");    //比较两者不同
        Pattern pat = Pattern.compile("a.+?d");
        Matcher mat = pat.matcher("abdacdacaedm acd");
        while (mat.find()) {
            System.out.println(mat.start() + "..." + mat.end());
            System.out.println(mat.group());
        }
    }
    static void test02_正则表达式() {
        String pat = "mat";
//        String inp = "match";
        String inp = "mat";
        System.out.println(Pattern.matches(pat, inp));
    }
    
}
