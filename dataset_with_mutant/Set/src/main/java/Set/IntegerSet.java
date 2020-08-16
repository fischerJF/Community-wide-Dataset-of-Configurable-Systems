package Set;
//@ model import org.jmlspecs.models.*;
import java.util.*;

import specifications.Configuration;

/** A set of integers as a HashSet.
 * @author Katie Becker
 * @author Gary T. Leavens
 */

public   class  IntegerSet {
	
    // specification inherited
     private void  insert__wrappee__Tree(int elem) {
		if (isEmpty) {
            isEmpty = false;
            rootValue = elem;
        } else if (rootValue != elem) {
            if (elem < rootValue) {
                if (left == null) {
                    left = new IntegerSet(elem, this);
                } else {
                    left.insert(elem);
                }
            } else {
                //@ assume rootValue < elem;
                if (right == null) {
                    right = new IntegerSet(elem, this);
                } else {
                    right.insert(elem);
                }
            }
        }
    }

    public void insert(int i) {
		if (!specifications.Configuration.hashset) {
			insert__wrappee__Tree(i);
			return;
		}
        hset.add(new Integer(i));
    }

	    // specification is inherited
     private boolean  isMember__wrappee__Tree(int elem) {
        if (isEmpty) {
            return false;
        } else if (rootValue == elem) {
            return true;
        } else if (elem < rootValue) {
            if (left == null) {
                return false;
            } else {
                return left.isMember(elem);
            }
        } else {
            //@ assume rootValue < elem;
            if (right == null) {
                return false;
            } else {
                return right.isMember(elem);
            }
        }
    }

    public  boolean isMember(int i) {
		if (!specifications.Configuration.hashset)
			return isMember__wrappee__Tree(i);
        return hset.contains(new Integer(i));
    }

    // specification is inherited
     private void  remove__wrappee__Tree  (int elem) {
		removeHelper(elem);
    }

     public void remove(int i) {
		if (!Configuration.hashset) {
			remove__wrappee__Tree(i);
			return;
		}
        hset.remove(new Integer(i));
    }

	

    /** Is this tree empty?  When this is true, rootValue is not defined. */
    private boolean isEmpty;
	
    /** The integer at the root of the set. */
    private int rootValue;
	
    /** The left subtree, which may be null. */
    private IntegerSet left;

	
    /** The right subtree, which may be null. */
    private  IntegerSet right;

	
    /** The parent of this subtree, which may be null. */
    private  IntegerSet parent;

	    /** Initialize this set to be the empty set. */
    public IntegerSet  () {
		if (Configuration.tree) {
	        isEmpty = true;
	        parent = null;
	        constrHelper();
	    		}
	
		if (Configuration.hashset) {
	        hset = new HashSet();
	    		}
	}

	

    protected IntegerSet(int elem, IntegerSet par) {
		if (Configuration.tree) {
	        isEmpty = false;
	        rootValue = elem;
	        parent = par;
	        constrHelper();
	    }
	}

	

    /** Set the left and right to null. */
    private  void constrHelper() {
        right = null;
        left = null;
    }

	

    /** Remove the given integer from this set.  Note that the
     *  invariants don't all apply to this method.  That is important,
     *  because the tree surgery done by this method calls this method
     *  recursively in states in which the invariant does not hold.
     */
    private  void removeHelper(int elem) {
        if (!isEmpty) {
            if (rootValue == elem) {
                if (left == null && right == null) {
                    removeLeaf();
                } else {
                    removeRoot();
                }
            } else if (elem < rootValue) {
                if (left != null) {
                    left.removeHelper(elem);
                }
            } else {
                //@ assume rootValue < elem;
                if (right != null) {
                    right.removeHelper(elem);
                }
            }
        }
    }

    /** Replace the current node with the successor or predecessor. */
    private  void removeRoot() {
        IntegerSet next = getSuccessor(); 
        if (next == null) {                 
            next = getPredecessor();            
            //@ assume next != null;
            rootValue = next.rootValue; // left subtree
            left.removeHelper(rootValue);
        } else { // right subtree
            //@ assume next != null;
            rootValue = next.rootValue;
            right.removeHelper(rootValue);
        }
    }

	

    /** Remove an integer from a leaf node. */
    private  void removeLeaf() {
        if (parent != null) {
            if (isLeftChild()) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // empty this node
        isEmpty = true;
    }

	

    /** Is this node and left child of its parent?. */
    private  boolean isLeftChild() {
        return parent.left == this;
    }

	

    private  IntegerSet getSuccessor() {
        IntegerSet tree = right;
        if (right != null) {
            while (tree.left != null) {
                tree = tree.left;
            }
            //@ assert tree.left == null;
        }
        return tree;
    }

	

    private  IntegerSet getPredecessor() {
        IntegerSet tree = left;
        if (left != null) {
            while (tree.right != null) {
                tree = tree.right;
            }
            //@ assert tree.right == null;
        }
        return tree;
    }

	

    // specification is inherited
     private  String  toString__wrappee__Tree() {
        return "{" + this.printTree(true) + "}";
    }
    public String toString() {
		if (!Configuration.hashset)
			return toString__wrappee__Tree();
        return hset.toString();
    }
    protected String printTree(boolean isFirst) {
        String ans = "";

        if (!isEmpty) {
            if (left != null) {
                ans += left.printTree(isFirst);
                if (!left.isEmpty) {
                    isFirst = false;
                }
            }
            if (!isFirst) {
                ans += ", ";
            }
            ans += Integer.toString(rootValue);
            if (right != null) {
                ans += right.printTree(false);
            }
        }
		
        return ans;
    }

    private  HashSet hset;


}
