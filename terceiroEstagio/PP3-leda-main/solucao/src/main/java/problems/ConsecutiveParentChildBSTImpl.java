package problems;

import java.util.Set;
import java.util.TreeSet;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class ConsecutiveParentChildBSTImpl extends BSTInteger implements ConsecutiveParentChildBST {

	public Set<Pair> findConsecutives() {
		TreeSet<Pair> set = new TreeSet<Pair>();
		BSTNode root = this.getRoot();
		this.search(set, root);

		return set;
	}

	private void search(Set<Pair> set, BSTNode root) {

		if (!root.isEmpty()) {
			if (!root.getLeft().isEmpty() && ((Integer) root.getData() - (Integer) root.getLeft().getData()) == 1) {
				set.add(new Pair((Integer) root.getData(), (Integer) root.getLeft().getData()));
			}

			if (!root.getRight().isEmpty() && ((Integer) root.getData() - (Integer) root.getRight().getData()) == -1) {
				set.add(new Pair((Integer) root.getData(), (Integer) root.getRight().getData()));
			}
			
			search(set, (BSTNode) root.getLeft());
			search(set, (BSTNode) root.getRight());
		}
	}


}
