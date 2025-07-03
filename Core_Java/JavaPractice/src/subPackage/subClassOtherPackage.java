package subPackage;

import accessModifiers.Base;

public class subClassOtherPackage extends Base {
    public void showAccess(){
        System.out.println(pub);
        System.out.println("\n"+pro);
//        System.out.println(def);
//        System.out.println(pri);
    }
}
