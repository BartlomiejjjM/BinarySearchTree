package tree.implementations;

import tree.BinarySearchTree;
import tree.TreeTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InOrder implements TreeTraversal {
    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        List <T> result = new ArrayList<>();

        if (tree.getLeft().isPresent()){
            result.addAll(traverse(tree.getLeft().get()));
        }

        result.add(tree.getValue());

        if (tree.getRight().isPresent()){
            result.addAll(traverse(tree.getRight().get()));
        }
        return result;
    }


}
