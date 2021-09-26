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

    // The method assumes both keys are present in the tree
    public Character LCAof(char key1, char key2)
    {
        Node currentNode = this.root;
        while(currentNode != null)
        {
            if(currentNode.key > key1 && currentNode.key > key2) currentNode = currentNode.left;
            else if(currentNode.key < key1 && currentNode.key < key2) currentNode = currentNode.right;
            else return currentNode.key;
        }
        return null;
    }

}
