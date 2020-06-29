package dojoTree;

public class Node<E extends Comparable<E>> {
	
	E data;
	
	Node<E> left;
	Node<E> right;
	
	public Node(E data) {
		this.data = data;
		this.left = null; 
		this.right = null;
	}
	
	
	public void add(E item) {
		int comp = item.compareTo(this.data);
		if(comp <= 0) {
			if(left == null) {
				left = new Node(item);
			} else {
				left.add(item);
			}
		} else {
			if(right == null) {
				right = new Node(item);
			} else {
				right.add(item);
			}
		}
		
	}
	
	public boolean search(E item) {
		int comp = item.compareTo(this.data);
		if(comp == 0) {
			return true;
		} else if(comp < 0) {
			if(this.left == null) {
				return false;
			} else {
				return this.left.search(item);
			}
		} else {
			if(this.right == null) {
				return false;
			} else {
				return this.right.search(item);
			}
		}
	}
	
	public void inOrderTraversal() {
		if(this.left != null) {
			this.left.inOrderTraversal();
		}
		
		System.out.println(this.data);
		
		if(this.right != null) {
			this.right.inOrderTraversal();
		}
	}
	
	public boolean delete(E item) {
		@SuppressWarnings("unchecked")
		Node<E> focusNode = (Node<E>) this.data;
		@SuppressWarnings("unchecked")
		Node<E> parent = (Node<E>) this.data;
		
		boolean isItALeftChild = true;
		
		while (focusNode.data != this.data) {

            parent = focusNode;
            
		    if (data.compareTo(focusNode.data) < 0) {

                isItALeftChild = true;

                
                focusNode = focusNode.left;
                
		    } else {
		    	isItALeftChild = false;

		        focusNode = focusNode.right;
            }
	
            if (focusNode == null)
            	return false;
        }
		
		if (focusNode.left == null && focusNode.right == null) {
			if (focusNode.data == this.data) {
				this.data = null;
			} else if (isItALeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
					
		} else if(focusNode.right == null) {
			if (focusNode.data.compareTo(this.data) == 0) {
				this.data = (E) focusNode.left;
			} else if (isItALeftChild) {
				parent.left = focusNode.left;
			} else {
				parent.right = focusNode.left;
			}
			
		} else if (focusNode.left == null) {
			if (focusNode == this.data) {
				this.data = focusNode.right.data;
			} else if (isItALeftChild) {
				parent.left = focusNode.right;
			} else {
				parent.right = focusNode.right;
			}
			
		} else {
			Node replacement = getReplacementNode(focusNode);
			if(focusNode == this.data)
				this.data = (E) replacement;
			else if (isItALeftChild)
				parent.left = replacement;
			else
				parent.right = replacement;
			
			replacement.left = focusNode.left;
			
		}
		
		return true;
	}
	
	public Node getReplacementNode(Node replacedNode) {
		
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.right;
		
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.left;
			
		}
			
		if (replacement != replacedNode.right) {
			replacementParent.left = replacement.right;
			replacement.right = replacedNode.right;
			
		}
		
		return replacement;

	}

}
