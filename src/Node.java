public class Node {
   int key, height;
   Node left, right , parent;
   public Node(int key) {
       this.key = key;
       this.height = 0;
       this.left = null;
       this.right = null;
       this.parent = null;
   }

}
