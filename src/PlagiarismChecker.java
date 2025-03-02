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



        // Given every char, go through rest of strings and find possible other combos





        return LCS(doc1, 0, doc2, 0);
    }

    private static int LCS(String word1, int index1, String word2, int index2)
    {
        if (index1 == word1.length() - 1)
        {
            return 0;
        }
        if (index2 == word2.length() - 1)
        {
            return 0;
        }


        if (word1.charAt(index1) == word2.charAt(index2))
        {
            return 1 + Math.max(LCS(word1, index1 + 1, word2, index2), LCS(word1, index1, word2, index2 + 1));
        }
        return Math.max(LCS(word1, index1 + 1, word2, index2), LCS(word1, index1, word2, index2 + 1));

    }
}
