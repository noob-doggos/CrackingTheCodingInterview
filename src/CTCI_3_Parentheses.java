import java.util.ArrayList;

public class CTCI_3_Parentheses
{
    public static void main(String[] args)
    {
        for (int i = 0; i <= 8; i++)
        {
            ArrayList<String> perms = getAllPermutations(i);
            System.out.printf("%d perms -> %s\n", i, perms);
        }
    }
    
    public static ArrayList<String> getAllPermutations(int N)
    {
        ArrayList<String> permutations = new ArrayList<>();
        permutationsHelper(N, 0, 0, "", permutations);
        return permutations;
    }
    
    public static void permutationsHelper(int N, int level, int numLefts, String curPermutation, ArrayList<String> permutations)
    {     
        if (curPermutation.length() > 2 * N)
        {
            return;
        }
        
        if (level == 0 && numLefts == N)
        {
            permutations.add(curPermutation);
            return;
        }
        
        permutationsHelper(N, level + 1, numLefts + 1, curPermutation + "(", permutations);
        if (level > 0)
        {
            permutationsHelper(N, level - 1, numLefts, curPermutation + ")", permutations);
        }
        
    }
}
