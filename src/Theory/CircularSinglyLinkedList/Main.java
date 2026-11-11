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
            System.out.println(temp.data+" ");
            temp = temp.next;
        }while(temp!=tail.next);
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
        newNode.next = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertAfter(int index, int data){
        if(index<1){
            System.out.println("No Node, Invalid Input.");
            return;
        }
        Node newNode = new Node(data);


    }


}
public class Main {
    public static void main(String[] args) {

    }
}
