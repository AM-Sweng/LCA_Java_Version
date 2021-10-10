public class BST
{
    private Node root;

    private class Node
    {
        private Character key;
        //private int val;
        private Node left, right;

        public Node(char key) {
            this.key = key;
        }
    }

    public BST()
    {
        root = null;
    }

    public void put(char key)
    {
        root = put(root, key);
    }

    private Node put(Node x, char key)
    {
        if (x == null) return new Node(key);
        if (key < x.key) x.left = put(x.left, key);
        else if (key > x.key) x.right = put(x.right, key);
        return x;
    }

    public boolean contains(char key)
    {
        return contains(root, key);
    }

    private boolean contains(Node x, char key)
    {
        if (x == null) return false;
        if (x.key == key) return true;
        else if (key < x.key) return contains(x.left, key);
        else return contains(x.right, key);
    }

    // The method assumes both keys are present in the tree
    public Character LCAof(char key1, char key2)
    {
        if (contains(key1) && contains(key2))
        {
            Node currentNode = this.root;
            while (currentNode != null)
            {
                if (currentNode.key > key1 && currentNode.key > key2) currentNode = currentNode.left;
                else if (currentNode.key < key1 && currentNode.key < key2) currentNode = currentNode.right;
                else return currentNode.key;
            }
        }
        return null;
    }

    /**
     * This method was added to allow for testing put
     *
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear after the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
    public String printKeysInOrder()
    {
        if (root == null) return "()";
        return "(" + printKeysInOrder(root) + ")";
    }

    private String printKeysInOrder(Node node)
    {
        if(node == null) return "";

        return "(" + printKeysInOrder(node.left) + ")" + node.key + "(" + printKeysInOrder(node.right) + ")";
    }
}
