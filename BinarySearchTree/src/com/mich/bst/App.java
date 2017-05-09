package com.mich.bst;

public class App {

	public static void main(String[] args) {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(-1);
		bst.insert(1);
		bst.insert(0);
		bst.insert(1000);
		bst.insert(-22);
		bst.insert(4);
		
		System.out.println(bst.getMaxValue());
		System.out.println(bst.getMinValue());
		bst.traversal();
		bst.delete(10);
		bst.traversal();
	}

}
