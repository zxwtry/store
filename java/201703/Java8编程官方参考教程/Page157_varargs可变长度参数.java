package Java8编程官方参考教程;

public class Page157_varargs可变长度参数 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.method3();
    }
    //可变长度参数
    static class Solution0 {
        //可变长度参数必须是最后一个参数
        public void solve1(int ... v){};    //可以
        public void solve2(String s, int ... v){};    //可以
//        public void solve3(int ... v, String s){};    //出错
        //可变长度参数只有一个，不能有两个
//        public void solve4(String ... s, int ... v) {}; //出错
    }
    
    //有重载时候，模糊性
    static class Solution1 {
        //solve1是可以的
        public void solve1(int ... v) {}
        public void method1() {solve1();};

        //solve2会因为不知道是哪个而出错
        public void solve2(String ... v) {
            System.out.println((v == null) + " in String");
        };
        public void solve2(int ... s) {
            System.out.println((s == null) + " in int");
        };
        public void method2() {
            solve2(1, 2);  //可以
            solve2(new String[] {"a", "b"});    //可以
//            sovle2();   //IDE报错
//            sovle2(null);   //IDE报错
        }
        
        //solve3出现类似 int v, int ... vv这种
        public void solve3(int v, int ... vv) {
            System.out.println(vv == null ? "null" : "" + vv.length + " ... in solve3 int v int ... vv");
        }
        public void solve3(int ... vv) {
            System.out.println(vv == null ? "null" : "" + vv.length + " ... in solve3 int v int ... vv");
        }
        public void method3() {
            solve3(1, new int[] {});    //这个是可以的
//            solve3(1, 1);       //IDE报错
//            solve3(1, 1, 1, 1);   //IDE报错
            solve3(new int[] {});   //这个可以
        }
    }
}
