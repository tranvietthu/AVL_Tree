public class App {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = {10, 5, 15, 3, 7, 12, 18, 2, 1};

        for (int key : values) {
            tree.add(key);
            System.out.println("Them " + key + " | root=" + tree.root.key
                + " | AVL hop le: " + tree.isValidAVL());
        }
        System.out.print("BFS: ");
        tree.BFS(tree.root);
        System.out.print("\nInOrder: ");
        tree.inOrder(tree.root);
        System.out.println("\nChieu cao (nut la = 0): " + tree.height(tree.root));
        System.out.println("Tim 12: " + (tree.search(12) != null));

        int[] deleted = {3, 10, 1};
        for (int key : deleted) {
            System.out.println("Xoa " + key + ": " + tree.delete(key)
                + " | AVL hop le: " + tree.isValidAVL());
        }
        System.out.print("BFS sau xoa: ");
        tree.BFS(tree.root);
        System.out.println();
    }
}
