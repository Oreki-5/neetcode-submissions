// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

public class Solution {
    public  List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == 0) {
                    List<Integer> newTriplet = new ArrayList<>();
                    newTriplet.add(nums[i]);
                    newTriplet.add(nums[L]);
                    newTriplet.add(nums[R]);
                    if (!output.contains(newTriplet)) {
                        output.add(newTriplet);
                    }

                    L++;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }

        }

        return output;

    }


}
