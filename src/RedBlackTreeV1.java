public class RedBlackTreeV1<T extends Comparable<T>> implements DataStructureV1<T> {
    static class Node<T extends Comparable<T>>{
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        int color; //1-RED, 0-BLACK
        Node() {
            left = null;
            right = null;
            parent = null;
            color = 0;
        }
        Node(T d) {
            data = d;
            left = null;
            right = null;
            parent = null;
            color = 0;
        }
    }

    private Node<T> root;
    private final Node<T> nil;
    public RedBlackTreeV1() {
        nil = new Node<>();
        nil.color = 0;
        root = nil;
    }

    private Node<T> createNewNode(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.color = 1;
        newNode.left = nil;
        newNode.right = nil;
        newNode.parent = nil;
        return newNode;
    }

    private void leftRotate(Node<T> x) {
        Node<T> y = x.right;
        x.right = y.left;
        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node<T> x) {
        Node<T> y = x.left;
        x.left = y.right;
        if (y.right != nil) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private Node<T> search(Node<T> node, T key) {
        if (node == nil) {
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

    @Override
    public void insert(T key) {
        if (search(root, key) != null) {
            return;
        }
        Node<T> z = createNewNode(key);
        Node<T> x = root;
        Node<T> y = nil;
        while (x != nil) {
            y = x;
            if (x.data.compareTo(z.data) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == nil) {
            root = z;
        } else if (y.data.compareTo(z.data) > 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.color = 1;
        insert_fix(z);
    }

    private void insert_fix(Node<T> z) {
        while (z.parent.color == 1) {
            if (z.parent == z.parent.parent.left) {
                Node<T> y = z.parent.parent.right;
                if (y.color == 1) {
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = 0;
                    z.parent.parent.color = 1;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node<T> y = z.parent.parent.left;
                if (y.color == 1) {
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = 0;
                    z.parent.parent.color = 1;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = 0;
    }

    private void transplant(Node<T> u, Node<T> v) {
        if (u.parent == nil) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private Node<T> treeMinimum(Node<T> node) {
        if (node == nil) {
            return nil;
        }
        if (node.left == nil) {
            return node;
        }
        return treeMinimum(node.left);
    }

    @Override
    public void delete(T key) throws ElementNotFoundException {
        Node<T> z = search(root, key);
        if (z == null) {
            throw new ElementNotFoundException();
        }
        Node<T> y = z;
        int yOriginalColor = y.color;
        Node<T> x;
        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMinimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y != z.right) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            } else {
                x.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0) {
            deleteFix(x);
        }
    }

    private void deleteFix(Node<T> x) {
        while (x != root && x.color ==0) {
            if (x == x.parent.left) {
                Node<T> w = x.parent.right;
                if (w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == 0 && w.right.color == 0) {
                    w.color = 1;
                    x = x.parent;
                } else {
                    if (w.right.color == 0) {
                        w.left.color = 0;
                        w.color = 1;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node<T> w = x.parent.left;
                if (w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == 0 && w.left.color == 0) {
                    w.color = 1;
                    x = x.parent;
                } else {
                    if (w.left.color == 0) {
                        w.right.color = 0;
                        w.color = 1;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    @Override
    public void ascendingOrder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if(node == nil) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

}
