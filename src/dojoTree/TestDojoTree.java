package dojoTree;

public class TestDojoTree {
	public static void main(String[] args) {
		Node<Integer> myTree = new Node<>(12);
		
		myTree.add(1);
		myTree.add(13);
		myTree.add(-90);
		myTree.add(100);
		myTree.add(4);
		myTree.add(6);
		myTree.add(-5);
		myTree.add(19);
		
		System.out.println(myTree.search(-5));
		myTree.inOrderTraversal();
		
		System.out.println(myTree.delete(100));
		
		
		
	}

}
