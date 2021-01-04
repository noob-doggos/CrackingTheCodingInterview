import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * WordCount.java
 * Group members: Victor, Eric, Clyde
 *
 * Reflection:
 * - what we learned from doing this project: we learned how to use the Map interface and the TreeMap implementation.
 * - something that didn't work out individually and how I solved it: n/a
 * - something that didn't work out as a group and how we solved it: some of us needed a refresher on Scanner so we Googled the JavaDoc for it
 * 
 */
public class WordCount
{
    // minimum number of occurrences needed to be printed - 2000;
    public static final int OCCURRENCES = 2000;

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("This program displays the most frequently occurring words from the book Moby-Dick:");
        Scanner in = new Scanner(new File("mobydick.txt"));
        Map<String, Integer> countMap = getCountMap(in);
        countMap.forEach((k, v) -> printEntry(k, v));
    }
    
    public static void printEntry(String key, Integer val)
    {
        if (val >= OCCURRENCES) System.out.printf("%s occurs %d times.\n", key, val);
    }

    // Reads book text and returns a map from words to counts.
    public static Map<String, Integer> getCountMap(Scanner in)
    {
        Map<String, Integer> wordCountMap = new TreeMap<>();
        
        while (in.hasNext())
        {
            String cur = in.next().toLowerCase();
            wordCountMap.put(cur, wordCountMap.containsKey(cur) ? wordCountMap.get(cur) + 1 : 1);
        }

        return wordCountMap;
    }
}
