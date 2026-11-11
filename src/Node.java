public class Node {
    int key;
    int height;
    Node left;
    Node right;
    Node parent;
    Node(int key){
        this.key = key;
        this.height = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
