public class Code01_SystemExitFinally {
    //输出
    //Check Exit!
    //Finally Block!
    //执行javac 之后，会生成两个class文件
    //Code01_SystemExitFinally$1.class  Code01_SystemExitFinally.class
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager() {
            @Override        
            public void checkExit(int status) {
                System.out.println("Check Exit!");
                throw new ThreadDeath();
            }
        });
        try {
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally Block!");
        }
        System.out.println("Still Running!");
    }
}
