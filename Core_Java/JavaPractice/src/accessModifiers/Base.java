package accessModifiers;

public class Base {
    public int pub = 1;
    protected int pro = 2;
    int def = 3;
    private int pri = 4;

    public void printAccess(){
        System.out.println("accessModifiers.Base: "+pub+" "+pro+" "+def+" "+pri);
    }

    public static void main(String[] args) {
        Base b = new Base();
        b.printAccess();
    }

}
