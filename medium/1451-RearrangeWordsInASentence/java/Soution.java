import java.util.Arrays;

class Solution {
    public String arrangeWords(String text) {
        char[] letters = text.toCharArray();
        letters[0] = (char) ((int) letters[0] + 32);
        String[] words = new String(letters).split(" ");
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        String rearranged = String.join(" ", words);
        letters = rearranged.toCharArray();
        letters[0] = (char) ((int) letters[0] - 32);
        return new String(letters);
    }
}