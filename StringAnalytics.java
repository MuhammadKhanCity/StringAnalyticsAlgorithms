import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StringAnalytics {

    /**
     * Returns the shortest string in the list. If there are several
     * strings of the same shortest length, the one that occurs earliest
     * is returned.
     * @param a list of strings, in ascending order
     * @return the shortest string in the list.
     */
    public String shortestWord(StringList a) {

        String SmallestWord = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            if (SmallestWord.length() > a.get(i).length()) {
                SmallestWord = a.get(i);
            }
        }
        return SmallestWord;
    }


    /**
     * Returns the number of unique elements in the list
     * @param a list of strings, in ascending order
     * @return number of unique elements in the list.
     */
    public int countUnique(StringList a) {

            ArrayList<String> UniqueList = new ArrayList<>();
            ArrayList<String> NotUniqueList = new ArrayList<>();

        // Loop invariant: uniqueList contains only unique elements from a[0] to a[i-1]
        // and notUniqueList contains duplicate elements encountered so far
            for (int i = 0; i < a.size(); i++) {
                String current = a.get(i);
                if (!UniqueList.contains(current)) {
                    // checks again that to encounter the problem if an element has occured three times it does not go inside our Unique list
                    if (!NotUniqueList.contains(current)){
                        UniqueList.add(current);
                    }
                } else {
                   NotUniqueList.add(current);
                   UniqueList.remove(current);
                }
            }
            return UniqueList.size();
        }



	

    /**
     * Returns the number of palindrome strings in the list.
     * @param a collection of strings, in ascending order
     * @return number of palindrome strings in the list. 
     */
    public int countPalindrome(StringList a) {
        int i = 0;
        ArrayList PalindromeList = new ArrayList<>();
        // using a while loop and reversing al
        while (i < a.size()){
            String current = a.get(i);
            String reversed = new StringBuilder(current).reverse().toString();
            if (current.equals(reversed)){
                PalindromeList.add(current);
            }
            i++;
        }
        return PalindromeList.size();
    }

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @return element that occurs the least frequent in the list. If two or more are equally least frequent, return the one that comes earliest
     */
    public String leastFrequent (StringList a) {
        // need to make some changes and make it fully functional
        LinkedHashMap<String, Integer> frequencyMap = new LinkedHashMap<>();

        // Iterate over the words in StringList a and count their frequencies
        // loop invariant:
        for (int i = 0; i < a.size(); i++) {
            String currentWord = a.get(i);
            frequencyMap.put(currentWord, frequencyMap.getOrDefault(currentWord, 0) + 1);
        }

        // Initialize variables to keep track of the least frequent word and its frequency
        String leastFrequentWord = null;
        int minFrequency = Integer.MAX_VALUE;

        // Iterate over the entries in the frequencyMap to find the least frequent word
        for (String word : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(word);
            if (frequency < minFrequency) {
                leastFrequentWord = word;
                minFrequency = frequency;
            }
        }

        // Return the least frequent word
        return leastFrequentWord;

    }


    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param str string to search for
     * @return number of strings less than k in order
     */
    public int countLess(StringList a, String str) {
        int low = 0;
        int high =  a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = a.get(mid).compareTo(str);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }

    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k integer - top k
     * @return k most frequent elements in the list
     */
    public String [] topKFrequent (StringList a, int k) {
        // replace the following line with your implementation
        // need to make some changes and make it fully functional
        LinkedHashMap<String, Integer> TopFrequentMap = new LinkedHashMap<>();
        ArrayList<String> TopFrequentList = new ArrayList<>();
        // Iterate over the words in StringList a and count their frequencies
        for (int i = 0; i < a.size(); i++) {
            String currentWord = a.get(i);
            TopFrequentMap.put(currentWord, TopFrequentMap.getOrDefault(currentWord, 0) + 1);

        }

       ArrayList<String> AddedElements = new ArrayList<>();
        for (int i = 0; i < TopFrequentMap.size()-1; i++) {
            String MostFrequentWord = a.get(i);
                for (int j = 1; j < TopFrequentMap.size(); j++) {
                    if (TopFrequentMap.get(a.get(i)) < TopFrequentMap.get(a.get(j)) && !AddedElements.contains(a.get(i))){
                        MostFrequentWord = a.get(j);
                       AddedElements.add(a.get(j));
                    }
                }
                if (TopFrequentList.size() < k && !TopFrequentList.contains(MostFrequentWord)) {
                    TopFrequentList.add(MostFrequentWord);
                }else if (TopFrequentList.size() >= k){
                    break;
                }

            }

        String[] TopFrequentArray = TopFrequentList.toArray(new String[0]);

        return TopFrequentArray;
    }


    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param str string to search for
     * @return number of strings greater than or equal to k in order
     */
    public int countGreaterOrEqual(StringList a, String str) {
        // replace the following line with your implementation
        int low = 0;
        int high =  a.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = a.get(mid).compareTo(str);

            if (comparison == 0) {
                return a.size()- mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Search for a string in an ordered collection
     * @param a - collection of strings, in ascending order
     * @param prefix - prefix string
     * @return number of strings having prefix in collection of strings
     */
    public int countPrefix(StringList a, String prefix) {
        ArrayList<String> ContainsPrefix = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            String currentElement = a.get(i);

            if (currentElement.startsWith(prefix)){
                ContainsPrefix.add(currentElement);
            }
        }
        return ContainsPrefix.size();
    }

    /**
     * Count number of unmatches in an ordered collection
     * @param a collection of strings, in ascending order
     * @param prefix first string to search for
     * @param substring second string to search for
     * @return number of elements that neither start with the specified prefix nor contain the given substring
     */
    public int countUnMatches(StringList a, String prefix, String substring) {
        int countUnmatchStrings = 0;
        for (int i = 0; i < a.size(); i++) {
            String currentElement = a.get(i);

            // Check if the current element does not start with the prefix
            // and does not contain the substring
            if (!currentElement.startsWith(prefix) && !currentElement.contains(substring)) {
                countUnmatchStrings++;
            }
        }
        return countUnmatchStrings;
    }

}
