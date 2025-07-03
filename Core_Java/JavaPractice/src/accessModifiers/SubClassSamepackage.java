package accessModifiers;

public class SubClassSamepackage extends Base {
    public void showAccess(){
        System.out.println(pub);
        System.out.println(pro);
        System.out.println(def);
//        System.out.println(pri);
    }
}
