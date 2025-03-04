/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Beckett Porter
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
        // Create variables for the string lengths and create the string table with one more extra row and column.
        int string1Length = doc1.length();
        int string2Length = doc2.length();
        int[][] stringTable = new int[string1Length + 1][string2Length + 1];

        // Tabulation approach that iteratively builds up to find the longest shared substring.
        for (int i = 1; i < stringTable.length; i++)
        {
            for (int j = 1; j < stringTable[0].length; j++)
            {
                // Get the current chars we're checking.
                char currentChar1 = doc1.charAt(i - 1);
                char currentChar2 = doc2.charAt(j - 1);

                // If the chars are equal, set our current position in the stringTable's value to 1 +
                // our last next highest found substring (At position i - 1, j - 1).
                if (currentChar1 == currentChar2)
                {
                    stringTable[i][j] = 1 + stringTable[i - 1][j - 1];
                }
                // Otherwise if the chars are not equal, set our current position in the stringTable's value to our
                // next highest found one before this spot. (Either above or to the left of our current position)
                else
                {
                    stringTable[i][j] = Math.max(stringTable[i - 1][j], stringTable[i][j - 1]);
                }
            }
        }

        // Return the value at the very end of the 2D array because this is where our
        // final longest substring will end up.
        return stringTable[string1Length][string2Length];
    }
}
