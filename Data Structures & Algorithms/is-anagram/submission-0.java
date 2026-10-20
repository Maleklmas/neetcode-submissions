class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> letters = new HashMap<>();

        for (char c : s.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + -1);
        }

        for (Integer count : letters.values()) {
            if (count != 0)
                return false;
        }
        return true;
    }
}
