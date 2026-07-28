class Solution {
    public boolean isPalindrome(String s) {

        s= s.replaceAll("[!@#$%^&*?/.,\'\":/ ]", "").toLowerCase();
        System.out.println(s);
        String reverse = new StringBuilder(s).reverse().toString();

        return s.trim().equals(reverse);
    }
}
