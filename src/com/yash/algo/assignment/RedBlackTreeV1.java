package com.yash.algo.assignment;

public class RedBlackTreeV1 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node parent;
        int color; //1-RED, 0-BLACK
        Node() {
            left = null;
            right = null;
            parent = null;
            color = 0;
        }
        Node(int d) {
            data = d;
            left = null;
            right = null;
            parent = null;
            color = 0;
        }
    }

    private Node root;
    private final Node nill = new Node(-1);
    public RedBlackTreeV1() {
        root = nill;
    }

    private Node createNewNode(int value) {
        Node newNode = new Node(value);
        newNode.color = 1;
        newNode.left = nill;
        newNode.right = nill;
        newNode.parent = nill;
        return newNode;
    }

    public void insert(int key) {
        if (root == nill) {
            root = createNewNode(key);
            insertFix(root);
        } else {
            Node p = root;
            Node q = p;
            while(p != nill) {
                if (p.data > key) {
                    q = p;
                    p = p.left;
                } else {
                    q = p;
                    p = p.right;
                }
            }
            p = createNewNode(key);
            if (q.data>key) {
                q.left = p;
            } else {
                q.right = p;
            }
            p.parent = q;
            insertFix(p);
        }
    }

    private void insertFix(Node z) {
        if(z == root) {
            z.color = 0;
            return;
        }
        while(z.parent.color == 1) {
            if(z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if(y.color == 1) {
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else {
                    if(z == z.parent.right) {
                        leftRotate(z.parent);
                    }
                    z.parent.color = 0;
                    z.parent.parent.color = 1;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if(y.color == 1) {
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else {
                    if(z == z.parent.left) {
                        rightRotate(z.parent);
                    }
                    z.parent.color = 0;
                    z.parent.parent.color = 1;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = 0;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != nill) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nill) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != nill) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nill) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    private Node search(Node node, int key) {
        if (node == nill) {
            return nill;
        }
        if (node.data == key) {
            return node;
        }
        if (node.data > key) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    private void transplant(Node x, Node y) {
        if(x.parent == nill) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.parent = x.parent;
    }

    private Node treeMinimum(Node node) {
        if(node == nill) {
            return nill;
        }
        if (node.left == nill) {
            return node;
        }
        return treeMinimum(node.left);
    }

    public void delete(int key) throws ElementNotFoundException {
        Node z = search(root, key);
        if (z == nill) {
            throw new ElementNotFoundException();
        }
        Node y = z;
        int y_original_color = y.color;
        Node x = nill;
        if(z.left == nill) {
            x = z.right;
            transplant(z, z.right);
        } else if(z.right == nill) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMinimum(z.right);
            y_original_color = y.color;
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
        if (y_original_color == 0) {
            deleteFix(x);
        }
    }

    private void deleteFix(Node x) {
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
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
                Node w = x.parent.left;
                if(w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
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

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if(node == nill) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }
}
