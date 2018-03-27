package tree.implementations;

import tree.BinarySearchTree;
import tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class PostOrder implements TreeTraversal {
    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        List<T> result = new ArrayList<>();

        tree.getLeft().ifPresent(t -> result.addAll(traverse(t)));
        tree.getRight().ifPresent(t -> result.addAll(traverse(t)));
        result.add(tree.getValue());

        return result;
    }
}
