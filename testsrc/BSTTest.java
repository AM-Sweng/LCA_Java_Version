import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void put()
    {
        BST testObject = new BST();

        // Test putting a key onto an empty tree
        testObject.put('R');
        assertEquals("(()R())", testObject.printKeysInOrder(), "Test put('R') on an empty tree");

        // Test putting a key onto a tree where it should go into the left subtree
        testObject.put('E');
        assertEquals("((()E())R())", testObject.printKeysInOrder(), "Test put('E') on a tree with R as root, should go left");

        // Test putting a key onto a tree where it should go into the right subtree
        testObject.put('T');
        assertEquals("((()E())R(()T()))", testObject.printKeysInOrder(), "Test put('T') on a tree with R as root, should go right");

        // Test tree with multiple keys in both subtrees
        /*
         * The tree used is:
         *
         *                 _____R_____
         *                |           |
         *            ____E____       T____
         *           |         |           |
         *           A__     __H__         X__
         *              |   |     |           |
         *              C   F     P         __Z
         *                                 |
         *                                 Y
         *
         */
        testObject.put('A');
        testObject.put('H');
        testObject.put('F');
        testObject.put('X');
        testObject.put('Z');
        testObject.put('Y');
        testObject.put('P');
        testObject.put('C');
        assertEquals("(((()A(()C()))E((()F())H(()P())))R(()T(()X((()Y())Z()))))", testObject.printKeysInOrder(), "Test multiple puts, in the order R, E, T, A, H, F, X, Z, Y, P, C");

        // Test putting a key on a tree that already has that key (Should not change the structure of the tree)
        testObject.put('Z');
        assertEquals("(((()A(()C()))E((()F())H(()P())))R(()T(()X((()Y())Z()))))", testObject.printKeysInOrder(), "Test put('Z') on a tree that contains Z");
    }

    @Test
    void LCAof()
    {
        BST tree = new BST();

        // Test LCA on an empty tree
        assertEquals(null, tree.LCAof('F', 'J'), "Test LCAof('F', 'J') on an empty tree");

        // Test LCA on a tree with a single node, where neither key is in the tree
        tree.put('D');
        assertEquals(null, tree.LCAof('H', 'A'), "Test LCAof('H', 'A') on a tree with just the key D as root");

        // Test LCA on a tree with a single node where one of the given keys is in the tree
        assertEquals(null, tree.LCAof('D', 'F'), "Test LCAof('H', 'A') on a tree with just the key D as root");

        // Tests for LCA on a tree with multiple nodes
        tree = new BST();
        tree.put('G');
        tree.put('N');
        tree.put('K');
        tree.put('E');
        tree.put('A');
        tree.put('P');
        tree.put('J');
        tree.put('F');
        tree.put('Z');
        tree.put('H');
        tree.put('L');

        /*
         * The tree used is:
         *
         *            ________G________
         *           |                 |
         *       ____E____         ____N____
         *      |         |       |         |
         *      A         F     __K__       P__
         *                     |     |         |
         *                   __J     L         Z
         *                  |
         *                  H
         */

        // TEMP THIS IS NOT GOING TO BE HERE check correct tree was made
        assertEquals("(((()A())E(()F()))G((((()H())J())K(()L()))N(()P(()Z()))))", tree.printKeysInOrder());

        // Test LCA where neither key is in the tree
        assertEquals(null, tree.LCAof('D', 'M'), "Test LCAof('D', 'M') on a tree that contains neither");

        // Test LCA where one of the keys is in the tree
        assertEquals(null, tree.LCAof('J', 'X'), "Test LCAof('J', 'X') on a tree that contains J but not X");

        // Test LCA with keys that are in the tree at varying levels
        assertEquals('E', tree.LCAof('A', 'F'), "Test LCAof('A', 'F'), where they share the same parent node");
        assertEquals('K', tree.LCAof('H', 'L'), "Test LCAof('H', 'L'), where the parent of one is the grandparent of the other");
        assertEquals('N', tree.LCAof('J', 'Z'), "Test LCAof('J', 'Z'), where they share the same grandparent");
        assertEquals('G', tree.LCAof('H', 'A'), "Test LCAof('H', 'A'), where their LCA should be the root");

        // Test LCA where one of the given keys is the ancestor of the other
        assertEquals('K', tree.LCAof('K', 'H'), "Test LCAof('K', 'H', where K is the ancestor of H)");

        // Test LCA where the two keys given are the same
        assertEquals('J', tree.LCAof('J', 'J'), "Test LCAof('J', 'J')");
    }
}