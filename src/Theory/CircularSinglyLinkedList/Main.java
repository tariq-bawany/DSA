package Theory.CircularSinglyLinkedList;

class CSLL{
    class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }
    Node tail;

    boolean isEmpty(){return  tail==null;}

    public void display(){
        if(tail == null){
            System.out.println("List is empty.");
            return;
        }
//        if we use the while loop the condition would be temp != tail.next , that is the starting value so the loop would not run
        Node temp = tail.next;
        do{
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp!=tail.next);
        System.out.println();
    }

    public int search(int key){
        if(tail == null){
            System.out.println("List is empty.");
            return -1;
        }
        Node temp = tail.next;
        int pos=1;
        do{
            if(temp.data == key){
                return pos;
            }

            temp = temp.next;
            pos++;
        }while (temp!=tail.next);
        return -1;
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
    }

    public void insertLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            tail = newNode;
            newNode.next = tail;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertAfter(int index, int data){
        if(index<1){
            System.out.println("No Node, Invalid Input.");
            return;
        }
        Node newNode = new Node(data);
        Node temp = tail.next;
        for(int i =1;i<index;i++){
            temp = temp.next;
            if(temp == tail.next){
                System.out.println("Item not Found.");
                return;
            }
        }

        newNode.next = temp.next;
        temp.next = newNode;
        if(temp == tail) tail = newNode;
    }

    public void deleteFirst(){
        if(tail== null){
            System.out.println("List is Empty.");
            return;
        }
        if(tail.next == tail){
            tail =null;
            return;
        }
        tail.next = tail.next.next;
    }

    public void deleteLast(){
        if(tail == null){
            System.out.println("List is empty.");
            return;
        }
        if(tail.next == tail){
            tail =null;
            return;
        }
        Node temp = tail.next;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = tail.next;
        tail =temp;
    }

    public void deleteAt(int n){
        if(tail == null){
            System.out.println("List is empty.");
            return;
        }
        if(n<1){
            System.out.println("No Node, Invalid Index.");
            return;
        }
        Node temp = tail; // temp will be n-1
        for(int i =1;i<n;i++){
            temp = temp.next;
            if(temp == tail){
                System.out.println("Out Of Bound.");
                return;
            }
        }

        if(temp.next == temp){ // means a single node in list
            tail = null;
            return;
        }
        temp.next = temp.next.next;
        if(temp.next == tail)tail = temp;
    }


}
public class Main {
    public static void main(String[] args) {
        CSLL list = new CSLL();

        System.out.println("--- Testing Insertions ---");
        list.insertLast(20); // List: 20
        list.insertLast(30); // List: 20 30
        list.insertFirst(10); // List: 10 20 30
        list.display(); // Expected: 10 20 30

        System.out.println("\n--- Testing insertAfter ---");
        list.insertAfter(2, 25); // Insert 25 after node 2 (20) -> 10 20 25 30
        list.display(); // Expected: 10 20 25 30

        System.out.println("\n--- Testing Search ---");
        System.out.println("Search for 25: Position " + list.search(25)); // Expected: 3
        System.out.println("Search for 99: Position " + list.search(99)); // Expected: -1

        System.out.println("\n--- Testing Deletions ---");
        list.deleteFirst(); // Removes 10 -> List: 20 25 30
        System.out.print("After deleteFirst: ");
        list.display(); // Expected: 20 25 30

        list.deleteLast(); // Removes 30 -> List: 20 25
        System.out.print("After deleteLast: ");
        list.display(); // Expected: 20 25

        list.insertLast(40); // List: 20 25 40
        list.insertLast(50); // List: 20 25 40 50

        System.out.print("Before deleteAt(2): ");
        list.display(); // Expected: 20 25 40 50

        list.deleteAt(2); // Deletes node at position 2 (25) -> List: 20 40 50
        System.out.print("After deleteAt(2): ");
        list.display(); // Expected: 20 40 50
    }
}
