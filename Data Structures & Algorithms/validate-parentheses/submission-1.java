
class Solution {
    public boolean isValid(String s) {

        List<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if(!map.containsKey(c)){
                    return false;
                }
                stack.addLast(c);
            }
            else if(map.containsKey(c)){
                stack.addLast(c);
            }
            else{
                if(map.get(stack.getLast())==c){
                    stack.removeLast();
                }
                else{
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
