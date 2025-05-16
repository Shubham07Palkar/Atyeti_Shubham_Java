
class Parent{
    public void func(){
        System.out.println("Parent.func()");
    }

    public void func(int a){
        System.out.println("Parent.func(int) :"+a);
    }
}
class Child extends Parent{
    public void func(int a){
        System.out.println("Child.func(int)"+a);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c= new Child();

        //Dynamic Dispatch
        Parent polymorphicObj = new Child();

        p.func();
        p.func(10);

        c.func(200);
        polymorphicObj.func(30);
    }
}
