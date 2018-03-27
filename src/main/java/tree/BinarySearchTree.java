package tree;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class BinarySearchTree <T extends Comparable<T>> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    private T value;

    public BinarySearchTree(T value) {
        checkNotNull(value, "Value shouldn't be null.");
        this.value = value;
    }
    public void insert (T value){
        checkNotNull(value, "Value shouldn't be null");
        if (this.value==value){
            throw new IllegalArgumentException("This value already exists.");
        }
        else if (value.compareTo(this.value) < 0){
            if (left == null){
                left = new BinarySearchTree<>(value);
            }
        }
        else if (value.compareTo(this.value) > 0){
            if (right == null){
                right = new BinarySearchTree<>(value);
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
}
