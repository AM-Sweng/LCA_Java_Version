

public class main
{

    public static void main(String[] args)
    {
        BST tree = new BST();

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
         *             G
         *           /   \
         *          /     \
         *         E       N
         *        / \     / \
         *       A   F   K   P
         *              / \   \
         *             J   L   Z
         *            /
         *           H
         */

        System.out.println("The LCA of A and F is " + tree.LCAof('A', 'F')); // Should be E
        System.out.println("The LCA of H and L is " + tree.LCAof('H', 'L')); // Should be K
        System.out.println("The LCA of J and Z is " + tree.LCAof('J', 'Z')); // Should be N
        System.out.println("The LCA of E and P is " + tree.LCAof('E', 'P')); // Should be G
    }

}
