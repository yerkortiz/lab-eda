public class LinkedList {
    Node head;
    static class Node {
        int value;
        Node next;
        Node(int v) {
            value = v;
            next = null;
        }
    }
    LinkedList(int v) {
        head = new Node(v);
    }

    void insert(int x) {
        if (head == null) {
            head = new Node(x);
            return;
        }
        Node aux = head;
        while(aux.next != null ){
            aux = aux.next;
        }
        aux.next = new Node(x);
    }

    void printRecursive(Node aux) {
        if (aux == null) return;
        System.out.println(aux.value);
        printRecursive(aux.next);
    }

    void insertSorted(int x) {
        Node n = new Node(x);
        if(head == null) {
            head = n;
            return;
        }
        Node aux = head;
        Node prev = null;
        while(aux != null) {
            if(aux.value > x) {
                break;
            }
            prev = aux;
            aux = aux.next;
        }
        prev.next = n;
        n.next = aux;
    }
    public static void main(String []args) {
        LinkedList l = new LinkedList(0);
        l.insert(1);
        l.insert(6);
        l.insertSorted(5);
        l.insertSorted(9);
        l.insertSorted(5);
        l.printRecursive(l.head);
    }
}