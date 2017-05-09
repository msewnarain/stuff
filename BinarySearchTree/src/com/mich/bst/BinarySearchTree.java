package com.mich.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}
	}

	@Override
	public T getMinValue() {
		if (root == null)
			return null;
		return getMin(root);
	}

	@Override
	public T getMaxValue() {
		if (root == null)
			return null;
		return getMax(root);
	}

	@Override
	public void traversal() {
		if (root != null) {
			inOrderTraversal(root);
		}
	}

	@Override
	public void delete(T data) {
		if (root != null) {
			root = delete(root, data);
		}
	}

	private void inOrderTraversal(Node<T> node) {
		if (node.getLeftChild() != null)
			inOrderTraversal(node.getLeftChild());
		System.out.print(node + " ==> ");

		if (node.getRightChild() != null)
			inOrderTraversal(node.getRightChild());
	}

	private void insertNode(T newData, Node<T> node) {
		if (newData.compareTo(node.getData()) < 0) {
			if (node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		} else {
			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
	}

	private Node<T> delete(Node<T> node, T data) {
		if (node == null)
			return node;

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(delete(node.getLeftChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(delete(node.getRightChild(), data));
		} else {
			if(node.getLeftChild() == null && node.getRightChild() == null){
				System.out.println("removing leaf node..");
				return null;
			}
			if(node.getLeftChild() == null){
				System.out.println("removing the right child..");
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			}else if(node.getRightChild() == null){
				System.out.println("removing the left child..");
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}
			System.out.println("removing item with two children..");
			Node<T> tmpNode = getPredecessor(node.getLeftChild());
			node.setData(tmpNode.getData());
			node.setLeftChild(delete(node.getLeftChild(), tmpNode.getData()));
		}
		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRightChild() != null){
			return getPredecessor(node.getRightChild());
		}
		System.out.println("predecessor is " + node);
		return node;
	}

	private T getMax(Node<T> node) {
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
	}

	private T getMin(Node<T> node) {
		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}

}
