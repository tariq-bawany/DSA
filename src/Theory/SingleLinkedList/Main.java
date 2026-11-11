package Theory.SingleLinkedList;

class Node {
    int data; // information
    Node next; // reference to next

    Node(int data) {
        this.data = data;
        // next is null by default
    }

    void display() {
        System.out.print(data + " ");
    }
}


class SinglyLinkedList {
    private Node head;

    // null = empty list
    boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head; // start at head
        while (temp != null) { // until the end
            temp.display(); // print data
            temp = temp.next; // next node
        }
        System.out.println();
    }


    // returns the 1-based position, or -1
    public int search(int key) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key)
                return pos; // found it
            temp = temp.next;
            pos++;
        }
        return -1; // not found
    }

    public void insertFirst(int info) {
        Node newNode = new Node(info); // 1
        newNode.next = head; // 2 new → old first
        head = newNode; // 3 head → new
    }

    public void insertLast(int info) {
        Node newNode = new Node(info); // next = null
        if (head == null) { // empty list
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) // find last
            temp = temp.next;
        temp.next = newNode; // old last → new
    }


    // n is 1-based; read it with sc.nextInt()
    public void insertAfter(int n, int info) {
        if (n < 1) {
            System.out.println("Invalid node position");
            return;
        }
        Node temp = head;
        for (int i = 1; i < n && temp != null; i++)
            temp = temp.next; // go to node n
        if (temp == null) {
            System.out.println(n + " node does not exist");
            return;
        }
        Node newNode = new Node(info);
        newNode.next = temp.next; // new → successor
        temp.next = newNode; // node n → new
    }


    public Node deleteFirst() { // assumes !isEmpty()
        Node temp = head; // save old first
        head = head.next; // head → second
        return temp; // GC reclaims old first
    }

    public void deleteLast() {
        if (head == null) return; // empty
        if (head.next == null) { // one node
            head = null;
            return;
        }
        Node temp1 = head, oldTemp = null;
        while (temp1.next != null) {
            oldTemp = temp1; // previous
            temp1 = temp1.next; // current
        }
        oldTemp.next = null; // new tail
    }


    public void deleteAt(int n) {
        if (head == null || n<1) return;
        if (n == 1) { // first node
            head = head.next;
            return;
        }
        Node oldTemp = null, temp1 = head;
        for (int i = 1; i < n && temp1 != null; i++) {
            oldTemp = temp1; // previous
            temp1 = temp1.next; // current
        }
        if (temp1 == null) return; // no node n
        oldTemp.next = temp1.next; // bypass it
    }


    public void sort() {
        for (Node t1 = head; t1 != null; t1 = t1.next)
            for (Node t2 = t1.next; t2 != null;
                 t2 = t2.next)
                if (t1.data > t2.data) {
                    int tmp = t1.data; // swap
                    t1.data = t2.data;
                    t2.data = tmp;
                }
    }




    // insert, delete, display…
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.display(); // empty list first
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.display(); // head → … → null
    }
}
