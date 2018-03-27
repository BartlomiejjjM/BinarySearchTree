package tree;

import tree.implementations.InOrder;
import tree.implementations.PostOrder;
import tree.implementations.PreOrder;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree <Integer> tree = new BinarySearchTree<>(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(5);
        tree.insert(7);


        PreOrder preOrder = new PreOrder();
        System.out.println(preOrder.traverse(tree));

        InOrder inOrder = new InOrder();
        System.out.println(inOrder.traverse(tree));

        PostOrder postOrder = new PostOrder();
        System.out.println(postOrder.traverse(tree));
    }

}
