interface I {
    public void m1();
    }
    interface J {
    public void m2(I obj);
    }
    class C implements I, J {
    public void m1()
    {
    System.out.println("C.m1");
    }
    public void m2(I obj)
    {
    obj.m1();
    System.out.println("C.m2");
    }
    }
    class D implements I {
    public void m1()
    {
    System.out.println("D.m1");
    }
}

public class chiao {

    public static void main(String[] args){
        I obj = new C();
        ((C) obj).m2(obj);
    }

}