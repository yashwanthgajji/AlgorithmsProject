public class BinarySearchTreeV1<T extends Comparable<T>> implements DataStructureV1<T> {
    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        Node() {
            left = null;
            right = null;
            parent = null;
        }
        Node(T key) {
            data = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node<T> root;

    public BinarySearchTreeV1() {
        root = null;
    }

    @Override
    public void ascendingOrder() {
        System.out.println("Ascending order of data:");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void insert(T key) {
        if(search(root, key) == null) {
            root = insertRec(root, key);
        }
    }

    private void insert(Node<T> node, T key) {
        if(root == null) {
            root = new Node<>(key);
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
    }

    private Node<T> insertRec(Node<T> node, T key) {
        if(node == null) {
            return new Node<>(key);
        }
        if(node.data.compareTo(key) > 0) {
            Node<T> temp = insertRec(node.left, key);
            temp.parent = node;
            node.left = temp;
        } else {
            Node<T> temp = insertRec(node.right, key);
            temp.parent = node;
            node.right = temp;
        }
        return node;
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

    private Node<T> treeMinimum(Node<T> node) {
        if(node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return treeMinimum(node.left);
    }
}
