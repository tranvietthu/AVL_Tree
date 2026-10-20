public class App {
    public static void main(String[] args) throws Exception {
        AVLTree tree = new AVLTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        // tree.add(7);
        // tree.add(12);
        // tree.add(18);
        // System.out.println("BFS Traversal of the AVL Tree:");
        tree.BFS(tree.root);
        System.out.println("\nHeight of the AVL Tree: " + tree.height(tree.root));
    }
}
