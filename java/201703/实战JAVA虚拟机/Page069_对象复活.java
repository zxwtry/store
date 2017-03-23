package 实战JAVA虚拟机;

public class Page069_对象复活 {
    public static CanReliveObj obj;
    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        obj = null;
        System.gc();
        Thread.sleep(1000);
        System.out.printf("obj == null is %b\r\n", obj == null);
        System.out.println("第二次GC");
        obj = null;
        System.gc();
        Thread.sleep(1000);
        System.out.printf("obj == null is %b\r\n", obj == null);
        /*
            CanReliveObj.finalize() called
            obj == null is false
                               第二次GC
            obj == null is true
         */
    }
    static class CanReliveObj {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("CanReliveObj.finalize() called");
            obj = this;
        }
    }
}
