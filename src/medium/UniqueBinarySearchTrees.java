package medium;

/**
 * Created by eager-mbp on 2017/8/23.
 */
public class UniqueBinarySearchTrees {

//    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//    For example,
//    Given n = 3, there are a total of 5 unique BST's.
//
//            1         3     3      2      1
//            \       /     /      / \      \
//            3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3

    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

    /**
     * The tricky part is that we could consider the number of unique BST out of
     * sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4).
     * Therefore, F(3,7) = G(2) * G(4).

     i.e.

     F(i, n) = G(i-1) * G(n-i)	1 <= i <= n

     因为G(n) = F(1, n) + F(2, n) + ... + F(n, n).

     所以G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
     */
}
