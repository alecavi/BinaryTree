package tree;

/**
 * A binary search tree, automatically kept sorted in ascending order
 * @author Alessandro Cavicchioli
 * @version 1.0
 * @param <T> the type of the elements in the tree
 */
public class BinaryTree<T extends Comparable<T>>
{	
	private Node<T> root;
	
	//TODO: a node has a "count" which is increased when adding duplicate elements
	/**
	 * Recursively traverses the (sub)tree and adds the new node in the appropriate position.
	 * @param newNode the node to add
	 * @param current the node currently being visited
	 * @throws IllegalArgumentException if the element is already in the tree
	 */
	private void add(Node<T> newNode, Node<T> current)
	{	
		int cmp = newNode.compareTo(current);
		if(cmp < 0) //newElement < current
		{
			if(current.leftChild == null) current.leftChild = newNode;
			else add(newNode, current.leftChild);
		}
		else if(cmp > 0) //newElement > current
		{
			if(current.rightChild == null) current.rightChild = newNode;
			else add(newNode, current.rightChild);
		}
		else throw new IllegalArgumentException("Duplicate element");
	}
	
	/**
	 * Recursively traverses the tree and adds the element in the appropriate position
	 * @param newElement the element to add
	 * @throws IllegalArgumentException if the element is already in the tree
	 */
	public void add(T newElement)
	{
		add(new Node<T>(newElement, null, null), root);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * A single node of the tree
	 * @author Alessandro Cavicchioli
	 * @version 1.0
	 * @param <T> the type of the elements in the node
	 */
	private class Node<T extends Comparable<T>>
	implements Comparable<Node<T>>
	{
		private T element;
		private Node<T> leftChild;
		private Node<T> rightChild;
		
		private Node(T element, Node<T> leftChild, Node<T> rightChild)
		{
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		@Override
		public int compareTo(Node<T> otherNode)
		{
			return this.element.compareTo(otherNode.element);
		}
	}
}
