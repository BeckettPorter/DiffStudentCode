import java.util.HashSet;

/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */
public class PlagiarismChecker
{
    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // TODO Complete this function to return the length of the longest shared substring.

        int[][] lengthsAr = new int[doc1.length()][doc2.length()];

        // Given every char, go through rest of strings and find possible other combos


        for (int x = 0; x < doc1.length(); x++)
        {
            for (int y = 0; y < doc2.length(); y++)
            {
                int char1 = doc1.charAt(x);
                int char2 = doc2.charAt(y);

                if (char1 == char2)
                {
                    if (isArLocInBounds(x - 1, y - 1, lengthsAr))
                    {
                        lengthsAr[x][y] = lengthsAr[x - 1][y - 1] + 1;
                    }
                }
                else
                {
                    if (isArLocInBounds(x - 1, y - 1, lengthsAr))
                    {
                        lengthsAr[x][y] = lengthsAr[x - 1][y - 1];
                    }
                }
            }
        }

        return lengthsAr[lengthsAr.length - 1][lengthsAr[0].length - 1];
    }

    private static boolean isArLocInBounds(int x, int y, int[][] ar)
    {
        if (x < 0 || x >= ar.length)
        {
            return false;
        }
        if (y < 0 || y >= ar[0].length)
        {
            return false;
        }
        return true;
    }
}
