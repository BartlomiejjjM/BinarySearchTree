package tree;

import tree.BinarySearchTree;

import java.util.List;

public interface TreeTraversal {
    <T extends Comparable<T>>List<T> traverse(BinarySearchTree<T> tree);
}
