import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    Node root;

    public AVLTree() {
        root = null;
    }
    public void BFS(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.key + " ");
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
    }
    public int height(Node node){
        if (node == null){
            return -1;
        }
        return height(node.left) > height(node.right) ? height(node.left) + 1 : height(node.right) + 1;
    }
    public void add(int key) {
        if(root ==null){
            this.root = new Node(key);
        }
        else {
            Node current = root;
            Node currentParent = null;
            while(current != null) {
                if (key  < current.key){
                    currentParent = current;
                    current = current.left;
                }
                else {
                    currentParent = current;
                    current = current.right;
                }
            }
            Node newNode = new Node(key);
            if (key < currentParent.key){
                currentParent.left = newNode;
            }
            else {
                currentParent.right = newNode;
            }
            newNode.parent = currentParent;
        }
    }
    public int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    public Node rightRotate(Node root){
        Node t = root;
        root = root.left;
        root.right = t;
        root.right = t.left;

        
    }
    public Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        y.parent = null;
        x.parent = y;
        return y;
    }
}
