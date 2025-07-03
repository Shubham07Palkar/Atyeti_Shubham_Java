public class Person {
    protected String name;
    protected int age;

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void introduceYourself() {
        System.out.println("My name is :" + name + "and my Age is :" + age);
    }

    public void setDetails(String name) {
        this.name = name;
    }

    public void setDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Student extends Person {
    private int studentId;

    public Student() {
        super();
        System.out.println("Student default Constructor");
    }

    public Student(String name, int age, int studentId) {
        super(age, name);
        this.studentId = studentId;
    }

    @Override
    public void introduceYourself() {
        System.out.println("Hi I'm "+name+", my student ID: "+studentId);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Shubham",23,101);
        s1.introduceYourself();

        s1.setDetails("Palkar",25);
        s1.introduceYourself();
    }
}
