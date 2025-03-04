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
    public static int longestSharedSubstring(String doc1, String doc2)
    {

        // TODO Complete this function to return the length of the longest shared substring.

        int string1Length = doc1.length();
        int string2Length = doc2.length();
        int[][] stringTable = new int[string1Length + 1][string2Length + 1];

        for (int i = 1; i <= string1Length; i++)
        {
            for (int j = 1; j <= string2Length; j++)
            {
                char currentChar1 = doc1.charAt(i - 1);
                char currentChar2 = doc2.charAt(j - 1);

                if (currentChar1 == currentChar2)
                {
                    stringTable[i][j] = 1 + stringTable[i - 1][j - 1];
                }
                else
                {
                    stringTable[i][j] = Math.max(stringTable[i - 1][j], stringTable[i][j - 1]);
                }
            }
        }

        return stringTable[string1Length][string2Length];
    }
}
