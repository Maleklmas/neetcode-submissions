class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length())
                   .append("#")
                   .append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find the '#'
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            // Get the length of the string
            int length = Integer.parseInt(s.substring(i, j));

            // Start of the actual string
            int start = j + 1;

            // Extract the string
            String word = s.substring(start, start + length);

            // Add it to the result
            result.add(word);

            // Move to the next encoded string
            i = start + length;
        }

        return result;
    }
}