package Lab.BinarySearch;

public class Main {
    public static void main(String[] args) {


//        mid = end + (start -end)/2, start =0 , end = len -1
// target value = 12
//        1,2,4,7,12,25,56
//        arr[mid] == target value -> sout target value

//        arr[mid] > target value -> 1st half ->
//        1,2,4
//        end = mid-1
//

//        arr[mid] < target value -> 2nd half
//        12,25,56
//        start = mid+1

//        1, 2, 4, 7, 12, 25, 56
//        12, 25, 56
//        12


        int[] arr = {1, 2, 4, 7, 12, 25, 56,70};
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int target = 100;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                System.out.println("Value Found");
                return;
            } else if (target > arr[mid]) {
                start = mid + 1;

            } else if (target < arr[mid]) {
                end = mid - 1;
            }


        }

        System.out.println("Value not Found.");

//        System.out.println(mid);
    }
}
