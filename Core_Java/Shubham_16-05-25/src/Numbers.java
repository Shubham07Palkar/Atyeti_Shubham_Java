//Use of Object and Classes
public class Numbers {
    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void sum(){
        System.out.println(a+b);
        System.out.println(a-b);
    }

    public static void main(String[] args) {
        Numbers num = new Numbers();
        num.setA(40);
        num.setB(20);
        num.sum();
    }
}
