public class B006_hanoiRecursion {
    public static void main(String[] args) {
        System.out.printf("总共%d步\n", hanoi(2, "左", "中", "右"));
    }
    static int hanoi(int n, String l, String m, String r) {
        if (n < 1)
            return 0;
        return process(n, l, m, r, l, r);
    }
    static int process(int n, String l, String m, String r, String f, String t) {
        if (n == 1) {
            if (f.equals(m) || t.equals(m)) {
                System.out.printf("移动1从%s到%s\n", f, t);
                return 1;
            } else {
                System.out.printf("移动1从%s到%s\n", f, m);
                System.out.printf("移动1从%s到%s\n", m, t);
                return 2;
            }
        }
        if (f.equals(m) || t.equals(m)) {
            String a = (f.equals(l) || t.equals(l) ) ? r : l;
            int p1 = process(n - 1, l, m, r, f, a);
            int p2 = 1;
            System.out.printf("移动%d从%s到%s\n", n, f, t);
            int p3 = process(n - 1, l, m, r, a, t);
            return p1 + p2 + p3;
        } else {
            int p1 = process(n - 1, l, m, r, f, t);
            int p2 = 1;
            System.out.printf("移动%d从%s到%s\n", n, f, m);
            int p3 = process(n - 1, l, m, r, t, f);
            int p4 = 1;
            System.out.printf("移动%d从%s到%s\n", n, m, t);
            int p5 = process(n - 1, l, m, r, f, t);
            return p1 + p2 + p3 + p4 + p5;
        }
    }
}
