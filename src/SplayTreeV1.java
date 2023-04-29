public class SplayTreeV1<T extends Comparable<T>> implements DataStructureV1<T> {
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

    public SplayTreeV1() {
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
        System.out.print(node.data+", ");
        inorder(node.right);
    }

    @Override
    public void insert(T key) {
        if(search(root, key, false) == null) {
            insert(root, key);
        }
    }

    private void insert(Node<T> node, T key) {
        if(root == null) {
            root = new Node<>(key);
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
        splay(p);
    }

    public Node<T> search(T key) {
        return search(root, key, false);
    }

    private Node<T> search(Node<T> node, T key, boolean isDelete) {
        Node<T> p = node;
        Node<T> q = node;
        while (p != null) {
            if (p.data.equals(key)) {
                splay(p);
                return p;
            } else if (p.data.compareTo(key) > 0) {
                q = p;
                p = p.left;
            } else {
                q = p;
                p  =p.right;
            }
        }
        if (isDelete && q !=null) {
            splay(q);
        }
        return null;
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
    }

    private void splay(Node<T> node) {
        while (node.parent != null) {
            if(node.parent.left == node) {
                rightRotate(node.parent);
            } else {
                leftRotate(node.parent);
            }
        }
    }

    @Override
    public void delete(T key) throws ElementNotFoundException {
        Node<T> p = search(root, key, true);
        if (p == null) {
            throw new ElementNotFoundException();
        }
        Node<T> leftSubTree = p.left;
        Node<T> rightSubTree = p.right;
        if(leftSubTree == null) {
            root = rightSubTree;
            if (rightSubTree != null) {
                rightSubTree.parent = null;
            }
        } else if(rightSubTree == null) {
            root = leftSubTree;
            if (leftSubTree != null) {
                leftSubTree.parent = null;
            }
        } else {
            leftSubTree.parent = null;
            rightSubTree.parent = null;
            Node<T> leftMax = treeMaximum(leftSubTree);
            splay(leftMax);
            root = leftMax;
            leftMax.right = rightSubTree;
            rightSubTree.parent = leftMax;
        }
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
