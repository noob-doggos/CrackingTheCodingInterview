
public class CTCI_2_WordSearch
{
<<<<<<< HEAD
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
=======
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
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
<<<<<<< HEAD

    /**
     * A helper method to make a deep copy of a 2D boolean array.
     * 
     * @param input,
     *            the 2D boolean array to makea copy of.
     * @return a deep copy of the given 2D boolean array.
     */
=======
    
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
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

<<<<<<< HEAD
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
=======
    public boolean explore(char[][] board, boolean[][] explored, int row, int col, int idx, String target)
    {
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        if (idx >= target.length())
        {
            return true;
        }
<<<<<<< HEAD

        // return false if we are out of array bounds.
=======
        
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
        {
            return false;
        }

<<<<<<< HEAD
        // if we've already explored this array element, return false.
        // otherwise, mark this element as explored and explore adjacent
        // elements.
=======
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        if (explored[row][col])
        {
            return false;
        }

        explored[row][col] = true;
<<<<<<< HEAD

        // if the current element in the char array does not match the next
        // character of the target string we want to build, return false.
=======
        
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        if (board[row][col] != target.charAt(idx))
        {
            return false;
        }
<<<<<<< HEAD

=======
        
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        boolean[][] southExp = copyArr2D(explored);
        boolean[][] northExp = copyArr2D(explored);
        boolean[][] westExp = copyArr2D(explored);
        boolean[][] eastExp = copyArr2D(explored);

<<<<<<< HEAD
        // explore south, east, north, and west elements recursively.
=======
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        if (explore(board, southExp, row + 1, col, idx + 1, target))
        {
            return true;
        }
<<<<<<< HEAD

=======
        
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
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

<<<<<<< HEAD
        // if none of the adjacent paths construct the target word, return
        // false.
=======
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
        return false;
    }

    public static void main(String[] args)
    {
<<<<<<< HEAD
        // char[][] board = new char[][] {{'a'}};
        char[][] board = new char[][] { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
        System.out.println(new CTCI_2_WordSearch().exist(board, "abcced"));
=======
        char[][] board = new char[][] {{'a'}};
        //char[][] board = new char[][] { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
        System.out.println(new CTCI_2_WordSearch().exist(board, "a"));
>>>>>>> bcf45a097637d48385889974f719cfbb2eb88054
    }
}
