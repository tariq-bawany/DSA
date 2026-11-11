package Lab.Array;

public class Main {
    public static void main(String[] args) {
//        // basic array insertion and deletion;
//
//
////        basic array insertion
////        user input for array size / capacity
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter the size of array:");
//        int size  = sc.nextInt();
//
//        int[] arr = new int[size]; // initial value - 0
//
//        System.out.print("Enter the length of the array:");
//        int len = sc.nextInt();
//
//        for (int i = 0; i < len; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        int insertAtPos = 2;
//        int insertValue = 10;
//
//        for (int i = len; i > insertAtPos-1 ; i--) {
//            arr[i+1] = arr[i];
//        }
////        System.out.println(Arrays.toString(arr));
//
//        arr[insertAtPos] = insertValue;
//        len++;
//        for (int i = 0; i < len; i++) {
//            System.out.print(arr[i]+" ");
//        }
//


//        array deletion

        int[] arr = {20,123,34,56,67,23,67,213};
//        20,123,34,56,67,23,67,213
//        56,67,23,67,213

        int targetDeleteValue = 100;
        boolean isFound =false;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == targetDeleteValue){
                isFound = true;
                for(int j=i;j<arr.length-1;j++){
                    arr[j] = arr[j+1];
                }
            }
        }
        if(!isFound){
            System.out.println("Value not Found");
        }

        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+" ");
        }
//        System.out.println(Arrays.toString(arr));


    }
}