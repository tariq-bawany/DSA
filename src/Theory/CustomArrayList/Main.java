package Theory.CustomArrayList;

// isEmpty() -> check is array empty or not
// get(int index) -> returns the elements at the index
// checkIndex(int index) -> check for index validity , is valid or not
// indexOf(int value) -> returns the index of the value
// insert(int index, int value) -> insert at position
// remove(int index) -> delete from position
// removeValue(int value) -> delete the specific element
// add(int value) -> insert at last / push
// grow() -> increase the array to double
// display() -> display the array element



class SeqList {
    int[] elements;
    int arraySize;

    //    Constructor for initializing the elements Lab.Array with user defined size
//    there is 0 elements inside array at start
    SeqList(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Lab.Array Size must be greater than 0.");
        }
        elements = new int[size];
        arraySize = 0;
    }

    boolean isEmpty() {
//        if arraySize = 0  will return true , else will return false
        return arraySize == 0;
    }

    int get(int index) {
//        checks for input , is valid or not
        checkIndex(index);

//        if valid will return the element at that index
        return elements[index];
    }

    private void checkIndex(int index) {
//        if there is invalid input will throw error
//        if not invalid index , nothing will be changed
        if (index < 0 || index >= arraySize) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. \nIndex:" + index + " Size:" + arraySize);
        }

    }


    int indexOf(int value) {

        for (int i = 0; i < arraySize; i++) {
//            checks for value inside the array
            if (value == elements[i]) {
//                if found return the index of the element
                return i;
            }
        }
//        if not found return -1 indicating not found
        return -1;
    }

    void insert(int index, int x) {
        if (index < 0 || index > arraySize) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. \nIndex:" + index + " Size:" + arraySize);
        }
//        if the array is full already it will call grow() , and the array will be of double size
        if (arraySize == elements.length ) {
            grow();
        }

//        shifting elements towards right to make space for new element
        for (int i = arraySize - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = x;
        arraySize++;
    }

    void grow() {
//        created a new array with double length of elements array (default array)
        int[] newArr = new int[2 * elements.length];

//        stored the default elements array data in new array
        for (int i = 0; i < arraySize; i++) {
            newArr[i] = elements[i];
        }
//        replace the old array with new array
//        now data is stored and size is doubled
        elements = newArr;
    }


    void remove(int index) {
//        check the validity of index, is it valid or not
        checkIndex(index);

//        element to remove
        int remove = elements[index];

//        shifting the elements to left to override the element to remove
        for (int i = index; i < arraySize - 1; i++) {
            elements[i] = elements[i + 1];
        }

        arraySize--;
    }

    void add(int x) {
        insert(arraySize, x);
    }

    boolean removeValue(int x) {
//        gets the index of the element
        int index = indexOf(x);

//        checks if the returned index is -1 means not found / element not exists
        if (index == -1) return false;

//        if found remove the value from that index
        remove(index);
        return true;
    }


    void display() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    void insertOrdered(int val){
        int i =0;
        while(i<arraySize && val>elements[i]){
            i++;
        }
        insert(i,val);

    }
}

public class Main {
    public static void main(String[] args) {
        SeqList s1 = new SeqList(5);
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        System.out.println("Add elements");
        s1.display();
        System.out.println();

        System.out.println("insert 15 after 10 elements");
        s1.insert(1,15);
        s1.display();
        System.out.println();

        System.out.println("Delete 30 ");
        s1.removeValue(30);
        s1.display();
        System.out.println();

        System.out.println("Delete At index 2 ");
        s1.remove(2);
        s1.display();
        System.out.println();
    }


}