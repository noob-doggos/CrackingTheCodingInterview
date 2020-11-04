
public class CTCI_2_WordSearch
{
    /**
     * A method to check whether a given word can be constructed from
     * sequentially adjacent cells in the 2-dimensional char array, board.
     * 
     * @param board,
     *            the 2D char array to search for the word in.
     * @param word,
     *            the word to search for in the 2D char array.
     * @return whether word can be constructed from sequentially adjacent cells
     *         in the given 2D char array.
     */
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

    /**
     * A helper method to make a deep copy of a 2D boolean array.
     * 
     * @param input,
     *            the 2D boolean array to makea copy of.
     * @return a deep copy of the given 2D boolean array.
     */
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

    /**
     * A helper method for the exist method to return whether a given word can
     * be constructed from sequentially adjacent cells in the 2-dimensional char
     * array using recursive DFS, starting from a given zero-based array
     * location in rows and columns.
     * 
     * recursion tree:
     * 
     * current element 
     * |- explore south element 
     * |- explore east element 
     * |- explore north element 
     * |- explore west element
     * 
     * levels of recursion: x + y, where x is the number of rows in board and y
     * is the number of columns in board
     * 
     * time complexity: O(x*y)
     * 
     * space complexity: O(x+y)
     * 
     * @param board,
     *            a 2D char array to search for the word in.
     * @param explored,
     *            a 2D boolean array to store whether the current location has
     *            been visited to prevent infinite recursion.
     * @param row,
     *            the row in the 2D char array to start the search from
     * @param col,
     *            the column in the 2D char array to start the search from
     * @param idx,
     *            the current index of the target string to match the current 2D
     *            char array element to.
     * @param target,
     *            the target string to search the 2D char array for.
     * @return whether the given string, target, can be found in 2D char array
     *         board, starting at the given row and column in the array.
     */
    public boolean explore(char[][] board, boolean[][] explored, int row, int col, int idx, String target)
    {
        // if the index of the word we are constructing from the array elements
        // is the same as the target string length, return true.
        if (idx >= target.length())
        {
            return true;
        }

        // return false if we are out of array bounds.
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
        {
            return false;
        }

        // if we've already explored this array element, return false.
        // otherwise, mark this element as explored and explore adjacent
        // elements.
        if (explored[row][col])
        {
            return false;
        }

        explored[row][col] = true;

        // if the current element in the char array does not match the next
        // character of the target string we want to build, return false.
        if (board[row][col] != target.charAt(idx))
        {
            return false;
        }

        boolean[][] southExp = copyArr2D(explored);
        boolean[][] northExp = copyArr2D(explored);
        boolean[][] westExp = copyArr2D(explored);
        boolean[][] eastExp = copyArr2D(explored);

        // explore south, east, north, and west elements recursively.
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

        // if none of the adjacent paths construct the target word, return
        // false.
        return false;
    }

    public static void main(String[] args)
    {
        // char[][] board = new char[][] {{'a'}};
        char[][] board = new char[][] { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
        System.out.println(new CTCI_2_WordSearch().exist(board, "abcced"));
    }
}
