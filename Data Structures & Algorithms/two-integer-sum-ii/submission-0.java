// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int[] output = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])){
                output[0]=map.get(numbers[i]);
                output[1]=i+1;
                return output;
            }
            map.put((target-numbers[i]), i+1);
        }

        return null;
    }

    
}
