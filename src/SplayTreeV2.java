public class SplayTreeV2<T extends Comparable<T>> implements DataStructureV2<T> {
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

    public SplayTreeV2() {
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
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    @Override
    public void insert(T key) {
        if(search(key) == null) {
            insert(root, key);
        }
    }

    private void insert(Node<T> node, T key) {
        if(root == null) {
            root = new Node<>(key);
            manageUpperHeight(root);
            splay(root);
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
        splay(p);
    }

    public Node<T> search(T key) {
        Node<T> node = search(root, key);
        if (node != null) {
            splay(node);
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

    private void leftRotate(Node<T> p) {
        Node<T> q = p.right;
        if(q != null) {
            if(p.parent == null) {
                root = q;
            } else if(p.parent.left == p) {
                p.parent.left = q;
            } else {
                p.parent.right = q;
            }
            q.parent = p.parent;
            p.right = q.left;
            if (p.right != null) {
                p.right.parent = p;
            }
            q.left = p;
            p.parent = q;
        }
        manageUpperHeight(p);
    }

    private void rightRotate(Node<T> p) {
        Node<T> q = p.left;
        if(q != null) {
            if(p.parent == null) {
                root = q;
            } else if(p.parent.left == p) {
                p.parent.left = q;
            } else {
                p.parent.right = q;
            }
            q.parent = p.parent;
            p.left = q.right;
            if (p.left != null) {
                p.left.parent = p;
            }
            q.right = p;
            p.parent = q;
        }
        manageUpperHeight(p);
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

    private void splay(Node<T> node) {
        Node<T> x = node;
        Node<T> y = node.parent;
        Node<T> z = null;
        if (y != null) {
            z = node.parent.parent;
        } else {
            z = null;
        }
        while (y != null) {
            if (z == null) {
                if (y.left == x) {
                    rightRotate(y);
                } else {
                    leftRotate(y);
                }
            } else {
                if (z.left == y) {
                    if (y.left == x) {
                        rightRotate(z);
                        rightRotate(y);
                    } else {
                        leftRotate(y);
                        rightRotate(z);
                    }
                } else {
                    if(y.right == x) {
                        leftRotate(z);
                        leftRotate(y);
                    } else {
                        rightRotate(y);
                        leftRotate(z);
                    }
                }
            }
            y = x.parent;
            if (y != null) {
                z = y.parent;
            } else {
                z = null;
            }
        }
    }

    @Override
    public void delete(T key) throws ElementNotFoundException {
        Node<T> p = search(key);
        if (p == null) {
            throw new ElementNotFoundException();
        }
        Node<T> leftSubTree = p.left;
        Node<T> rightSubTree = p.right;
        if(leftSubTree == null) {
            root = rightSubTree;
            rightSubTree.parent = null;
        } else if(rightSubTree == null) {
            root = leftSubTree;
            leftSubTree.parent = null;
        } else {
            leftSubTree.parent = null;
            rightSubTree.parent = null;
            Node<T> leftMax = treeMaximum(leftSubTree);
            splay(leftMax);
            root = leftMax;
            leftMax.right = rightSubTree;
            rightSubTree.parent = leftMax;
            manageUpperHeight(root);
        }
    }

    @Override
    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    private Node<T> treeMaximum(Node<T> node) {
        if(node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return treeMaximum(node.right);
    }
}
