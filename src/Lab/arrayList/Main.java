package Lab.arrayList;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(20);
        arr.add(19);
        arr.add(24);
        arr.add(10);
        arr.add(5);
        arr.add(2);

// [1,4,2,4]
        for (Integer b:arr){
            System.out.print(b+" ");
        }
        System.out.println();

        arr.add(2,10);
        for (Integer b:arr){
            System.out.print(b+" ");
        }
        System.out.println();

        arr.remove(1);
        for (Integer b:arr){
            System.out.print(b+" ");
        }
        System.out.println();

        int sum =0;
        double avg =0;
        int count =0;
        for (Integer b:arr){
            count++;
            sum+= b;
        }
        avg = (sum *1.0) /count;
        System.out.println("Sum: "+sum);
        System.out.println("Count: "+count);
        System.out.println("Avg: "+avg);

    }

}
