package Lab.DoublyLinkedList;

class DL {
    class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    //    [prev - Head - next] -> [prev - data - next]
//    [prev - newNode - next]
    void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {

            head.previous = newNode; // current head .previous
            newNode.next = head; // newNode next
            head = newNode; // change head
        }
    }

    //    [prev - Head - next] -> [prev - data - next]

    void deleteAtHead() {
        if (head == null) {
            System.out.println("List is already empty.");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
    }

    //    [prev - Head - next] -> [prev - data - next]
//    [prev - newNode - next]
    void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

    }


    void deleteAtLast() {
        if (head == null) {
            System.out.println("List is already empty.");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
    }

    //    [prev - Head - next] -> [prev - data - next]
//    [prev - newNode - next]
    void insertAtPosition(int data, int pos) {
        if (pos < 0) {
            System.out.println("Invalid Input.");
        } else if (pos == 0) {
            insertAtHead(data);
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position Out of Bounds.");
                return;
            }

            if (temp.next == null) {
                insertAtLast(data);
                return;
            }

            Node newNode = new Node(data);

            newNode.next = temp.next;
            temp.next = newNode;
            newNode.previous = temp;
        }
    }


//    [prev - Head - next] -> [prev - data - next] -> [prev - tail - next]
    void deleteAtPos(int pos){
        if(head == null){
            System.out.println("List is already empty.");
            return;
        }
        if(pos<0){
            System.out.println("Invalid Input.");
            return;
        }
        if(pos == 0){
            deleteAtHead();
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos-1 && temp!=null; i++) {
            temp = temp.next;
        }

        if(temp == null || temp.next == null){
            System.out.println("Position Ouf Of Bound");
            return;
        }

        if(temp.next.next == null){
            deleteAtLast();
            return;
        }
        temp.next.next.previous = temp;
        temp.next = temp.next.next;

    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DL dl = new DL();

        dl.display();
        System.out.println();
        dl.insertAtHead(100);
        dl.insertAtHead(50);
        dl.insertAtPosition(120,2);
        dl.display();

    }
}
