
class Solution {
    public boolean hasDuplicate(int[] nums) {

        // [1,2,3,4,5,4]
        // list
        // iterate with for i
        // if List contains -> return 
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(checkList.contains(nums[i])){
                return true;
            }
            checkList.add(nums[i]);
        }

        return false;
    }
}