package tree;

import tree.implementations.InOrder;

import java.util.Iterator;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class BinarySearchTree <T extends Comparable<T>> implements TreeSearch<T> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    private T value;
    private TreeTraversal traversal;

    public BinarySearchTree(T value) {
        this(value, new InOrder());
    }

    public BinarySearchTree(T value, TreeTraversal traversal) {
        checkNotNull(value, "Value shouldn't be null");
        checkNotNull(traversal, "Traversal cannot be null");
        this.value = value;
        this.traversal = traversal;
    }

    public void insert (T value){

        if (this.value==value){
            throw new IllegalArgumentException("This value already exists.");
        }
        if (value.compareTo(this.value) < 0){
            if (left == null){
                left = new BinarySearchTree<>(value, traversal);
            }else {
                left.insert(value);
            }
        }else {
            if (right == null){
                right = new BinarySearchTree<>(value, traversal);
            } else {
              right.insert(value);
            }
        }
    }

    public Optional<T> find (T value){
        checkNotNull(value, "Value shouldn't be null.");
        int comparsion = value.compareTo(this.value);

        if (comparsion == 0){
            return Optional.of(this.value);
        }
        if (comparsion < 0 && left != null){
            return left.find(value);
        }
        if (comparsion > 0 && right != null){
            return right.find(value);
        }
      return Optional.empty();
    }

    public Optional<BinarySearchTree<T>> getLeft() {
        return Optional.ofNullable(left);
    }

    public Optional<BinarySearchTree<T>> getRight() {
        return Optional.ofNullable(right);
    }

    public T getValue() {
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return traversal.traverse(this).iterator();
    }
}
