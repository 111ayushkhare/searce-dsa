package week4day3.practice.q1;

import java.io.FileWriter;
import java.io.IOException;

class TestBinaryTree {
    public static void main(String[] args) throws IOException {
        FileWriter output = new FileWriter("src/week4day3/practice/q1/output.txt", false);

        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        output.write("Inorder Traversal: ");
        bt.inorderTraversal(bt.root, output);

        output.write("\nPreorder Traversal: ");
        bt.preorderTraversal(bt.root, output);

        output.write("\nPostorder Traversal: ");
        bt.postorderTraversal(bt.root, output);

        output.close();
    }
}
