import java.io.IOException;
import java.util.Arrays;

/**
 * Test program for the Search class.
 */
public class StringTest {
    private static final String files[] = {
            "tiny.txt", "small.txt", "medium.txt", "large.txt"
    };

    /**
     * Test program for the StringAnalytics class.
     * Put whatever tests you like in the body of the method.
     * @param args the command line arguments
     * @throws java.io.IOException of error reading the input
     */
    public static void main(String[] args) throws IOException {

        final StringAnalytics sa = new StringAnalytics();

        for (String file : files) {
            final StringList strings = new StringList("data/" + file);
            System.out.println("Testing on " + file + ":");
            System.out.println("Shortest Word: " + sa.shortestWord(strings));
            System.out.println("Palindrome: "+ sa.countPalindrome(strings));
            System.out.println("Count Unique: " + sa.countUnique(strings));
            System.out.println("Count Palindrome: " + sa.countPalindrome(strings));
            System.out.println("Least Frequent: " + sa.leastFrequent(strings));
            System.out.println("Count Less Than 'first': " + sa.countLess(strings, "what"));
            System.out.println("Top 3 Frequent Words: " + Arrays.toString(sa.topKFrequent(strings, 3)));
            System.out.println("Count Greater Or Equal To 'What': " + sa.countGreaterOrEqual(strings, "also"));
            System.out.println("Count Prefix 'the': " + sa.countPrefix(strings, "the"));
            System.out.println("Count UnMatches 'apa' and 'lo': " + sa.countUnMatches(strings, "apa", "lo"));
            System.out.println(); // Add an empty line for better readability
        }
    }
}
