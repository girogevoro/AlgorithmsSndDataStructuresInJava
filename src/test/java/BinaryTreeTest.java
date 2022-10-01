import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BinaryTreeTest {

    @Test
    void isBalanced() {
        Tree<Integer> tree = new BinaryTree<>();

        Assertions.assertTrue(tree.isBalanced());
        tree.add(15);
        Assertions.assertTrue(tree.isBalanced());
        tree.add(7);
        Assertions.assertTrue(tree.isBalanced());
        tree.add(18);
        Assertions.assertTrue(tree.isBalanced());
        tree.add(8);
        Assertions.assertTrue(tree.isBalanced());
        tree.add(9);
        Assertions.assertFalse(tree.isBalanced());
    }
}