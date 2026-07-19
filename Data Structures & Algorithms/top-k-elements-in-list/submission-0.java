class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        map.forEach((key, val) -> {
            maxHeap.add(key);
            if (maxHeap.size() > k)
                maxHeap.poll();
        });

        int[] output = new int[k];
        for (int i = 0; i < output.length; i++) {
           output[i]=maxHeap.poll();
        }
        return output;

    }
}
