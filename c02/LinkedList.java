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
        if (aux == null) {
            return;
        }
        System.out.println(aux.value);
        printRecursive(aux.next);
    }

    void reverse(Node prev, Node current) {
        if (current == null) {
            head = prev;
            return;
        }
        reverse(current, current.next);
        current.next = prev;
    }

    void printRecursiveAux(Node aux, int k, int max) {
        if(k == max) return;
        if (aux == null) {
            return;
        }
        System.out.println(aux.value);
        printRecursiveAux(aux.next, k + 1, max);
    }

    void generateCycle(Node current) {
        if (current == null) return;
        if (current.next == null) {
            current.next = head;
            return;
        }
        generateCycle(current.next);
    }
    void printKEsim(Node current, int k, int target) {
        if(current == null) return;
        if(k == target) {
            System.out.println("found "+ target);
        }
        printKEsim(current.next, k + 1, target);

    }
    public static void main(String []args ) {
        LinkedList l = new LinkedList(0);
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        // l.printRecursive(l.head);
        // l.reverse(null, l.head);
        // l.generateCycle(l.head);
        l.printRecursive(l.head);
        // l.printRecursiveAux(l.head, 0, 20);
    }
}