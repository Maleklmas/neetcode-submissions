

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        // Step 2: Create buckets based on frequency
        List<Integer>[] buckets = new List[nums.length + 1];

        // Step 3: Put each number into its frequency bucket
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null)
                buckets[frequency] = new ArrayList<>();

            buckets[frequency].add(num);
        }

        // Step 4: Collect the k most frequent numbers
        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1; frequency >= 1; frequency--) {
            if (buckets[frequency] != null) {
                for (int num : buckets[frequency]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
