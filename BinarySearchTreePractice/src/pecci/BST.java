package pecci;


public class BST {
	   Node root;

	   public BST() {
	      root = null;
	   }

	   public void addNode(String string) {
	      root = insert(string, root);
	      assert(root.word.equals(string)): "successfully inserted the right word";
	   }

	   private static Node insert(String string, Node node) {
	      if (node == null) {
	    	  return new Node(string);
	      }
	      int compare = string.compareTo(node.word);
	      if (compare < 0) {
	    	  assert (string.compareTo(node.word) < 0): node.word + " is larger than " + string;
	    	  node.left = insert(string, node.left);
	      }
	      else if (compare > 0) {
	    	  assert (string.compareTo(node.word) > 0): node.word + " is less than " + string;
	    	  node.right = insert(string, node.right);
	      }
	      assert(node.word.equals(string)) : "successfully inserted the right word";
	      return node;
	   }

	   public void show() {
	      show(root);
	   }

	   private static void show(Node node) {
	      if (node == null) {
	    	  return;
	      }
	      assert(node.left.word.compareTo(node.word) < 0 ): node.left.word + " is less than" + node.word;
	      show(node.left);
	      System.out.print(node.word + " ");
	      assert(node.right.word.compareTo(node.word) > 0 ): node.right.word + " is larger than" + node.word;
	      show(node.right);
	   }
	   
	   public boolean search(String word)  { 
	        root = search(root, word); 
	        if (root!= null) {
	        	assert(root!=null): word + " is in BST";
	        	return true;
	        }
	        else {
	        	assert(true): word + " is not found in BST";
	        	return false;
	        }
	    } 

	    private Node search(Node root, String word)  { 
	        if (root==null || root.word.contentEquals(word)) { 
	        	assert(root==null || root.word.contentEquals(word)):  word + " is found in BST or not in BST";
	        	return root; 
	        }
	        int compare = word.compareTo(root.word);
	        if (compare < 0) {
	        	assert(compare < 0): word + " is less than " + root.word;
	        	return search(root.left, word); 
	        }
	        assert(compare > 0): word + " is larger than " + root.word;
	        return search(root.right, word); 
	    } 
	    
		public void checkWord(String word) { 
	        root = checkWord(root, word);
	        assert(!search(word)): "Successfully removed word";
	    } 
	   
	    private Node checkWord(Node root, String word)  { 
	        if (root == null) {  
	        	assert(root == null): "Successfully removed word";
	        	return root;
	        }
	        int compare = word.compareTo(root.word);
	        if (compare < 0)  {  
	        	assert(compare < 0): word + " is less than " + root.word;
	        	root.left = checkWord(root.left, word); 
	        } 
	        else if (compare > 0) {
	        	assert(compare > 0): word + " is larger than " + root.word;
	        	root.right = checkWord(root.right, word); 
	        }
	        else  { 
	            if (root.left == null) {
	            	assert(root.left == null): root.right.word + " is the only child of root";
	                return root.right; 
	            }
	            else if (root.right == null) {
	            	assert(root.right == null): root.left.word + " is the only child of root";
	            	return root.left; 
	            }
	           root.word = minWord(root.right); 
	           root.right = checkWord(root.right, root.word); 
	        }        
	        return root; 
	    } 
	    
	   public String minWord(Node root)  { 
	        String minword = root.word; 
	        while (root.left != null)  { 
	            minword = root.left.word; 
	            root = root.left; 
	        } 
	        assert(root.left == null): minword + " is the smallest word";
	        return minword; 
	    } 

}
