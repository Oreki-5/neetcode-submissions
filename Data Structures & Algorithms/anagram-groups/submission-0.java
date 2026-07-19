
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            char[] cArr = string.toCharArray();
            Arrays.sort(cArr);
            if (map.containsKey(Arrays.toString(cArr))) {
                map.compute(Arrays.toString(cArr), (k, v) -> {
                    v.add(string);
                    return v;
                });
                
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(string);
                map.put(Arrays.toString(cArr), newList);
            }
        }

        List<List<String>> output = new ArrayList<>();
        map.forEach((k,v)->{
            output.add(v);
        });
        return output;

    }
}
