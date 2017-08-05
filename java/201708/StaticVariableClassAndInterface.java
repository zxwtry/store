
public class StaticVariableClassAndInterface {
    
    public static void main(String[] args) {
        testClassInterface();
    }
    
    static void testClass() {
        System.out.println(E.e);
        /**
            get value --> c
            get value --> d
            get value --> e
            e
         */
    }
    
    static void testClass2() {
        System.out.println(E.d);
        /**
            get value --> c
            get value --> d
            d
         */
    }
    
    static void testInterface() {
        System.out.println(B.b);
        /**
            get value --> b
            b
         */
    }
    
    static void testClassInterface() {
        System.out.println(C.c);
        /**
            get value --> c
            c
         */
    }
    
    static interface A {
        static String a = getValue("a");
        void funA();
    }
    
    static interface B extends A {
        //static {}     //静态代码块出错
        static String b = getValue("b");
        void funB();
    }
    
    static class C implements B {
        static String c = getValue("c");

        @Override
        public void funA() {
        }

        @Override
        public void funB() {
        }
        
    }
    
    static class D extends C {
        static String d = getValue("d");
    }
    
    static class E extends D{
        static String e = getValue("e");
    }
    
    static String getValue(String v) {
        System.out.println("get value --> " + v);
        return v;
    }
}
