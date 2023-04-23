public class BinarySearchTreeV2<T extends Comparable<T>> implements DataStructureV2<T> {
    static class Node<T extends Comparable<T>> {
        T data;
        int height;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        Node() {
            height = 0;
            left = null;
            right = null;
            parent = null;
        }
        Node(T key) {
            data = key;
            height = 0;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node<T> root;

    public BinarySearchTreeV2() {
        root = null;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    public void insert(T key) {
        if(search(root, key) == null) {
            insert(root, key);
        }
    }

    private void insert(Node<T> node, T key) {
        if(root == null) {
            root = new Node<>(key);
            manageUpperHeight(root);
            return;
        }
        Node<T> p = root;
        Node<T> q = root;
        while(p!=null) {
            if(p.data.compareTo(key) > 0) {
                q = p;
                p = p.left;
            } else {
                q = p;
                p = p.right;
            }
        }
        p = new Node<>(key);
        p.parent = q;
        if(q.data.compareTo(key) > 0) {
            q.left = p;
        } else {
            q.right = p;
        }
        manageUpperHeight(p);
    }

    private Node<T> search(Node<T> node, T key) {
        if (node == null) {
            return null;
        }
        if (node.data.equals(key)) {
            return node;
        }
        if (node.data.compareTo(key) > 0) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    private void transplant(Node<T> a, Node<T> b) {
        if (a.parent == null) {
            root = b;
        } else if(a == a.parent.left) {
            a.parent.left = b;
        } else {
            a.parent.right = b;
        }
        if(b != null) {
            b.parent = a.parent;
            manageUpperHeight(b);
        } else {
            manageUpperHeight(a.parent);
        }
    }

    public void delete(T key) throws ElementNotFoundException {
        Node<T> p = search(root, key);
        if (p == null) {
            throw new ElementNotFoundException();
        }
        if (p.left == null) {
            transplant(p, p.right);
        } else if(p.right == null) {
            transplant(p, p.left);
        } else {
            Node<T> q = treeMinimum(p.right);
            if (q != p.right) {
                transplant(q, q.right);
                q.right = p.right;
                q.right.parent = q;
            }
            transplant(p, q);
            q.left = p.left;
            q.left.parent = q;
        }
    }

    public void manageUpperHeight(Node<T> node) {
        if(node == null) {
            return;
        }
        int a = 0;
        int b = 0;
        if(node.left != null) {
            a = node.left.height;
        }
        if(node.right != null) {
            b = node.right.height;
        }
        node.height = Math.max(a, b) + 1;
        manageUpperHeight(node.parent);
    }

    private Node<T> treeMinimum(Node<T> node) {
        if(node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return treeMinimum(node.left);
    }

    @Override
    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height;
    }
}
