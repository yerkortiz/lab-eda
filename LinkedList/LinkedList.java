public class LinkedList{
    Node head;
    LinkedList(){
        head = null;
    }
    LinkedList(int x){
        head = new Node(x);
    }
    LinkedList(Node n) {
        head = n;
    }
    static class Node {
        int value;
        Node next;
        Node(int x) {
            value = x;
            next = null;
        }
        Node(int x, Node n) {
            value = x;
            next = n;
        }
    }

    Node begin() {
        return head;
    }

    void insertBegin(int x){
        if(head == null) {
            head = new Node(x);
            return;
        }
        Node aux = new Node(x, head);
        head = aux;
        return;
    }

    void removeBegin() {
        if(head == null) {
            return;
        }
        head = head.next;
        return;
    }

    void recursivePrint(Node n) {
        if(n == null){
            return;
        }
        System.out.println(n.value);
        recursivePrint(n.next);
    }

    Node recursiveLast(Node n) {
        if(n == null) {
            return null;
        }
        if(n.next == null){
            return n;
        }
        return recursiveLast(n.next);
    }

    void insertEnd(int x) {
        Node tail = recursiveLast(head);
        if (tail == null) {
            head = new Node(x);
            return;
        }
        tail.next = new Node(x);
    }

    void removeLast(Node n) {
        if(n == null) {
            return;
        }
        if(n.next == null) {
            head = null;
            return;
        }
        if(n.next.next == null) {
            n.next = null;
            return;
        }
        removeLast(n.next);
    }

    boolean search(Node n, int target) {
        if(n == null) {
            System.out.printf("target %d is not present", target);
            return false;
        } 
        if (n.value == target) {
            System.out.printf("target %d is present", target);
            return true;
        }
        return search(n.next, target);
    }

    void reverse(Node n, Node prev) {
        if(n == null){
            return;
        }
        if(n.next == null) {
            n.next = prev;
            head = n;
            return;
        }
        reverse(n.next, n);
        n.next = prev;
    }

    boolean checkIsSorted(Node n, Node prev) {
        if(n == null) {
            System.out.println("is sorted");
            return true;
        }
        if (prev == null) {
            return checkIsSorted(n.next, n);
        }
        if(n.value < prev.value) {
            System.out.println("is not sorted");
            return false;
        }
        return checkIsSorted(n.next, n);
    }

    void mergeInOrder(Node current, Node n1, Node n2){
        if(n1 == null && n2 == null) {
            return;
        } else if (n1 == null) {
            head = n2;
            return;
        } else if(n2 == null) {
            head = n1;
            return;
        }

        if(n1.value < n2.value) {
            current = n1;
            n1 = n1.next;
        } else {
            current = n2;
            n2 = n2.next;
        }

        head = current;
        auxMergeInOrder(current, n1, n2);
    }

    void auxMergeInOrder(Node current, Node n1, Node n2) {
        if(n1 == null && n2 == null) {
            return;
        } else if(n1 == null) {
            current.next = n2;
            n2 = n2.next;
        } else if(n2 == null) {
            current.next = n1;
            n1 = n1.next;
        } else {
            if(n1.value < n2.value) {
                current.next = n1;
                n1 = n1.next;
            } else {
                current.next = n2;
                n2 = n2.next;
            }
        }
        auxMergeInOrder(current.next, n1, n2);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertEnd(3);
        ll.insertEnd(6);
        ll.insertEnd(9);
        // ll.removeLast(ll.begin());
        // ll.recursivePrint(ll.begin());
        // ll.search(ll.begin(), 101);
        // ll.reverse(ll.begin(), null);
        // ll.recursivePrint(ll.begin());
        // ll.checkIsSorted(ll.begin(), null);
        LinkedList ll2 = new LinkedList();
        ll2.insertEnd(4);
        ll2.insertEnd(5);
        ll2.insertEnd(8);
        ll.mergeInOrder(null, ll.begin(), ll2.begin());
        ll.recursivePrint(ll.begin());
    }
}