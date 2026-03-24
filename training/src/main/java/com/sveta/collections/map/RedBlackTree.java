package com.sveta.collections.map;

public class RedBlackTree<K extends Comparable<K>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        Node left, right, parent;
        boolean color;

        Node(K key, boolean color, Node parent) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = NIL;
            this.right = NIL;
        }
    }

    private final Node NIL = new Node(null, BLACK, null);
    private Node root = NIL;

    public void insert(K key) {
        Node node = new Node(key, RED, null);
        root = bstInsert(root, node);
        fixInsert(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == NIL) return node;

        if (node.key.compareTo(root.key) < 0) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.key.compareTo(root.key) > 0) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixInsert(Node k) {
        while (k.parent != null && k.parent.color == RED) {
            Node parent = k.parent;
            Node grandparent = parent.parent;
            if (grandparent == null) break;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;
                if (uncle != NIL && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    k = grandparent;
                } else {
                    if (k == parent.right) {
                        rotateLeft(parent);
                        k = parent;
                        parent = k.parent;
                    }
                    rotateRight(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    k = parent;
                }
            } else {
                Node uncle = grandparent.left;
                if (uncle != NIL && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    k = grandparent;
                } else {
                    if (k == parent.left) {
                        rotateRight(parent);
                        k = parent;
                        parent = k.parent;
                    }
                    rotateLeft(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    k = parent;
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL) y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;

        y.right = x;
        x.parent = y;
    }

    public boolean contains(K key) {
        Node current = root;
        while (current != NIL) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) return true;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return false;
    }

    public void delete(K key) {
        Node node = root;
        Node parent = null;
        boolean isLeft = false;

        while (node != NIL && !node.key.equals(key)) {
            parent = node;
            if (key.compareTo(node.key) < 0) {
                node = node.left;
                isLeft = true;
            } else {
                node = node.right;
                isLeft = false;
            }
        }

        if (node == NIL) return;

        Node replacement;
        if (node.left == NIL && node.right == NIL) {
            replacement = NIL;
        } else if (node.left == NIL) {
            replacement = node.right;
        } else if (node.right == NIL) {
            replacement = node.left;
        } else {
            Node min = node.right;
            while (min.left != NIL) min = min.left;
            delete(min.key);
            min.left = node.left;
            min.right = node.right;
            if (min.left != NIL) min.left.parent = min;
            if (min.right != NIL) min.right.parent = min;
            replacement = min;
        }

        if (node == root) root = replacement;
        else if (isLeft) parent.left = replacement;
        else parent.right = replacement;

        if (replacement != NIL) replacement.parent = parent;
    }
}