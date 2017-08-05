public class StaticBlockErrorAndSequence {
    static {
        v = 1;
        // System.out.println(v);   // --> error
        //Cannot reference a field before it is defined
    }
    
    public static int v = 0;
    public static void main(String[] args) {
        System.out.println(v);      //输出0
        /**
            变量a，有三次赋值过程
            准备阶段：一次，v赋值初始值0（不是等号后面的0）
            初始化阶段：两次
                static块中，将v赋值为1
                static代码，将v赋值为0（等号后面的那个0）
        */
    }
}
