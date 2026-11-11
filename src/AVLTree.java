import java.util.LinkedList;
import java.util.Queue;

/** Cây AVL tự cài đặt, duy trì liên kết parent và chiều cao ở từng nút. */
public class AVLTree {
    Node root;

    public AVLTree() {
        root = null;
    }

    // O(1): chiều cao được lưu và duy trì sau mỗi lần thay đổi cấu trúc.
    public int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    /** Xoay trái tại x; cập nhật cả liên kết với cha và root nếu cần. */
    public Node leftRotate(Node x) {
        if (x == null || x.right == null) {
            throw new IllegalArgumentException("Xoay trai can nut co con phai");
        }
        Node y = x.right;
        Node t2 = y.left;
        Node oldParent = x.parent;

        y.parent = oldParent;
        if (oldParent == null) {
            root = y;
        } else if (oldParent.left == x) {
            oldParent.left = y;
        } else {
            oldParent.right = y;
        }

        y.left = x;
        x.parent = y;
        x.right = t2;
        if (t2 != null) {
            t2.parent = x;
        }

        updateHeight(x);
        updateHeight(y);
        return y;
    }

    /** Xoay phải tại y; cập nhật cả liên kết với cha và root nếu cần. */
    public Node rightRotate(Node y) {
        if (y == null || y.left == null) {
            throw new IllegalArgumentException("Xoay phai can nut co con trai");
        }
        Node x = y.left;
        Node t2 = x.right;
        Node oldParent = y.parent;

        x.parent = oldParent;
        if (oldParent == null) {
            root = x;
        } else if (oldParent.left == y) {
            oldParent.left = x;
        } else {
            oldParent.right = x;
        }

        x.right = y;
        y.parent = x;
        y.left = t2;
        if (t2 != null) {
            t2.parent = y;
        }

        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /** Cập nhật chiều cao và cân bằng từ node đi ngược về root. */
    private void rebalanceUp(Node node) {
        while (node != null) {
            updateHeight(node);
            int balance = getBalance(node);

            if (balance > 1) {
                // LR: con trái nghiêng phải, xoay trái trước rồi xoay phải.
                if (getBalance(node.left) < 0) {
                    leftRotate(node.left);
                }
                Node newRoot = rightRotate(node); // LL (hoặc bước 2 của LR)
                node = newRoot.parent;
            } else if (balance < -1) {
                // RL: con phải nghiêng trái, xoay phải trước rồi xoay trái.
                if (getBalance(node.right) > 0) {
                    rightRotate(node.right);
                }
                Node newRoot = leftRotate(node); // RR (hoặc bước 2 của RL)
                node = newRoot.parent;
            } else {
                node = node.parent;
            }
        }
    }

    /** Thêm khóa duy nhất. Trả về false nếu khóa đã có. */
    public boolean add(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key == current.key) {
                return false; // Chính sách: không chèn khóa trùng.
            }
            current = key < current.key ? current.left : current.right;
        }

        Node inserted = new Node(key);
        inserted.parent = parent;
        if (key < parent.key) {
            parent.left = inserted;
        } else {
            parent.right = inserted;
        }
        rebalanceUp(parent);
        return true;
    }

    public Node search(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return current;
            current = key < current.key ? current.left : current.right;
        }
        return null;
    }

    /** Thay thế nút oldNode trong liên kết từ cha bởi replacement. */
    private void replaceNode(Node oldNode, Node replacement) {
        Node parent = oldNode.parent;
        if (parent == null) {
            root = replacement;
        } else if (parent.left == oldNode) {
            parent.left = replacement;
        } else {
            parent.right = replacement;
        }
        if (replacement != null) {
            replacement.parent = parent;
        }
    }

    /** Xóa khóa nếu có và cân bằng lại từ nơi thay đổi cấu trúc. */
    public boolean delete(int key) {
        Node target = search(key);
        if (target == null) return false;

        if (target.left != null && target.right != null) {
            // Lấy nút nhỏ nhất cây con phải (in-order successor).
            Node successor = target.right;
            while (successor.left != null) successor = successor.left;
            target.key = successor.key;
            target = successor; // successor có tối đa một con phải.
        }

        Node child = target.left != null ? target.left : target.right;
        Node oldParent = target.parent;
        replaceNode(target, child);
        // Nếu xóa root có một con, child đã là root; nếu xóa lá root, root=null.
        rebalanceUp(oldParent != null ? oldParent : child);
        return true;
    }

    public void BFS(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.key + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    /** Kiểm tra cùng lúc tính BST, parent, chiều cao và điều kiện cân bằng AVL. */
    public boolean isValidAVL() {
        return validate(root, null, Long.MIN_VALUE, Long.MAX_VALUE) != Integer.MIN_VALUE;
    }

    // Giá trị MIN_VALUE báo cấu trúc không hợp lệ.
    private int validate(Node node, Node expectedParent, long min, long max) {
        if (node == null) return -1;
        if (node.parent != expectedParent || node.key <= min || node.key >= max) {
            return Integer.MIN_VALUE;
        }
        int lh = validate(node.left, node, min, node.key);
        if (lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rh = validate(node.right, node, node.key, max);
        if (rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int actual = Math.max(lh, rh) + 1;
        if (Math.abs(lh - rh) > 1 || node.height != actual) {
            return Integer.MIN_VALUE;
        }
        return actual;
    }
}

        