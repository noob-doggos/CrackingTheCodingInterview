import java.util.ArrayList;

/*
 * This code by Noob Doggos group 1 
 * Members: Victor, Eric, Clyde
 */

public class CTCI_3_Parentheses
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 8; i++)
        {
            ArrayList<String> perms = getAllPermutations(i);
            System.out.printf("%d perms -> %s\n", i, perms);
        }
    }
    
    /**
     * A method to return all permutations of N pairs of matched parentheses
     * 
     * @param N, the number of pairs of matched parentheses to generate permutations for
     * @return an ArrayList<String> of the permutations of N matched parentheses.
     */
    public static ArrayList<String> getAllPermutations(int N)
    {
        ArrayList<String> permutations = new ArrayList<>();
        permutationsHelper(N, 0, 0, "", permutations);
        return permutations;
    }
    
    /**
     * A helper method for the getAllPermutations method to recursively compute all permutations
     * of N pairs of matched parentheses via DFS.
     * 
     * TIME COMPLEXITY: O(2^N), worst-case
     * SPACE COMPLEXITY: O(N)
     * 
     * RECURSION TREE:
     * 
     * current branch
     * | - add left paren
     * | - add right paren (if unmatched left-parens exist)
     * 
     * @param N, the number of pairs of matched parentheses to generate permutations for
     * @param level, the level of parentheses depth the current recursion instance is on. +1 if leading char is '(', -1 if ')'
     * @param numLefts, the number of left parentheses in the current string
     * @param curPermutation, the current permutation string being built
     * @param permutations, the ArrayList<String> to add valid permutations of N pairs to
     */
    public static void permutationsHelper(int N, int level, int numLefts, String curPermutation, ArrayList<String> permutations)
    {     
        // it is impossible to have a valid permutation of N matched parens with length > 2N.
        // terminate this recursion branch if so.
        if (curPermutation.length() > 2 * N)
        {
            return;
        }
        
        // if our parentheses depth level is 0 (so all parens are matched) and we have N left parens, this is a valid finished
        // permutation. add it to the permutations list and terminate this branch.
        if (level == 0 && numLefts == N)
        {
            permutations.add(curPermutation);
            return;
        }
        
        // spawn recursion branch w/ left-parens added.
        permutationsHelper(N, level + 1, numLefts + 1, curPermutation + "(", permutations);
        
        // if we have at least one unmatched left-parenthesis in this recursion branch,
        // spawn recursion branch with a matching right-parenthesis.
        if (level > 0)
        {
            permutationsHelper(N, level - 1, numLefts, curPermutation + ")", permutations);
        }
        
    }
}
