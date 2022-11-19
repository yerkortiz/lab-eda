public class tree {
    public class TNode {
        int data;
        TNode left;
        TNode right;
        TNode(int d) {data = d;}
    }
    TNode root;
    public void insert(int d) {
        root = insertRec(root, d);
    }
    public TNode insertRec(TNode root, int key) { 
        if (root == null) { 
            root = new TNode(key); 
            return root; 
        } 
        if (key < root.data) 
            root.left = insertRec(root.left, key); 
        else if (key > root.data) 
            root.right = insertRec(root.right, key); 
        return root; 
    } 
    public void inorder() { 
       inorderAux(root); 
    } 
    void inorderAux(TNode root) { 
        if (root != null) { 
            inorderAux(root.left); 
            System.out.println(root.data); 
            inorderAux(root.right); 
        } 
    }
    public static void main(String[] args) {
        tree tree = new tree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.inorder();
    }
}