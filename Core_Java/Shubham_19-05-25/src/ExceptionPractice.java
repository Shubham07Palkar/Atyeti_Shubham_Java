public class ExceptionPractice {
    public static int arithmeticException(int a, int b){
        try {
            return a / b;
        }catch (ArithmeticException e){
            System.out.println("Error :" + e.getMessage());
        }
        return 0;
    }

    public static void nullPointerException(String input){
        try {
            System.out.println("Length : "+input.length());
        }catch (NullPointerException e){
            System.out.println("Error : "+ e.getMessage());
        }

    }

    public static void arrayIndexOut(int[] arr, int index){
        try {
            System.out.println(arr[index]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error : " +e.getMessage());
        }
    }

    public static void multipleExcep(int a, int b, int[] arr, int index){
        try {
            int divide = a/b;
            System.out.println(divide);

            System.out.println(arr[index]);
        }catch (ArithmeticException e){
            System.out.println("Error :"+ e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error "+ e.getMessage());
        }
    }


    public static void main(String[] args) {
        arithmeticException(1,0);
        nullPointerException(null);
        int arr[]={1,3,4,5};
        arrayIndexOut(arr,5);
        multipleExcep(10, 0, arr,5);
    }

}
