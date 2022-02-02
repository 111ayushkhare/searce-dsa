package week4day3.practice.q1;

import java.io.FileWriter;
import java.io.IOException;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() { root = null; }

    void inorderTraversal(TreeNode root, FileWriter output) throws IOException {
        if (root == null) { return; }

        inorderTraversal(root.left, output);
        output.write(root.data + " ");
        inorderTraversal(root.right, output);
    }

    void preorderTraversal(TreeNode root, FileWriter output) throws IOException {
        if (root == null) { return; }

        output.write(root.data + " ");
        preorderTraversal(root.left, output);
        preorderTraversal(root.right, output);
    }

    void postorderTraversal(TreeNode root, FileWriter output) throws IOException {
        if (root == null) { return; }

        postorderTraversal(root.left, output);
        postorderTraversal(root.right, output);
        output.write(root.data + " ");
    }
}
