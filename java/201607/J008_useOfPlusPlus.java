public class J008_useOfPlusPlus {
    public static void main(String[] args) {
        int i = 5, j = 5, p , q;
        p = (i ++) + (i ++) + (i ++);
        q = (++ j) + (++ j) + (++ j);
        System.out.printf("%d %d %d %d\n", p, q, i, j); 
    }
}
