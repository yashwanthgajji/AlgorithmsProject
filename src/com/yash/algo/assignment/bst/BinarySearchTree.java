package com.yash.algo.assignment.bst;

import com.yash.algo.assignment.ElementNotFoundException;

public class BinarySearchTree {
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

    public BinarySearchTree() {
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
        if(search(root, key) == null) {
            root = insertRec(root, key);
        }
    }

    private void insert(Node node, int key) {
        if(root == null) {
            root = new Node(key);
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
    }

    private Node insertRec(Node node, int key) {
        if(node == null) {
            return new Node(key);
        }
        if(node.data > key) {
            Node temp = insertRec(node.left, key);
            temp.parent = node;
            node.left = temp;
        } else {
            Node temp = insertRec(node.right, key);
            temp.parent = node;
            node.right = temp;
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

    private void transplant(Node a, Node b) {
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

    public void delete(int key) throws ElementNotFoundException {
        Node p = search(root, key);
        if (p == null) {
            throw new ElementNotFoundException();
        }
        if (p.left == null) {
            transplant(p, p.right);
        } else if(p.right == null) {
            transplant(p, p.left);
        } else {
            Node q = treeMinimum(p.right);
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

    private Node treeMinimum(Node node) {
        if(node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return treeMinimum(node.left);
    }
}
