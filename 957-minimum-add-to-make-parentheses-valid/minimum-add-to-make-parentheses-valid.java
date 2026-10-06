class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int additions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    // Add an opening parenthesis before this ')'
                    additions++;
                }
            }
        }

        // Add closing parentheses for unmatched '('
        return additions + open;
    }
}