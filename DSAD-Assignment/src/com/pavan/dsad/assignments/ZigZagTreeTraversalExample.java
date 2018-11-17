package com.pavan.dsad.assignments;

import java.util.Stack;

//Binary Tree node 
class Node {
	int data;
	Node leftChild;
	Node rightChild;

	Node(int data) {
		this.data = data;
	}
}

class BinaryTree {
	Node root;

	// function to print the
	// zigzag traversal
	void displayZigZagTraversal() {

		// if null then return
		if (root == null) {
			return;
		}

		// declare two stacks
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		// push the root
		currentLevel.push(root);
		boolean leftToRight = true;

		// check if stack is empty
		while (!currentLevel.isEmpty()) {

			// pop out of stack
			Node node = currentLevel.pop();

			// print the data in it
			System.out.print(node.data + " ");

			// store data according to current
			// order.
			if (leftToRight) {
				if (node.leftChild != null) {
					nextLevel.push(node.leftChild);
				}

				if (node.rightChild != null) {
					nextLevel.push(node.rightChild);
				}
			} else {
				if (node.rightChild != null) {
					nextLevel.push(node.rightChild);
				}

				if (node.leftChild != null) {
					nextLevel.push(node.leftChild);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}
}

public class ZigZagTreeTraversalExample {

	// driver program to test the above function
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
		tree.root.rightChild = new Node(3);
		tree.root.leftChild.leftChild = new Node(4);
		tree.root.leftChild.rightChild = new Node(5);
		tree.root.rightChild.leftChild = new Node(6);
		tree.root.rightChild.rightChild = new Node(7);

		System.out.println("ZigZag Order traversal of binary tree is");
		tree.displayZigZagTraversal();
	}
}
