package Theory.DoublyLinkedList;

import org.w3c.dom.Node;

class DNode {
    int data;
    DNode prev; // predecessor
    DNode next; // successor

    DNode(int d) {
        data = d;
    }
}

class DoublyLinkedList {
    private DNode head, tail;

    public void displayForward() {
        DNode temp = head; // start at first
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // step forward
        }
        System.out.println();
    }
    public void displayBackward() {
        DNode temp = tail; // start at last
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev; // step backward
        }
        System.out.println();
    }

    public int search(int key) {
        DNode temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key)
                return pos; // found
            temp = temp.next;
            pos++;
        }
        return -1; // not found
    }

    public void insertFirst(int data){
        DNode n = new DNode(data);

        if(head == null){
            head = tail = n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void insertLast(int data){
        DNode n = new DNode(data);
        if(head==null){
            head = tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public void insertAfter(int index,int data){
        if(index<0) {
            System.out.println("No Node, Invalid Index.");
            return;
        }
        DNode n =new DNode(data);
        DNode temp = head;
        for(int i =1;i<index && temp!=null;i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("List Out of Bound.");
            return;
        }
        if (temp==tail){
            insertLast(data);
            return;
        }
        n.next = temp.next;
        n.prev  = temp;
        temp.next = n;
        temp.next.prev = n;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is Empty.");
            return;
        }
        if(head == tail){
            head =tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is Empty.");
            return;
        }
        if(head == tail){
            head =tail = null;
            return;
        }
        tail=tail.prev;
        tail.next = null;

    }

    public void deleteAt(int index){
        if(index<1){
            System.out.println("No Node , Invalid index.");
            return;
        }
        if(head == null){
            System.out.println("List is Empty.");
            return;
        }
        if(index ==1){
            deleteFirst();
            return;
        }

        DNode temp = head;
        for(int i =0;i<index && temp!=null;i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Out of Bound.");
            return;
        }
        if(temp == tail){
            deleteLast();
            return;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }



}

public class Main {
}
