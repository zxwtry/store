public class J011_Time {
    public static void main(String[] args){
        System.out.println(getShiJianChuo());
    }
    static long getShiJianChuo() {
        long time = System.currentTimeMillis() / 1000;
        return (time / 60) * 60;
    }
}
