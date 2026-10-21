class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Index 0 represents 'a', index 1 represents 'b', ..., index 25 represents 'z'.
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++; // Example: a - a = 0, so count[0] increases by 1.
            }

            /* Java's HashMap needs a key.
            // because arrays don't behave like normal value-based keys in Java.
            // So we turn the frequency array into a String.    Ex: #1#0#1#0#0#0#0...#1
            //
            // KEY                  GROUP
            // #1#0#1...       →    ["act", "cat"]
            // #0#0#0...       →    ["hat"]
            // #0#1#0...       →    ["pots", "tops", "stop"]
            */

            StringBuilder key = new StringBuilder();

            for (int n : count) {
                key.append('#').append(n);
            }

            // Create an empty group if this frequency pattern hasn't appeared before.
            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }

            // Add the original string to its corresponding anagram group.
            map.get(key.toString()).add(s);
        }

        // Return all anagram groups;
        return new ArrayList<>(map.values());
    }
}
