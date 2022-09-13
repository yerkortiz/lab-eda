public class CircularList {

    Node head;
    Node tail;

    CircularList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    CircularList(){
        this.head = null;
        this.tail = null;
    }
    static class Node {
        int value;
        Node next;
        //constructores
        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //insertar al final en una lista circular
    void Insert(int value){
        Node insertNode = new Node(value);
        //caso cuando esta vacia se actualiza head y tail
        if(head == null) {
            head = insertNode;
            tail = insertNode;
            //el next de tail siempre debe apuntar a head para mantener la propiedad circular
            tail.next = head;
            return;
        }

        //caso cuando no esta vacia la lista se actualiza
        //solo tail
        tail.next = insertNode;
        tail = insertNode;
        //el next de tail siempre debe apuntar a head para mantener la propiedad circular
        tail.next = head;
        return;
    }
    //imprime la lista
    void PrintCircularList(Node current, boolean visitedHead) {
        //condicion de termino, dado que la lista es circular
        //ya no termina en null, sino que termina cuando visita por segunda
        //vez el head de la lista.
        if (current == head && visitedHead) {
            return;
        }
        //en caso que visitemos por primera vez el head de la lista
        //marcamos el flag visitedHead como true
        if(current == head) {
            visitedHead = true;
        }
        //el resto es igual al print recursivo de una lista enlazada
        System.out.printf("node with value %d \n", current.value);
        PrintCircularList(current.next, visitedHead);
    }

    // elimina un nodo especifico en la lista
    // retorna un booleano en caso de borrarlo
    // solo retorna false cuando el elemento no
    // esta presente en la lista.
    boolean DeleteTarget(int target) {
        Node prev = null;
        Node aux = head;
        boolean visitedHead = false;
        while(aux != head || !visitedHead) {
            if(aux == head) {
                visitedHead = true;
            }
            if(aux.value == target) {
                if (head == tail) {
                    head = null;
                    tail = null;
                    return true;
                } else if(aux == head) {
                    head = head.next;
                    tail.next = head;
                    return true;
                } else if (aux == tail) {
                    tail = prev;
                    tail.next = head;
                    return true;
                } else {
                    prev.next = aux.next;
                    return true;
                }
            }
            prev = aux;
            aux = aux.next;
        }
        return false;
    }
    public static void main(String[] args) {
        CircularList cl = new CircularList();
        cl.Insert(10);
        cl.Insert(20);
        cl.Insert(50);
        cl.PrintCircularList(cl.head, false);
        cl.DeleteTarget(50);
        cl.PrintCircularList(cl.head, false);
    }
}
