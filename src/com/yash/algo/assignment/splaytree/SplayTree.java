package com.yash.algo.assignment.splaytree;


import com.yash.algo.assignment.ElementNotFoundException;

public class SplayTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        Node() {
            left = null;
            right = null;
            parent = null;
        }
        Node(int key) {
            data = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node root;

    public SplayTree() {
        root = null;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    public void insert(int key) {
        if(search(key) == null) {
            insert(root, key);
        }
    }

    private void insert(Node node, int key) {
        if(root == null) {
            root = new Node(key);
            splay(root);
            return;
        }
        Node p = root;
        Node q = root;
        while(p!=null) {
            if(p.data > key) {
                q = p;
                p = p.left;
            } else {
                q = p;
                p = p.right;
            }
        }
        p = new Node(key);
        p.parent = q;
        if(q.data > key) {
            q.left = p;
        } else {
            q.right = p;
        }
        splay(p);
    }

    public Node search(int key) {
        Node node = search(root, key);
        if (node != null) {
            splay(node);
        }
        return node;
    }

    private Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.data == key) {
            return node;
        }
        if (node.data > key) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    private void leftRotate(Node p) {
        Node q = p.right;
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

    private void rightRotate(Node p) {
        Node q = p.left;
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

    private void splay(Node node) {
        while (node.parent != null) {
            if(node.parent.left == node) {
                rightRotate(node.parent);
            } else {
                leftRotate(node.parent);
            }
        }
    }

    public void delete(int key) throws ElementNotFoundException {
        Node p = search(key);
        if (p == null) {
            throw new ElementNotFoundException();
        }
        //Todo Remove the key and join the two sub trees.
        Node leftSubTree = p.left;
        Node rightSubTree = p.right;
        if(leftSubTree == null) {
            root = rightSubTree;
            rightSubTree.parent = null;
        } else if(rightSubTree == null) {
            root = leftSubTree;
            leftSubTree.parent = null;
        } else {
            leftSubTree.parent = null;
            rightSubTree.parent = null;
            Node leftMax = treeMaximum(leftSubTree);
            splay(leftMax);
            root = leftMax;
            leftMax.right = rightSubTree;
            rightSubTree.parent = leftMax;
        }
    }

    private Node treeMaximum(Node node) {
        if(node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return treeMaximum(node.right);
    }
}
