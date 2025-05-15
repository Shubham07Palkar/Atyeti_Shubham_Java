import java.util.*;
public class TypeCasting {

    public static void main(String[] args) {
        //converting int to float
        Scanner sc = new Scanner(System.in);
        int age = 22;
        float floatage = (float) age;
        System.out.println("Converted :" + floatage);


        //Temperature Converter(Celsius -> Farenheit)
        int tempinCelcius = 32;
        float farenheit = (tempinCelcius * 9/5) + 32;
        System.out.println(farenheit);

        //larger to smaller type
        double a = 10;
        int b = (int) a;
        System.out.println(b);
    }
}
