// import java.util.Arrays;
// import java.util.SortedSet;
// import java.util.TreeSet;
// import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);

        SortedSet<Integer> set = new TreeSet<>();
        set.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int maxSeqLen = 1;
        int counter = 1;
        for (int i = 1; i < set.size(); i++) {
            if ((int) set.toArray()[i] - (int) set.toArray()[i - 1] == 1) {
                counter++;
            } else {
                if (maxSeqLen < counter) {
                    maxSeqLen = counter;

                }
                counter = 1;
            }
            if (i + 1 == set.size() && maxSeqLen < counter) {
                maxSeqLen = counter;
            }

        }
        return maxSeqLen;
    }
}
