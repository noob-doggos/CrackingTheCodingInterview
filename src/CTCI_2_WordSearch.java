
public class CTCI_2_WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (explore(board, new boolean[board.length][board[0].length], i, j, 0, word))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean[][] copyArr2D(boolean[][] input)
    {
        boolean[][] toReturn = new boolean[input.length][input[0].length];
        for (int i = 0; i < input.length; i++)
        {
            for (int j = 0; j < input[0].length; j++)
            {
                toReturn[i][j] = input[i][j];
            }
        }
        return toReturn;
    }

    public boolean explore(char[][] board, boolean[][] explored, int row, int col, int idx, String target)
    {
        if (idx >= target.length())
        {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
        {
            return false;
        }

        if (explored[row][col])
        {
            return false;
        }

        explored[row][col] = true;
        
        if (board[row][col] != target.charAt(idx))
        {
            return false;
        }
        
        boolean[][] southExp = copyArr2D(explored);
        boolean[][] northExp = copyArr2D(explored);
        boolean[][] westExp = copyArr2D(explored);
        boolean[][] eastExp = copyArr2D(explored);

        if (explore(board, southExp, row + 1, col, idx + 1, target))
        {
            return true;
        }
        
        if (explore(board, eastExp, row, col + 1, idx + 1, target))
        {
            return true;
        }

        if (explore(board, northExp, row - 1, col, idx + 1, target))
        {
            return true;
        }

        if (explore(board, westExp, row, col - 1, idx + 1, target))
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        char[][] board = new char[][] {{'a'}};
        //char[][] board = new char[][] { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
        System.out.println(new CTCI_2_WordSearch().exist(board, "a"));
    }
}
