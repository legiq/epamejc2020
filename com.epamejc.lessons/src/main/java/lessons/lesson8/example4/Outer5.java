package lessons.lesson8.example4;

public class Outer5 {

    class Inner {
        public final static int pubfsi_pole = 22;
        private final static int prfsi_polr = 33;
    }

    public void callMethodInInner() {
        System.out.println(Inner.prfsi_polr);
        System.out.println(Inner.pubfsi_pole);
    }

}
