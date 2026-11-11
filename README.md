# AVL Tree Implementation in Java / Cài đặt Cây AVL bằng Java

[English](#english) | [Tiếng Việt](#vi)

---

<a id="english"></a>

## English

A clean, self-balancing **AVL Tree** implementation in pure Java, featuring parent pointer tracking, iterative insertion/deletion, self-rebalancing mechanisms, and structure validation.

### Features

- **Parent Pointers:** Every node maintains an explicit reference to its `parent`, simplifying upward propagation and rotations.
- **Balanced Operations:** Automatic tree rebalancing via 4 rotation cases:
  - Left-Left (LL) & Right-Right (RR): single rotations
  - Left-Right (LR) & Right-Left (RL): double rotations
- **Core Operations:**
  - `add(key)`: iterative insertion with automatic bottom-up rebalancing (`O(log n)`).
  - `delete(key)`: deletion using the in-order successor with upward rebalancing (`O(log n)`).
  - `search(key)`: binary search for the target key (`O(log n)`).
- **Traversals:**
  - Breadth-First Search (BFS / level-order)
  - In-Order (sorted output)
  - Pre-Order
- **Integrity Validation (`isValidAVL`):** Verifies Binary Search Tree (BST) ordering, parent pointer consistency, calculated node heights, and the AVL balance condition (`-1 <= balance <= 1`).

### Project Structure

```text
.
├── Node.java       # Node representation (key, height, left, right, parent)
├── AVLTree.java    # AVL Tree logic (rotations, balancing, traversals, validation)
├── App.java        # Driver program demonstrating operations and verification
└── README.md
```

### Getting Started

#### Prerequisites

- Java Development Kit (JDK 8 or later)

#### Compilation & Execution

1. Compile all source files:

   ```bash
   javac *.java
   ```

2. Run the application:

   ```bash
   java App
   ```

### Complexity

| Operation | Average | Worst | Space |
| :--- | :--- | :--- | :--- |
| **Search** | `O(log n)` | `O(log n)` | `O(1)` |
| **Insert** | `O(log n)` | `O(log n)` | `O(1)` |
| **Delete** | `O(log n)` | `O(log n)` | `O(1)` |
| **Traversals** | `O(n)` | `O(n)` | `O(n)` (queue / recursion stack) |

---

<a id="vi"></a>

## Tiếng Việt

Dự án cài đặt cấu trúc dữ liệu **Cây cân bằng AVL (AVL Tree)** hoàn chỉnh bằng Java thuần, hỗ trợ liên kết nút cha (`parent`), các thao tác tự cân bằng và kiểm tra tính toàn vẹn của cây.

### Tính năng nổi bật

- **Quản lý nút cha (`parent`):** Mỗi nút lưu liên kết trực tiếp tới nút cha, giúp duyệt ngược lên gốc và cập nhật khi xoay cây trực quan, hiệu quả.
- **Cơ chế tự cân bằng:** Xử lý 4 trường hợp mất cân bằng kinh điển:
  - Lệch Trái - Trái (LL) & Phải - Phải (RR): xoay đơn.
  - Lệch Trái - Phải (LR) & Phải - Trái (RL): xoay kép.
- **Các thao tác chính:**
  - `add(key)`: thêm phần tử không đệ quy và cân bằng ngược lên gốc (`O(log n)`).
  - `delete(key)`: xóa phần tử bằng nút kế vị (in-order successor) và tái cân bằng (`O(log n)`).
  - `search(key)`: tìm kiếm nhị phân (`O(log n)`).
- **Các thuật toán duyệt cây:**
  - Duyệt theo chiều rộng (BFS / level-order)
  - Duyệt trung thứ tự (In-Order): xuất dữ liệu theo thứ tự tăng dần
  - Duyệt tiền thứ tự (Pre-Order)
- **Kiểm tra tính hợp lệ (`isValidAVL`):** Kiểm tra đồng thời tính chất BST, liên kết cha - con hai chiều, chiều cao thực tế và hệ số cân bằng AVL (`-1 <= hệ số <= 1`).

### Cấu trúc dự án

```text
.
├── Node.java       # Khai báo một nút (khóa, chiều cao, con trái/phải, nút cha)
├── AVLTree.java    # Logic cây AVL (xoay, cân bằng, duyệt, kiểm tra)
├── App.java        # Chương trình mẫu kiểm thử các chức năng
└── README.md
```

### Hướng dẫn chạy thử

#### Yêu cầu

- Đã cài đặt JDK (Java 8 trở lên)

#### Biên dịch và chạy

1. Biên dịch toàn bộ mã nguồn:

   ```bash
   javac *.java
   ```

2. Chạy chương trình:

   ```bash
   java App
   ```

### Độ phức tạp thuật toán

| Thao tác | Trung bình | Tệ nhất | Bộ nhớ |
| :--- | :--- | :--- | :--- |
| **Tìm kiếm (Search)** | `O(log n)` | `O(log n)` | `O(1)` |
| **Thêm (Insert)** | `O(log n)` | `O(log n)` | `O(1)` |
| **Xóa (Delete)** | `O(log n)` | `O(log n)` | `O(1)` |
| **Duyệt (Traversals)** | `O(n)` | `O(n)` | `O(n)` |

