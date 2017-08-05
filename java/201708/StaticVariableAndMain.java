public class StaticVariableAndMain {
/**
    output:
        2
        3
        a=110,b=0
        1
        4
*/

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticVariableAndMain st = new StaticVariableAndMain();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticVariableAndMain() {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
