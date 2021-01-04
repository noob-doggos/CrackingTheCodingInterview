import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount
{
    // minimum number of occurrences needed to be printed - 2000;
    public static final int OCCURRENCES = 2000;

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("This program displays the most frequently occurring words from the book Moby Dick.");
        // read the book into a map
        // to do
        Scanner in = new Scanner(new File("mobydick.txt"), "utf-8"); // specify file encoding because otherwise Java will assume CP-1252, when the file is UTF8.
        Map<String, Integer> countMap = getCountMap(in);
        countMap.forEach((k, v) -> printEntry(k, v));
    }
    
    public static void printEntry(String key, Integer val)
    {
        if (val > OCCURRENCES) System.out.printf("%s occurs %d times.\n", key, val);
    }

    // Reads book text and returns a map from words to counts.
    public static Map<String, Integer> getCountMap(Scanner in)
    {
        // to do
        Map<String, Integer> wordCountMap = new TreeMap<>();
        while (in.hasNext())
        {
            String cur = in.next().toLowerCase();
            wordCountMap.put(cur, wordCountMap.containsKey(cur) ? wordCountMap.get(cur) + 1 : 1);
        }

        return wordCountMap;
    }
}
