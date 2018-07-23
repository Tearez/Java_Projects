public class Example2 {
    public static void a(){
        try{
            b();
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    static void b(){
        c();
        System.out.println("b");
    }
    static void c(){
        d();
        System.out.println("c");
    }
    static void d(){
        int a = 1/0;
        System.out.println("d");
    }
}
