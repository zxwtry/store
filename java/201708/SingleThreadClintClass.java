
public class SingleThreadClintClass {
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++) {
            B b = new B();
            b.start();
        }
        System.out.println("main done!");
        /**
            thread name --> Thread-5 clinit Class A start
            main done!
            thread name --> Thread-5 clinit Class A end
         */
    }
    
    
    static class A {
        static {
            System.out.printf("thread name --> %s clinit Class A start\n", 
                    Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("thread name --> %s clinit Class A end\n", 
                    Thread.currentThread().getName());
        }
    }
    
    static class B extends Thread {
        @Override
        public void run() {
            A a = new A();
            if (a != null) {}
        }
    }
    
}
